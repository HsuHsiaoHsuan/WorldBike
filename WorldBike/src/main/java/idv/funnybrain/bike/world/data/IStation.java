package idv.funnybrain.bike.world.data;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Freeman on 2014/5/13.
 */
public interface IStation {
    public String getId();

    public String getStationName();

    public String toString();

    public LatLng getLatLng();

    public String getAddress();

    public int getAvailableBikes();

    public int getAvailableDocks();
}
