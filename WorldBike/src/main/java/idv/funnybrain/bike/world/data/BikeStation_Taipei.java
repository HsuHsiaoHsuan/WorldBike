package idv.funnybrain.bike.world.data;

/**
 * Created by Freeman on 2014/5/21.
 */
public class BikeStation_Taipei extends BikeStation {
    private String iid;
    private String sv;
    private String sd;
    private String vtyp;
    private String sno;
    private String sna;
    private String sip;
    private String tot;
    private String sbi;
    private String sarea;
    private String mday;
    private String lat;
    private String lng;
    private String ar;
    private String sareaen;
    private String snaen;
    private String aren;
    private String nbcnt;
    private String bemp;
    private String act;

    public void setIid(String iid) {
        _Id = iid;
    }

    public void setSna(String sna) {
        _Name = sna;
    }

    public void setAr(String ar) {
        _Address = ar;
    }

    public void setLat(String lat) {
        _Latitude = lat;
    }

    public void setLng(String lng) {
        _Longitude = lng;
    }

    public void setSbi(String sbi) {
        _Bike = sbi;
    }

    public void setBemp(String bemp) {
        _Dock = bemp;
    }
}
