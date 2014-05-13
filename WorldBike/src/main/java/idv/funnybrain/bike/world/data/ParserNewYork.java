package idv.funnybrain.bike.world.data;

import android.util.Log;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Freeman on 2014/5/13.
 */
public class ParserNewYork implements IParser {
    private static final boolean D = true;
    private static final String TAG = "ParserNewYork";

    private String lastUpdate;
    private static HashMap<String, IStation> stations_list = new HashMap<String, IStation>();

    public ParserNewYork(JSONObject input) throws JSONException, IOException {
        lastUpdate = input.getString("executionTime");

        String data = input.getString("stationBeanList");
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(data);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        BikeNewYork[] stationList = mapper.readValue(parser, BikeNewYork[].class);

        stations_list.clear();
        for (BikeNewYork sbl : stationList) {
            stations_list.put(sbl.getId(), sbl);
            if (D) {
                Log.d(TAG, "----> getData: " + sbl.toString());
            }
        }
        if (stations_list.size() > 0) {
            if (D) {
                Log.d(TAG, "----> getData, stations_list size: " + stations_list.size());
            }
        }
    }

    @Override
    public boolean hasValue() {
        if(stations_list.size() > 0) { return true; }
        return false;
    }

    @Override
    public String getLastUpdate() {
        if(lastUpdate != null) { return lastUpdate; }
        return "";
    }

    @Override
    public HashMap<String, IStation> getStationList() {
        return stations_list;
    }
}
