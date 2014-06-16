package idv.funnybrain.bike.world.data;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Freeman on 2014/5/20.
 */
public abstract class DataParser {
    protected String _lastUpdate = "";

    protected HashMap<String, BikeStation> _station_list = new HashMap<String, BikeStation>();

    public abstract String _getURL();

    public String getLastUpdate() {
        return _lastUpdate;
    }

    public abstract void _parseData(JSONObject input);

    public HashMap<String, BikeStation> getStationList() {
        return _station_list;
    }
}
