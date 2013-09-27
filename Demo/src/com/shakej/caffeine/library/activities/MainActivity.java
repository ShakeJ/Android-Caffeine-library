package com.shakej.caffeine.library.activities;

import com.shakej.caffeine.library.R;
import com.shakej.caffeine.library.controllers.MainListAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity
{
   private ListView _listView;
   private MainListAdapter _listAdapter;
   
   
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.act_main);
      
      _listView = (ListView) findViewById(R.id.listview_menu);
      _listAdapter = new MainListAdapter();
   }
   
}
