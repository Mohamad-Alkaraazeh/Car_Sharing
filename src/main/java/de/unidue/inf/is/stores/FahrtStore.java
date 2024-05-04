package de.unidue.inf.is.stores;

import de.unidue.inf.is.domain.Benutzer;
import de.unidue.inf.is.domain.Fahrt;
import de.unidue.inf.is.domain.Transportmittel;
import de.unidue.inf.is.utils.DBUtil;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class FahrtStore implements Closeable {
    private Connection connection;
    private boolean complete;

    public FahrtStore() throws StoreException {
        try {
            connection = DBUtil.getExternalConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new StoreException(e);
        }
    }
    // Offene fahrten
    public List<Fahrt> getAvailableFahrten(Benutzer user) throws StoreException, SQLException {
        int bid = user.getBid();
        List<Fahrt> FahrtListe = new ArrayList<Fahrt>();

        try{
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = connection.prepareStatement(  "select distinct f.fid,f.startort,f.zielort,f.fahrtdatum,f.maxPlaetze,f.fahrtkosten,f.status,f.anbieter,f.transportmittel,f.beschreibung,b.bid,b.name,b.email from(dbp197.reservieren r join dbp197.fahrt f on f.fid=r.fahrt join dbp197.benutzer b  on f.anbieter=b.bid) where f.maxPlaetze > 0 ) except (select distinct f.fid,f.startort,f.zielort,f.fahrtdatumzeit,f.maxPlaetze,f.fahrtkosten,f.status,f.anbieter,f.transportmittel,f.beschreibung b.bid,b.name,b.email from(dbp197.reservieren r join dbp197.fahrt f on f.fid=r.fahrt join dbp197.benutzer b on f.anbieter=b.bid) where r.kunde =?");
            stmt.setInt(1,bid);

            rs = stmt.executeQuery();
            while (rs.next()){
                int fid = rs.getInt("fid");
                Date fahrtdatum =rs.getDate("fahrtdatum");
                String startort = rs.getString("startort");
                String zielort = rs.getString("zielort");
                int maxplaetze = rs.getInt("maxplaetze");
                int fahrtkosten = rs.getInt("fahrtkosten");
                String status = rs.getString("status");
                String beschreibung = rs.getString("beschreibung");
                int transportmittel = rs.getInt("transport");
                int anbieter = rs.getInt("anbieter");
                String bname= rs.getString("bname");
                String email= rs.getString("email");
                Benutzer ersteller= new Benutzer(anbieter,bname, email);
                Fahrt fahrt = new Fahrt(fid, startort, zielort,fahrtdatum,maxplaetze,fahrtkosten,
                        status ,beschreibung,transportmittel, ersteller);
                FahrtListe.add(fahrt);
            }
        }
        catch (SQLException e) {
            throw new StoreException(e);
        }
        return FahrtListe;
    }

    // Meine fahrten
    public List<Fahrt> getUserFahrte(Benutzer user) throws StoreException, SQLException{
        List<Fahrt> FahrtListe = new ArrayList<Fahrt>();
        int bid = user.getBid();
        try {
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = connection.prepareStatement("select distinct f.fid,f.startort,f.zielort,f.fahrtdatum,f.maxPlaetze,f.fahrtkosten,f.status,f.anbieter,f.transportmittel,f.beschreibung,b.bid,b.name,b.email from(dbp197.reservieren r join dbp197.fahrt f on f.fid=r.fahrt join dbp197.benutzer b on f.anbieter=b.bid) where r.kunde=? ");

            stmt.setInt(1, bid);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int fid = rs.getInt("fid");
                Date fahrtdatum = rs.getDate("fahrtdatum");
                String startort = rs.getString("startort");
                String zielort = rs.getString("zielort");
                int maxplaetze = rs.getInt("maxplaetze");
                int fahrtkosten = rs.getInt("fahrtkosten");
                String status = rs.getString("status");
                String beschreibung = rs.getString("beschreibung");
                int transportmittel = rs.getInt("transport");
                int anbieter = rs.getInt("anbieter");
                String bname = rs.getString("bname");
                String email = rs.getString("email");

                Benutzer ersteller = new Benutzer(anbieter, bname, email);
                Fahrt fahrt = new Fahrt(fid, startort, zielort, fahrtdatum, maxplaetze, fahrtkosten,
                        status, beschreibung, transportmittel, ersteller);
                FahrtListe.add(fahrt);
            }
        }catch (SQLException e) {
            throw new StoreException(e);
        }
        return FahrtListe;
    }
    public Fahrt getFahrt(int id) {
        Fahrt fartentoreturn = null;

        try {
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = connection.prepareStatement("select distinct f.fid,f.startort,f.zielort,f.fahrtdatumzeit,f.maxPlaetze,f.fahrtkosten,f.status,f.anbieter,f.transportmittel,f.beschreibung,b.bid,b.name,b.email from(dbp197.reservieren r join dbp197.fahrt f on f.fid=r.fahrt join dbp197.benutzer b on  f.anbieter=b.bid where fid =? ");
            stmt.setInt(1,id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int fid = rs.getInt("fid");
                Date fahrtdatum = rs.getDate("fahrtdatum");
                String startort = rs.getString("startort");
                String zielort = rs.getString("zielort");
                int maxplaetze = rs.getInt("maxplaetze");
                int fahrtkosten = rs.getInt("fahrtkosten");
                String status = rs.getString("status");
                String beschreibung = rs.getString("beschreibung");
                int transportmittel = rs.getInt("transport");
                int anbieter = rs.getInt("anbieter");
                String bname = rs.getString("bname");
                String email = rs.getString("email");

                Benutzer ersteller = new Benutzer(anbieter, bname, email);
                fartentoreturn = new Fahrt(fid, startort, zielort, fahrtdatum, maxplaetze, fahrtkosten,
                        status, beschreibung, transportmittel, ersteller);
            }
        } catch (SQLException e) {
            throw new StoreException(e);
        }
        return fartentoreturn;
    }

    //prüfen ob die parameter für user ist gleich ersteller für fahrt
    public boolean isErsteller(Benutzer user, int fid){
        int bid = user.getBid();
        try{
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = connection.prepareStatement("select anbieter from dbp197.Fahrt where fid = ?" );
            stmt.setInt(1,fid);
            rs = stmt.executeQuery();
            rs.next();
            int anbieter = rs.getInt(1);

            if (anbieter == bid) return true; else return false;

        }
        catch (SQLException e) {
            throw new StoreException(e);
        }

    }
    public void createNewFahrten(String startort, String zielort, String fahrtdatumzeit , String maxplaetze, String fahrtkosten, String transportmittel, String Beschreibung){

        try {
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement("INSERT INTO dbp197.Fahrt (startort,zielort,fahrtdatumzeit,maxplaetze,fahrtkosten,anbieter,transportmittel,Beschreibung) VALUES (?,?,?,?,?,?,?,?)");

            stmt.setString(1,startort);
            stmt.setString(2,zielort);
            stmt.setString(3,fahrtdatumzeit);
            stmt.setString(4,maxplaetze);
            stmt.setString(5,fahrtkosten);
            stmt.setString(7,Beschreibung);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new StoreException(e);
        }
    }
    public void deleteFahrte(int fid) {

        String SQLstmt1 = "DELETE FROM dbp197.Fahrt where fid = ?";

        try (PreparedStatement stmt1 = connection.prepareStatement(SQLstmt1)){
            stmt1.setInt(1, fid);
            stmt1.executeUpdate();

        } catch (SQLException e) {
            throw new StoreException(e);
        }
    }
    //checks if a Fahrt has free places
    public boolean hasFreePlaces(int fid){
        try{
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = connection.prepareStatement("select MaxPlaetze from dbp197.Fahrt where fid = ?" );
            stmt.setInt(1,fid);
            rs = stmt.executeQuery();
            rs.next();
            int maxplaetze = rs.getInt(1);

            if (maxplaetze > 0) return true; else return false;
        }
        catch (SQLException e) {
            throw new StoreException(e);
        }

    }
    //checks if user is reserviert in fahrt
    public boolean reserviertInFahrt(Benutzer kunde, Fahrt fahrt){

        try{
            int bid = kunde.getBid();
            int fid = fahrt.getFid();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = connection.prepareStatement("select * from dbp197.reservieren where kunde = ? and fahrt = ?");
            stmt.setInt(1,bid);
            stmt.setInt(2,fid);
            rs = stmt.executeQuery();
            if (rs.next() == false) return false; else return true;
        } catch (SQLException e) {throw new StoreException(e);}}

    public void fahrtreservieren(Benutzer kunde, Fahrt fahrt,int Anzahlplaetze){
        try {
            int bid = kunde.getBid();
            int fid = fahrt.getFid();
            int Anz = fahrt.getMaxplaetze();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement("INSERT INTO dbp197.reservieren (kunde, fahrt,Anz) VALUES (?,?,?)");
            stmt.setInt(1,bid);
            stmt.setInt(2,fid);
            stmt.setInt(3,Anz);
            stmt.executeUpdate();
            decrementmaxplaetze(fid);
        } catch (SQLException e) {throw new StoreException(e);}}

    public void decrementmaxplaetze(int fid){
        try {
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement("UPDATE dbp197.Fahrt f SET f.maxplaetze = f.maxplaetze - 1 Where f.fid = ?");
            stmt.setInt(1,fid);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new StoreException(e);
        }

    }
    public void insertBewertung (int beid,String textnachricht, java.sql.Date Erstellungsdatum, int Rating){
        try {

            Benutzer user = new Benutzer();
            //int beid = user.getBid();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement("INSERT INTO dbp197.bewertung (beid, textnachricht, Erstellungsdatum, Rating) VALUES (?,?,?,?)");
            stmt.setInt(1,beid);
            stmt.setString(2,textnachricht);
            stmt.setDate(3,Erstellungsdatum);
            stmt.setInt(4,Rating);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new StoreException(e);
        }

    }
    //

    public void complete() {
        complete = true;
    }
    @Override
    public void close() throws IOException {
        if (connection != null) {
            try {
                if (complete) {
                    connection.commit();
                }
                else {
                    connection.rollback();
                }
            }
            catch (SQLException e) {
                throw new StoreException(e);
            }
            finally {
                try {
                    connection.close();
                }
                catch (SQLException e) {
                    throw new StoreException(e);
                }
            }
        }
    }


}