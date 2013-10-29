package caffeine.databases;

import static android.provider.BaseColumns._ID;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import caffeine.utils.Logg;

/**
 * This is example code
 * @author shakej
 */
public class TestTable extends BaseTestTable
{
   protected static TestTable _instance;
   
   // Table
   public final static String TABLE = "tests";
   
   // Field
   public static final String DATE = "date";
   public static final String NAME = "name";
   
   // Filed list
   private static final String[] COLUMNS = { _ID, DATE, NAME };
   
   // Sort
   private static final String ORDER_BY_DEFAULT = DATE + " asc, " + _ID + " asc";
   private static final String ORDER_BY_NAME = NAME + " asc, " + _ID + " asc";
   private static final String ORDER_BY_DATE_DESC = DATE + " desc, " + _ID + " desc";
   private static final String ORDER_BY_NAME_DESC = NAME + " desc, " + _ID + " desc";
   
   // Sort condition
   private static final String WHERE_BY_ID = _ID + "=?";
   private static final String WHERE_BY_DATE = "strftime('%Y'," + DATE + ")=?";
   
   // first sql init
   public static final String createSql = "CREATE TABLE if not exists " + TABLE + "(" + _ID + " integer primary key autoincrement, " + DATE + " text," + NAME + " text);";
   
   
   public synchronized static TestTable instance(Context context)
   {
      if (_instance == null)
         _instance = new TestTable(context);
      return _instance;
   }
   
   
   private TestTable(Context context)
   {
      super(context);
   }
   
   
   /**
    * Insert
    * @param date
    * @param name
    * @return
    */
   public int insert(String date, String name)
   {
      ContentValues values = new ContentValues();
      values.put(DATE, date.trim());
      values.put(NAME, name.trim());
      db().insertOrThrow(TABLE, null, values);
      return super.insert();
   }
   
   
   /**
    * Sort by name
    * @param isDesc
    * @return
    */
   public Cursor loadByName(boolean isDesc)
   {
      String order = ORDER_BY_NAME;
      if (isDesc)
         order = ORDER_BY_NAME_DESC;
      Cursor c = db().query(TABLE, COLUMNS, null, null, null, null, order);
      
      Logg.i("TestTable | getByName()", "Count : " + c.getCount());
      
      return c;
   }
   
   
   /**
    * Sort by date
    * @param isDesc
    * @return
    */
   public Cursor loadByDate(boolean $isDesc)
   {
      String order = ORDER_BY_DEFAULT;
      if ($isDesc)
         order = ORDER_BY_DATE_DESC;
      Cursor c = db().query(TABLE, COLUMNS, null, null, null, null, order);
      
      Logg.i("TestTable | getByDate()", c.getCount() + "개");
      
      return c;
   }
   
   
   /**
    * Sort by date
    * @param year
    * @return
    */
   public Cursor loadByDate(String year)
   {
      String[] selectionArgs = { year };
      return db().query(TABLE, COLUMNS, WHERE_BY_DATE, selectionArgs, null, null, ORDER_BY_DEFAULT);
   }
   
   
   /**
    * Update
    * @param id
    * @param name
    * @param date
    * @return
    */
   public int update(String id, String name, String date)
   {
      ContentValues values = new ContentValues();
      values.put(NAME, name);
      values.put(DATE, date);
      
      String[] whereArgs = { id };
      
      return db().update(TABLE, values, WHERE_BY_ID, whereArgs);
   }
   
   
   /**
    * DeleteAll
    */
   public void deleteAll()
   {
      db().delete(TABLE, null, null);
   }
   
   
   /**
    * Delete by id
    * @param id
    * @return
    */
   public int deleteById(String id)
   {
      String[] whereArgs = { id };
      return db().delete(TABLE, WHERE_BY_ID, whereArgs);
   }
}
