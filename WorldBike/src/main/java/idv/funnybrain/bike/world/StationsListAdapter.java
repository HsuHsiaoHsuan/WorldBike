package idv.funnybrain.bike.world;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import idv.funnybrain.bike.world.data.BikeStation;

/**
 * Created by freeman on 2014/4/28.
 */
public class StationsListAdapter extends BaseAdapter {
    String[] idx;
    LayoutInflater layoutInflater;

    public StationsListAdapter(LayoutInflater inflater) {
        layoutInflater = inflater;

        idx = new String[FunnyActivity.stations_list_new.size()];
        FunnyActivity.stations_list_new.keySet().toArray(idx);
    }

    @Override
    public int getCount() {
        return idx.length;
    }

    @Override
    public Object getItem(int position) {
        return FunnyActivity.stations_list_new.get(idx[position]);
    }

    @Override
    public long getItemId(int position) {
        return Long.valueOf(idx[position]);
    }

    static class ViewHolder {
        public TextView _id;
        public TextView _name;
        public TextView _address_detail;
        public TextView _bike;
        public TextView _dock;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if(rowView == null) {
            rowView = layoutInflater.inflate(R.layout.cell_stations, null);
            ViewHolder holder = new ViewHolder();
            holder._id = (TextView) rowView.findViewById(R.id._id);
            holder._name = (TextView) rowView.findViewById(R.id._name);
            holder._address_detail = (TextView) rowView.findViewById(R.id._address2);
            holder._bike = (TextView) rowView.findViewById(R.id._bike);
            holder._dock = (TextView) rowView.findViewById(R.id._dock);

            rowView.setTag(holder);
        }
        final ViewHolder holder = (ViewHolder) rowView.getTag();
        BikeStation bikeStation = FunnyActivity.stations_list_new.get(idx[position]);
        holder._id.setText(bikeStation._getId());
        holder._name.setText(bikeStation._getName());
        holder._address_detail.setText(bikeStation._getAddress());
        holder._bike.setText(bikeStation._getBike());
        holder._dock.setText(bikeStation._getDock());
        return rowView;
    }
}
