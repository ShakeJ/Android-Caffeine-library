package caffeine.activities;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import caffeine.utils.ContextUtil;

public class BaseFragmentActivity extends FragmentActivity
{
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      
      ContextUtil.CONTEXT = getApplicationContext();
      getWindow().setFormat(PixelFormat.RGBA_8888);
   }
   
   
   /**
    * Start Activity
    * @param targetClass
    */
   protected void start(Class<?> targetClass)
   {
      Intent intent = new Intent();
      intent.setClass(this, targetClass);
      startActivity(intent);
   }
   
   
   /**
    * Start Activity with flag
    * @param targetClass
    * @param flag Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK
    */
   
   protected void start(Class<?> targetClass, int flag)
   {
      Intent intent = new Intent();
      intent.setClass(this, targetClass);
      intent.addFlags(flag);
      startActivity(intent);
   }
   
   
   /**
    * StartActivityForResult
    * @param targetClass
    */
   protected void startForResult(Class<?> targetClass, int requestCode)
   {
      Intent intent = new Intent();
      intent.setClass(this, targetClass);
      startActivityForResult(intent, requestCode);
   }
   
   
   /**
    * StartActivityForResult with flag
    * @param targetClass
    * @param flag Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK
    */
   protected void startForResult(Class<?> targetClass, int flag, int requestCode)
   {
      Intent intent = new Intent();
      intent.setClass(this, targetClass);
      intent.addFlags(flag);
      startActivityForResult(intent, requestCode);
   }
}
