package caffeine.utils;

import android.util.Log;

/**
 * release 모드에서 log 표시 안하게
 * @author susemi99
 */
public class Logg
{
   
   private Logg()
   {
   }
   
   
   /**
    * verbose
    * @param $tag
    * @param $msg
    */
   public static void v(String $tag, String $msg)
   {
      if (SystemUtil.isDebuggable())
         Log.v($tag, $msg);
   }
   
   
   /**
    * debug
    * @param $tag
    * @param $msg
    */
   public static void d(String $tag, String $msg)
   {
      if (SystemUtil.isDebuggable())
         Log.d($tag, $msg);
   }
   
   
   /**
    * info
    * @param $tag
    * @param $msg
    */
   public static void i(String $tag, String $msg)
   {
      if (SystemUtil.isDebuggable())
         Log.i($tag, $msg);
   }
   
   
   /**
    * warning
    * @param $tag
    * @param $msg
    */
   public static void w(String $tag, String $msg)
   {
      if (SystemUtil.isDebuggable())
         Log.w($tag, $msg);
   }
   
   
   /**
    * error
    * @param $tag
    * @param $msg
    */
   public static void e(String $tag, String $msg)
   {
      if (SystemUtil.isDebuggable())
         Log.e($tag, $msg);
   }
   
}
