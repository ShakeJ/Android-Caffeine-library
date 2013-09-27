package caffeine.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class DisplayUtil
{
   /**
    * Screen Width, Height 가져오기 <br>
    * The screen width and height
    * @return x=width, y=height
    */
   public static Point screenSize()
   {
      Point point = new Point();
      ((WindowManager) ContextUtil.CONTEXT.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getSize(point);
      return point;
   }
   
   
   /**
    * 가로모드인지 여부 판단 <br>
    * Is Landscape mode?
    * @return true=landscape
    */
   public static boolean isLandscape()
   {
      Point point = screenSize();
      return point.x > point.y;
   }
   
   
   /**
    * 화면이 꺼질 때까지 걸리는 시간 가져오기 <br>
    * Return phone light wake time.
    * @return time
    */
   public static int screenOffDuration()
   {
      return Settings.System.getInt(ContextUtil.CONTEXT.getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT, 15000);
   }
   
   
   /**
    * 화면이 켜져있는지 여부 판단 <br>
    * Is screen on?
    * @return true=on
    */
   public static boolean isScreenOn()
   {
      PowerManager powerManger = (PowerManager) ContextUtil.CONTEXT.getSystemService(Context.POWER_SERVICE);
      return powerManger.isScreenOn();
   }
   
   
   /**
    * 기기의 액정 사이즈를 Inch로 가져오기 <br>
    * Return device inch
    * @param activity
    * @return
    */
   public static double deviceInch(Activity activity)
   {
      DisplayMetrics matrix = new DisplayMetrics();
      activity.getWindowManager().getDefaultDisplay().getMetrics(matrix);
      
      int width = matrix.widthPixels;
      int height = matrix.heightPixels;
      
      float xdpi = matrix.xdpi;
      float ydpi = matrix.ydpi;
      
      float x_inch = width / xdpi;
      float y_inch = height / ydpi;
      
      double display = Math.sqrt(x_inch * x_inch + y_inch * y_inch);
      return display;
   }
   
   
   /**
    * 기기의 액정 사이즈가 10인치인지 여부 판단 <br>
    * Is 10-inch?
    * @param true=10inch
    */
   public static boolean isTenInch(Context context)
   {
      return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_XLARGE;
   }
   
   
   /**
    * 기기가 태블릿인지의 여부 판단 <br>
    * Is tablet?
    * @param context
    * @return true=tablet
    */
   public static boolean isTablet(Context context)
   {
      return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
   }
}
