package idv.funnybrain.bike.world.data;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by freeman on 2014/5/14.
 */
public class ParserTaipei implements IParser {
    private static final boolean D = true;
    private static final String TAG = "ParserTaipei";

    private String lastUpdate;
    private static HashMap<String, IStation> stations_list = new HashMap<String, IStation>();

    public ParserTaipei(JSONObject input) throws JSONException, IOException {

    }

    @Override
    public boolean hasValue() {
        return false;
    }

    @Override
    public String getLastUpdate() {
        return null;
    }

    @Override
    public HashMap<String, IStation> getStationList() {
        return null;
    }
}
