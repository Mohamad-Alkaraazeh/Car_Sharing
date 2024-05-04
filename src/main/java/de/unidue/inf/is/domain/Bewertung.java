package de.unidue.inf.is.domain;


import java.sql.Date;

public class Bewertung {
    private Benutzer benutzer;
    private  int beid;
    private  String textnachricht;
    private Date erstellungsdatum;
    private int rating;

    public Bewertung (Benutzer benutzer, String textnachricht, Date erstellungsdatum, int rating){

        this.benutzer=benutzer;
        this.erstellungsdatum=erstellungsdatum;
        this.textnachricht=textnachricht;
        this.rating=rating;
    }

    public Benutzer getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(Benutzer benutzer) {
        this.benutzer = benutzer;
    }

    public int getBeid() {
        return beid;
    }

    public void setBeid(int beid) {
        this.beid = beid;
    }

    public String getTextnachricht() {
        return textnachricht;
    }

    public void setTextnachricht(String textnachricht) {
        this.textnachricht = textnachricht;
    }

    public Date getErstellungsdatum() {
        return erstellungsdatum;
    }

    public void setErstellungsdatum(Date erstellungsdatum) {
        this.erstellungsdatum = erstellungsdatum;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
