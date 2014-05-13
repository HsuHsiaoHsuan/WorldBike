package idv.funnybrain.bike.world.data;

import java.util.HashMap;

/**
 * Created by Freeman on 2014/5/13.
 */
public interface IParser {
    public boolean hasValue();

    public String getLastUpdate();

    public HashMap<String, IStation> getStationList();
}
