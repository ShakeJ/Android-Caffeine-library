package caffeine.utils;

public class GeoUtil
{
   public static int at(String[] array, String str, int defaultValue)
   {
      int len = array.length;
      for (int i = 0; i < len; i++)
      {
         if (str.equalsIgnoreCase(array[i]))
         {
            return i;
         }
      }
      return defaultValue;
   }
   
   
   public static int at(int[] array, int intValue, int defaultValue)
   {
      int len = array.length;
      for (int i = 0; i < len; i++)
      {
         if (intValue == array[i])
         {
            return i;
         }
      }
      return defaultValue;
   }
   
   
   public static float radianFromAngle(float angle)
   {
      return (float) (angle / (180 / Math.PI));
   }
   
   
   public static double degreeWithAnchorAndMoveXY(float anchorX, float anchorY, float moveX, float moveY)
   {
      float disX = moveX - anchorX;
      float disY = moveY - anchorY;
      
      double radian = Math.atan2((double) disY, (double) disX);
      double degree = Math.toDegrees(radian);
      
      return degree;
      
   }
   
   
   public static double radianWithAnchorAndMoveXY(float anchorX, float anchorY, float moveX, float moveY)
   {
      float disX = moveX - anchorX;
      float disY = moveY - anchorY;
      
      double radian = Math.atan2((double) disY, (double) disX);
      
      return radian;
   }
   
   
   public static float scaleRatioToFit(float originalWid, float originalHei, float frameWid, float frameHei, boolean stretch)
   {
      float widRatio = originalWid / frameWid;
      float heiRatio = originalHei / frameHei;
      float ratio = 1.0f;
      if (stretch)
      {
         float kMin = Math.min(widRatio, heiRatio);
         ratio = 1.0f / kMin;
      }
      else
      {
         if (widRatio < 1 && heiRatio < 1)
         {
            ratio = 1.0f;
         }
         else
         {
            float kMax = Math.max(widRatio, heiRatio);
            ratio = 1.0f / kMax;
         }
      }
      return ratio;
   }
}
