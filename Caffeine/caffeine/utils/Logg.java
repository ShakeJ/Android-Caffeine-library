package caffeine.utils;

import android.util.Log;

/**
 * In Release mode, not print log.
 * @author shakej
 */
public class Logg
{
   
   private Logg()
   {
   }
   
   
   /**
    * Verbose
    * @param tag
    * @param msg
    */
   public static void v(String tag, String msg)
   {
      if (SystemUtil.isDebuggable())
         Log.v(tag, msg);
   }
   
   
   /**
    * Debug
    * @param tag
    * @param msg
    */
   public static void d(String tag, String msg)
   {
      if (SystemUtil.isDebuggable())
         Log.d(tag, msg);
   }
   
   
   /**
    * Info
    * @param tag
    * @param msg
    */
   public static void i(String tag, String msg)
   {
      if (SystemUtil.isDebuggable())
         Log.i(tag, msg);
   }
   
   
   /**
    * Warning
    * @param tag
    * @param msg
    */
   public static void w(String tag, String msg)
   {
      if (SystemUtil.isDebuggable())
         Log.w(tag, msg);
   }
   
   
   /**
    * Error
    * @param tag
    * @param msg
    */
   public static void e(String tag, String msg)
   {
      if (SystemUtil.isDebuggable())
         Log.e(tag, msg);
   }
   
}
