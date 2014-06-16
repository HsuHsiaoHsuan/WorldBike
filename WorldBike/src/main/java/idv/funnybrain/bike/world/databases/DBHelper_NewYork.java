package idv.funnybrain.bike.world.databases;

import android.content.Context;

/**
 * Created by Freeman on 2014/5/21.
 */
public class DBHelper_NewYork extends DBHelper {

    public DBHelper_NewYork(Context context) {
        super(context, "db_NewYork", null, 0);
        _DB_TABLE = "db_NewYork";
    }
}
