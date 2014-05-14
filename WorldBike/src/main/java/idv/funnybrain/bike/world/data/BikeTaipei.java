package idv.funnybrain.bike.world.data;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Freeman on 2014/5/14.
 */
public class BikeTaipei implements IStation {
    private String iid;
    private int sv;
    private long sd;
    private int vtyp;
    private String sno;
    private String sna;
    private String sip;
    private int tot;
    private int sbi;
    private String sarea;
    private long mday;
    private Double lat;
    private Double lng;
    private String ar;
    private String sareaen;
    private String snaen;
    private String aren;
    private int nbcnt;
    private int bemp;
    private int act;

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public int getSv() {
        return sv;
    }

    public void setSv(int sv) {
        this.sv = sv;
    }

    public long getSd() {
        return sd;
    }

    public void setSd(long sd) {
        this.sd = sd;
    }

    public int getVtyp() {
        return vtyp;
    }

    public void setVtyp(int vtyp) {
        this.vtyp = vtyp;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSna() {
        return sna;
    }

    public void setSna(String sna) {
        this.sna = sna;
    }

    public String getSip() {
        return sip;
    }

    public void setSip(String sip) {
        this.sip = sip;
    }

    public int getTot() {
        return tot;
    }

    public void setTot(int tot) {
        this.tot = tot;
    }

    public int getSbi() {
        return sbi;
    }

    public void setSbi(int sbi) {
        this.sbi = sbi;
    }

    public String getSarea() {
        return sarea;
    }

    public void setSarea(String sarea) {
        this.sarea = sarea;
    }

    public long getMday() {
        return mday;
    }

    public void setMday(long mday) {
        this.mday = mday;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getAr() {
        return ar;
    }

    public void setAr(String ar) {
        this.ar = ar;
    }

    public String getSareaen() {
        return sareaen;
    }

    public void setSareaen(String sareaen) {
        this.sareaen = sareaen;
    }

    public String getSnaen() {
        return snaen;
    }

    public void setSnaen(String snaen) {
        this.snaen = snaen;
    }

    public String getAren() {
        return aren;
    }

    public void setAren(String aren) {
        this.aren = aren;
    }

    public int getNbcnt() {
        return nbcnt;
    }

    public void setNbcnt(int nbcnt) {
        this.nbcnt = nbcnt;
    }

    public int getBemp() {
        return bemp;
    }

    public void setBemp(int bemp) {
        this.bemp = bemp;
    }

    public int getAct() {
        return act;
    }

    public void setAct(int act) {
        this.act = act;
    }

    @Override
    public String getId() {
        return iid;
    }

    @Override
    public String getStationName() {
        return sna;
    }

    @Override
    public LatLng getLatLng() {
        return new LatLng(this.lat, this.lng);
    }

    @Override
    public String getAddress() {
        return ar;
    }

    @Override
    public int getAvailableBikes() {
        return 0;
    }

    @Override
    public int getAvailableDocks() {
        return 0;
    }
}
