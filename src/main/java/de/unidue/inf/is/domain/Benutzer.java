package de.unidue.inf.is.domain;


public class Benutzer {
    private int bid ;
    private String name;
    private String email;


    public Benutzer ( int bid, String name, String email) {
        this.bid = bid;
        this.name = name;
        this.email = email;
    }
    public Benutzer(){
        this.bid = 1;
        this.name = "Mr.Herrman";
        this.email = "max@herrman.com";
    }
    public String getName() {
        return name;
    }
    public void setName (String Name ) {
        this.name = Name ;
    }
    public String getEmail () {
        return email;
    }
    public void setEmail (String Email ) {
        this.email = Email ;
    }
    public int getBid () {
        return bid ;
    }
    public void setBid (int bid) {
        this.bid = bid;
    }
}