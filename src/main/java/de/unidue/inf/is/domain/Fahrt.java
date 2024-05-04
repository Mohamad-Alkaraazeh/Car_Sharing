package de.unidue.inf.is.domain;

import java.util.Date;

public class Fahrt{
    private int fid ;
    private String startort ;
    private String zielort  ;
    private Date fahrtdatumzeit;
    private int maxplaetze;
    private int fahrtkosten;
    private String status ;
    private String beschreibung;
    private  int transportmittel;
    private Benutzer anbieter;

    public Fahrt(int fid, String startort,String zielort, Date fahrtdatumzeit, int maxplaetze,
                 int fahrtkosten, String status,String beschreibung,int transportmittel,Benutzer anbieter ) {
        this.fid = fid;
        this.startort = startort;
        this.zielort = zielort;
        this.fahrtdatumzeit = fahrtdatumzeit;
        this.maxplaetze = maxplaetze;
        this.fahrtkosten = fahrtkosten;
        this.status = status;
        this.beschreibung = beschreibung;
        this.transportmittel = transportmittel;
        this.anbieter=anbieter;


    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getstartort() {
        return startort;
    }

    public void setstartort(String startort) {
        this.startort = startort;
    }

    public String getZielort() {
        return zielort;
    }

    public void setZielort(String zielort) {
        this.zielort = zielort;
    }

    public Date getFahrtdatum() {
        return fahrtdatumzeit;
    }

    public void setFahrtdatum(Date fahrtdatumzeit) {
        this.fahrtdatumzeit= fahrtdatumzeit;
    }

    public int getMaxplaetze() {
        return maxplaetze;
    }

    public void setMaxplaetze(int maxplaetze) {
        this.maxplaetze = maxplaetze;
    }

    public float getFahrtkosten() {
        return fahrtkosten;
    }

    public void setFahrtkosten(int fahrtkosten) {
        this.fahrtkosten = fahrtkosten;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getBeschreibung() {
        return beschreibung;
    }
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
    public int getTransportmittel() {
        return transportmittel;
    }
    public void setTransportmittel(int transportmittel) {
        this.transportmittel = transportmittel;
    }

    public Benutzer getAnbieter() {
        return anbieter;
    }

    public void setAnbieter(Benutzer anbieter) {
        this.anbieter = anbieter;
    }
}