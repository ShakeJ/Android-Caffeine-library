package com.shakej.caffeine.library;

import caffeine.utils.ContextUtil;
import caffeine.utils.SystemUtil;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity
{
   
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.act_main);
      
      Log.w("shakej", "is Connect WI-FI? " + SystemUtil.isConnectedWiFi());
   }
   
   
   @Override
   public boolean onCreateOptionsMenu(Menu menu)
   {
      getMenuInflater().inflate(R.menu.main, menu);
      return true;
   }
}
