package idv.funnybrain.bike.world.data;

/**
 * Created by Freeman on 2014/5/20.
 */
public class BikeStation_NewYork extends BikeStation {
    private String id;
    private String stationName;
    private String availableDocks;
    private String totalDocks;
    private String latitude;
    private String longitude;
    private String statusValue;
    private String statusKey;
    private String availableBikes;
    private String stAddress1;
    private String stAddress2;
    private String city;
    private String postalCode;
    private String location;
    private String altitude;
    private boolean testStation;
    private String lastCommunicationTime;
    private String landMark;

    public void setId(String id) {
        _Id = id;
    }

    public void setStationName(String stationName) {
        _Name = stationName;
    }

    public void setAvailableDocks(String availableDocks) {
        _Dock = availableDocks;
    }

    public void setLatitude(String latitude) {
        _Latitude = latitude;
    }

    public void setLongitude(String longitude) {
        _Longitude = longitude;
    }

    public void setAvailableBikes(String availableBikes) {
        _Bike = availableBikes;
    }

    public void setStAddress1(String stAddress1) {
        //_Address = stAddress1;
    }

    public void setStAddress2(String stAddress2) {
        _Address = stAddress2;
        _Address_Detail = stAddress2;
    }
}
