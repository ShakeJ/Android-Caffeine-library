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
    * Is Landscape mode?
    * @return true=landscape
    */
   public static boolean isLandscape()
   {
      Point point = screenSize();
      return point.x > point.y;
   }
   
   
   /**
    * Return phone light wake time.
    * @return time
    */
   public static int screenOffDuration()
   {
      return Settings.System.getInt(ContextUtil.CONTEXT.getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT, 15000);
   }
   
   
   /**
    * Is screen on?
    * @return true=on
    */
   public static boolean isScreenOn()
   {
      PowerManager powerManger = (PowerManager) ContextUtil.CONTEXT.getSystemService(Context.POWER_SERVICE);
      return powerManger.isScreenOn();
   }
   
   
   /**
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
   
   
   /*
    * Is 10-inch?
    * @param true=10inch
    */
   public static boolean isTenInch(Context context)
   {
      return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_XLARGE;
   }
   
   
   /**
    * Is tablet?
    * @param context
    * @return true=tablet
    */
   public static boolean isTablet(Context context)
   {
      return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
   }
}
