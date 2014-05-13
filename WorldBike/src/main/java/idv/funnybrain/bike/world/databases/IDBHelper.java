package idv.funnybrain.bike.world.databases;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * Created by Freeman on 2014/5/13.
 */
public interface IDBHelper {
    public long insertFavor(ContentValues values);

    public Cursor queryAll();

    public boolean queryIsFavor(String id);

    public int removeFavor(String id);

    public void close();
}
