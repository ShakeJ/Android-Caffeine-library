package caffeine.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferenceUtil
{
   private static SharedPreferences _preference;
   
   
   public static SharedPreferences instance()
   {
      if (_preference == null)
         _preference = PreferenceManager.getDefaultSharedPreferences(ContextUtil.CONTEXT);
      return _preference;
   }
   
   
   public static SharedPreferences instance(Context context)
   {
      ContextUtil.CONTEXT = context;
      
      if (_preference == null)
         _preference = PreferenceManager.getDefaultSharedPreferences(context);
      return _preference;
   }
   
   
   /**
    * <br>
    * put string value
    * @param key
    * @param value (String)
    */
   public static void put(String key, String value)
   {
      SharedPreferences p = instance();
      SharedPreferences.Editor editor = p.edit();
      editor.putString(key, value);
      editor.commit();
   }
   
   
   /**
    * <br>
    * Get string value
    * @param key
    * @return value (String, default value is null)
    */
   public static String get(String key)
   {
      SharedPreferences p = instance();
      return p.getString(key, null);
   }
   
   
   /**
    * <br>
    * Get string value, default value is ""
    * @param key
    * @return value (String, default value is "")
    */
   public static String getWithNullToBlank(String key)
   {
      SharedPreferences p = instance();
      return p.getString(key, "");
   }
   
   
   /**
    * <br>
    * put boleean value
    * @param key
    * @param value (boolean)
    */
   public static void put(String key, boolean value)
   {
      SharedPreferences p = instance();
      SharedPreferences.Editor editor = p.edit();
      editor.putBoolean(key, value);
      editor.commit();
   }
   
   
   /**
    * <br>
    * Get boolean value
    * @param key
    * @param defalut value
    * @return Boolean
    */
   public static boolean get(String key, boolean defaultValue)
   {
      SharedPreferences p = instance();
      return p.getBoolean(key, defaultValue);
   }
   
   
   /**
    * <br>
    * Put int value
    * @param key
    * @param value
    */
   public static void put(String key, int value)
   {
      SharedPreferences p = instance();
      SharedPreferences.Editor editor = p.edit();
      editor.putInt(key, value);
      editor.commit();
   }
   
   
   /**
    * <br>
    * Get int value
    * @param key
    * @param defalut value
    * @return Int
    */
   public static int get(String key, int defaultValue)
   {
      SharedPreferences p = instance();
      return p.getInt(key, defaultValue);
   }
}
