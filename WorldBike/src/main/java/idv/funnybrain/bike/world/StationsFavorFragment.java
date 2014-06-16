package idv.funnybrain.bike.world;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import idv.funnybrain.bike.world.databases.DBHelper;

/**
 * Created by KuoPiHua on 2014/5/4.
 */
public class StationsFavorFragment extends ListFragment {
    // ---- constant variable START ----
    private static final boolean D = true;
    private static final String TAG = "StationsFavorFragment";
    // ---- constant variable END ----

    // ---- private variable START ----
//    DBHelper_nyc_citibike dbHelperNyccitibike;
    private static DBHelper dbHelper; // new
//    StationsFavorAdapter adapter;
    StationsFavorAdapter adapter_new; // new
    // ---- private variable END ----

    private StationsFavorFragment(DBHelper helper) {
        dbHelper = helper;
    }

//    public static StationsFavorFragment newInstance() {
//        if(D) { Log.d(TAG, "newInstance"); }
//        StationsFavorFragment f = new StationsFavorFragment();
//        Bundle bundle = f.getArguments();
//        if(bundle == null) {
//            bundle = new Bundle();
//        }
//        f.setArguments(bundle);
//        return f;
//    }

    public static StationsFavorFragment newInstance(DBHelper city) {
        StationsFavorFragment f = new StationsFavorFragment(city);
        Bundle bundle = f.getArguments();
        if(bundle == null) {
            bundle = new Bundle();
        }
        f.setArguments(bundle);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_stations, null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        dbHelperNyccitibike = new DBHelper_nyc_citibike(this.getActivity());
//        Cursor cursor = dbHelperNyccitibike.queryAll();
//        int idx = cursor.getColumnIndexOrThrow("station_id");
//        cursor.moveToFirst();
//
//        adapter = new StationsFavorAdapter(getActivity(), dbHelperNyccitibike.queryAll(), true);
//        setListAdapter(adapter);

        Cursor cursor_new = dbHelper.queryAll(); // new
//        int idx_new = cursor_new.getColumnIndexOrThrow("station_id"); // new
        cursor_new.moveToFirst(); // new

        adapter_new = new StationsFavorAdapter(getActivity(), dbHelper.queryAll(), true); // new
        setListAdapter(adapter_new);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        ((FunnyActivity) getActivity()).updateMap(String.valueOf(id));
    }

    public void dataChanged() {
//        adapter.changeCursor(dbHelperNyccitibike.queryAll());
        adapter_new.changeCursor(dbHelper.queryAll());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        if(dbHelperNyccitibike != null) {
//            dbHelperNyccitibike.close();
//        }
        if(dbHelper != null) {
            dbHelper.close();
        }
    }
}
