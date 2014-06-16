package idv.funnybrain.bike.world;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import idv.funnybrain.bike.world.data.BikeStation;
import idv.funnybrain.bike.world.databases.DBHelper_nyc_citibike;

/**
 * Created by KuoPiHua on 2014/5/4.
 */
public class StationsFavorAdapter extends CursorAdapter {
    // ---- constant variable START ----
    // ---- constant variable END ----

    // ---- local variable START ----
    private LayoutInflater layoutInflater;
    //private Context mContext;
    //private Cursor mCursor;
    // ---- local variable END ----

    public StationsFavorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        this.layoutInflater = LayoutInflater.from(context);
        //this.mContext = context;
        //this.mCursor = c;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return layoutInflater.inflate(R.layout.cell_stations, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String idx = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper_nyc_citibike.DB_COL_STATION_ID));
        BikeStation tmpStation = FunnyActivity.stations_list_new.get(idx);

        TextView id = (TextView) view.findViewById(R.id._id);
        id.setText(idx);

        TextView name = (TextView) view.findViewById(R.id._name);
        name.setText(tmpStation._getName());

        TextView address2 = (TextView) view.findViewById(R.id._address2);
        address2.setText(tmpStation._getAddress());

        TextView bike = (TextView) view.findViewById(R.id._bike);
        bike.setText(tmpStation._getBike());

        TextView dock = (TextView) view.findViewById(R.id._dock);
        dock.setText(tmpStation._getDock());
    }

    @Override
    public long getItemId(int position) {
        Cursor cursor = getCursor();
        cursor.moveToPosition(position);
        String idx = cursor.getString(mCursor.getColumnIndexOrThrow(DBHelper_nyc_citibike.DB_COL_STATION_ID));
        return Long.valueOf(idx);
    }
}
