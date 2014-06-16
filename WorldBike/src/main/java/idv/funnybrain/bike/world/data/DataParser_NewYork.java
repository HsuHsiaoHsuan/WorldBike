package idv.funnybrain.bike.world.data;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Freeman on 2014/5/20.
 */
public class DataParser_NewYork extends DataParser {
    private static final String TAG = "DataParser_NewYork";

    @Override
    public String _getURL() {
        return "http://citibikenyc.com/stations/json";
    }

    @Override
    public void _parseData(JSONObject input) {
        try {
            _lastUpdate = input.getString("executionTime");

            String data = input.getString("stationBeanList");
            JsonFactory factory = new JsonFactory();
            JsonParser parser = factory.createParser(data);
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

            BikeStation_NewYork[] station_array = mapper.readValue(parser, BikeStation_NewYork[].class);
            for(BikeStation bikeStation : station_array) {
                _station_list.put(bikeStation._Id, bikeStation);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
