package idv.funnybrain.bike.world.data;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Freeman on 2014/5/20.
 */
public abstract class BikeStation {
    protected String _Id = "";
    protected String _Name = "";
    protected String _Address = "";
    protected String _Address_Detail = "";
    protected String _Bike = "";
    protected String _Dock = "";
    protected String _Latitude = "";
    protected String _Longitude = "";

    public String _getId() {
        return _Id;
    }

    public String _getName() {
        return _Name;
    }

    public String _getAddress() {
        return _Address;
    }

    public String _getAddress_Detail() {
        return _Address_Detail;
    }

    public String _getBike() {
        return _Bike;
    }

    public String _getDock() {
        return _Dock;
    }

    public LatLng _getLocation() {
        _Latitude = _Latitude.replaceAll("\\p{C}", "");
        _Longitude = _Longitude.replaceAll("\\p{C}", "");
        return new LatLng(Double.valueOf(_Latitude), Double.valueOf(_Longitude));
    }
}
