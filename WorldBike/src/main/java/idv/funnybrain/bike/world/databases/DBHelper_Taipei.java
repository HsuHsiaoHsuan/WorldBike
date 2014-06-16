package idv.funnybrain.bike.world.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Freeman on 2014/5/22.
 */
public class DBHelper_Taipei extends DBHelper{
    private static final String TAG = "DBHelper_Taipei";
    private static final boolean D = true;


    public DBHelper_Taipei(Context context) {
        super(context, "db_Taipei", null, 0);
        _DB_TABLE = "db_Taipei";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //super.onCreate(db);
        _db = db;
        String DB_CREATE = "CREATE TABLE " + _DB_TABLE + " (" +
                DB_COL_ID + " INTEGER PRIMARY KEY," +
                DB_COL_STATION_ID + " TEXT NOT NULL UNIQUE)";
        if(D) { Log.d(TAG, "----> onCreate, " + DB_CREATE); }
        _db.execSQL(DB_CREATE);
    }
}
