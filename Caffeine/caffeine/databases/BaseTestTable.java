package caffeine.databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import caffeine.utils.Logg;

/**
 * This is example code
 * @author shakej
 */
public class BaseTestTable
{
   protected SQLiteOpenHelper _helper;
   
   
   protected BaseTestTable(Context context)
   {
      _helper = new BaseDatabaseHelper(context);
   }
   
   
   protected SQLiteDatabase db()
   {
      return _helper.getWritableDatabase();
   }
   
   
   public void close()
   {
      db().close();
   }
   
   
   protected int insert()
   {
      SQLiteDatabase db = _helper.getWritableDatabase();
      // Return final row id.
      String sql = "SELECT last_insert_rowid();";
      Cursor c = db.rawQuery(sql, null);
      
      int result = 0;
      c.moveToFirst();
      if (c.getCount() > 0)
         result = c.getInt(0);
      c.close();
      
      Logg.w("BaseTestTable | insert()", "low id : " + result + " inserted");
      return result;
   }
}
