package idv.funnybrain.bike.world.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Freeman on 2014/5/21.
 */
public abstract class DBHelper extends SQLiteOpenHelper {
    private static final String TAG = "DBHelper";
    private static final boolean D = true;

    private static final String DB_FILE = "station.db";
    private static final int DB_VERSION = 2;
//    public static final String DB_TABLE = "bike";
    protected String _DB_TABLE;
    protected static final String DB_COL_ID = "_id";
    protected static final String DB_COL_STATION_ID = "station_id";
    private String DB_CREATE = "CREATE TABLE " + _DB_TABLE + " (" +
            DB_COL_ID + " INTEGER PRIMARY KEY," +
            DB_COL_STATION_ID + " TEXT NOT NULL UNIQUE)";

    protected SQLiteDatabase _db;
    protected Context _mContext;
    protected SQLiteDatabase _sqLiteDatabase;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_FILE, null, DB_VERSION);
        if(D) { Log.d(TAG, "----> constructor: " + DB_FILE + ", " + DB_VERSION); }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        if(D) { Log.d(TAG, "----> onCreate, " + db.getPath() + ", " + _DB_TABLE); }
        this._db = db;
        DB_CREATE = "CREATE TABLE " + _DB_TABLE + " (" +
                DB_COL_ID + " INTEGER PRIMARY KEY," +
                DB_COL_STATION_ID + " TEXT NOT NULL UNIQUE)";
        if(D) { Log.d(TAG, "----> onCreate, " + DB_CREATE); }
        db.execSQL(DB_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(D) { Log.d(TAG, "----> onUpgrade, " + _DB_TABLE); }
        db.execSQL("DROP TABLE IF EXISTS " + _DB_TABLE);
        onCreate(db);
    }

    public long insertFavor(ContentValues values) {
        if(D) { Log.d(TAG, "----> insertFavor"); }
        _db = getWritableDatabase();
        long result = 0L;
        try {
            result = _db.insert(_DB_TABLE, null, values);
        } catch(SQLiteConstraintException sqlce) {
            return result;
        }finally {
        }
        return result;
    }

    public Cursor queryAll() {
        if(D) { Log.d(TAG, "----> queryAll, " + _DB_TABLE); }
        _db = getReadableDatabase();
        Cursor cursor = _db.query(_DB_TABLE, new String[] {DB_COL_ID, DB_COL_STATION_ID}, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            return cursor;
        }
        return null;
    }

    public boolean queryIsFavor(String id) {
        if(D) { Log.d(TAG, "----> queryIsFavor, query id: " + id); }
        _db = getReadableDatabase();
        Cursor cursor = _db.query(_DB_TABLE, new String[] {DB_COL_STATION_ID}, DB_COL_STATION_ID + "=?", new String[]{id}, null, null, null);
        int index = cursor.getColumnIndexOrThrow(DB_COL_STATION_ID);
        if(cursor != null) {
//            if(D) Log.d(TAG, "query(id) : cursor not null, count: " + cursor.getCount());
            if(cursor.moveToFirst()) {
//                if(D) Log.d(TAG, "return true");
                return true;
            } else {
//                if(D) Log.d(TAG, "return false");
                _db.close();
                return false;
            }
        } else {
//            if(D) Log.d(TAG, "query(id) : cursor null");
            return false;
        }
    }

    public int removeFavor(String id) {
        if(_db == null) {
            _db = getWritableDatabase();
        }
        int result = _db.delete(_DB_TABLE, DB_COL_STATION_ID + "=?", new String[]{id});
        return result;
    }

    public void close() {
        if(_db != null) {
            _db.close();
        }
    }
}
