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
 * Created by Freeman on 2014/5/21.
 */
public class DataParser_Taipei extends DataParser {
    private static final String TAG = "DataParser_Taipei";

    @Override
    public String _getURL() {
        return "http://opendata.dot.taipei.gov.tw/opendata/gwjs_cityhall.json";
    }

    @Override
    public void _parseData(JSONObject input) {
        System.out.println("---->" + input.toString());

        try {
            _lastUpdate = "";

            String data = input.getString("retVal");
            JsonFactory factory = new JsonFactory();
            JsonParser parser = factory.createParser(data);
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

            BikeStation_Taipei[] station_array = mapper.readValue(parser, BikeStation_Taipei[].class);
            for (BikeStation bikeStation : station_array) {
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
