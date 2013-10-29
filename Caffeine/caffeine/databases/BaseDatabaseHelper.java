package caffeine.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * This is example code
 * @author shakej
 */
public class BaseDatabaseHelper extends SQLiteOpenHelper
{
   private static final int VERSION = 1;
   
   
   public BaseDatabaseHelper(Context context)
   {
      super(context, context.getPackageName().replaceAll("\\.", "_"), null, VERSION);
   }
   
   
   @Override
   public void onCreate(SQLiteDatabase db)
   {
      // db.execSQL(TestTable.createSql);
   }
   
   
   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
   {
      // db.execSQL("drop table if exists "+TestTable.TABLE);
   }
}
