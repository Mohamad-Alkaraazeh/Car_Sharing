package de.unidue.inf.is.domain;


import java.sql.Date;

public class Fahrerlaubnis {
    private Benutzer benutzer;
    private int nummer  ;
    private Date ablaufdatum;

    public Fahrerlaubnis(Benutzer benutzer, int nummer, Date ablaufdatum) {
        this.benutzer = benutzer;
        this.nummer = nummer;
        this.ablaufdatum = ablaufdatum;
    }

    public Benutzer getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(Benutzer benutzer) {
        this.benutzer = benutzer;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public Date getAblaufdatum() {
        return ablaufdatum;
    }

    public void setAblaufdatum(Date ablaufdatum) {
        this.ablaufdatum = ablaufdatum;
    }
}

