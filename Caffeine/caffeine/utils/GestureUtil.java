package caffeine.utils;

import java.util.ArrayList;

public class GestureUtil
{
   public final static int LEFT = 0;
   public final static int RIGHT = 1;
   public final static int CW = 2;
   public final static int CCW = 3;
   
   private ArrayList<Integer> mXLst;
   private ArrayList<Integer> mYLst;
   private final int EVENT_TIME = 5;
   private final int IGNORE_DIS = 10;
   private int centerX;
   private int centerY;
   
   
   public GestureUtil(int centerX, int centerY)
   {
      initializePosArr();
      this.centerX = centerX;
      this.centerY = centerY;
   }
   
   
   private void initializePosArr()
   {
      mXLst = new ArrayList<Integer>();
      mYLst = new ArrayList<Integer>();
   }
   
   
   public int gestureDirection(int x, int y)
   {
      mXLst.add(x);
      mYLst.add(y);
      
      if (mXLst.size() < EVENT_TIME)
         return -1;
      
      double kDisX = mXLst.get(EVENT_TIME - 1) - mXLst.get(0);
      double kDisY = mYLst.get(EVENT_TIME - 1) - mYLst.get(0);
      
      double kDis = Math.sqrt((double) (kDisX * kDisX) + (double) (kDisY * kDisY));
      
      if (kDis < IGNORE_DIS)
      {
         initializePosArr();
         return -1;
      }
      
      int kDir = -1;
      
      double kAbsDisX = Math.abs(kDisX);
      double kAbsDisY = Math.abs(kDisY);
      try
      {
         if (kAbsDisY < IGNORE_DIS / 2)
         {
            if (kDisX > 0)
            {
               kDir = RIGHT;
            }
            else
            {
               kDir = LEFT;
            }
         }
         else if (kAbsDisX < IGNORE_DIS / 2)
         {
            kDir = -1;
         }
         else
         {
            double kRadian_0 = GeoUtil.radianWithAnchorAndMoveXY((float) centerX, (float) centerY, (float) mXLst.get(0), (float) mYLst.get(0));
            double kRadian_1 = GeoUtil.radianWithAnchorAndMoveXY((float) centerX, (float) centerY, (float) mXLst.get(EVENT_TIME - 1),
                  (float) mYLst.get(EVENT_TIME - 1));
            
            if (kRadian_1 > kRadian_0)
            {
               kDir = CW;
            }
            else
            {
               kDir = CCW;
            }
         }
      }
      catch (Exception e)
      {
         
      }
      
      initializePosArr();
      return kDir;
   }
}
