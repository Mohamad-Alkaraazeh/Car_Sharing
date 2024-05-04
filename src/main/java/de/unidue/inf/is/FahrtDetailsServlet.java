package de.unidue.inf.is;

import de.unidue.inf.is.domain.Benutzer;
import de.unidue.inf.is.domain.Bewertung;
import de.unidue.inf.is.domain.Fahrt;
import de.unidue.inf.is.stores.FahrtStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/Fahrt_details")
public class FahrtDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Benutzer user = new Benutzer();

        request.setAttribute("fid", (request.getParameter("fid")));
        int fid = Integer.parseInt((request.getParameter("fid")));

        Fahrt DriveToDisplay;
        List<Bewertung> Userbewertungen=new ArrayList<Bewertung>();

        try (FahrtStore fs = new FahrtStore()) {
            DriveToDisplay = fs.getFahrt(fid);

            //Userbewertungen=fs.getfahrtbewertungen();
            request.setAttribute("Bewert",Userbewertungen);

            request.setAttribute("FahrtPlatzhalter", DriveToDisplay);
            request.getRequestDispatcher("/Kurs_details.ftl").forward(request, response);

            fs.complete();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String Startort = request.getParameter("Startort");
        String Zielort = request.getParameter("Zielort");
        String maxplaetze = request.getParameter("Maximalekapazitt");
        String fahrtkosten = request.getParameter("fahrtkosten");
        String Transportmittel = request.getParameter("Transportmittel");
        String fahrtdatum = request.getParameter("fahrtdatum");
        String Beschreibnug = request.getParameter("Beschreibung");

        Benutzer user = new Benutzer();
        try(FahrtStore fs = new FahrtStore()){

            fs.createNewFahrten(Startort,Zielort,maxplaetze,fahrtkosten,Transportmittel,fahrtdatum,Beschreibnug);
            request.setAttribute("message", "Fahrt erfolgreich !");
            request.getRequestDispatcher("view_main.ftl").forward(request, response);
            fs.complete();
        } catch (ServletException | IOException e){
            e.printStackTrace();
        }
        }
    }*/

   /* protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        Benutzer user = new Benutzer();
        request.setAttribute("fid",(request.getParameter("fid")));
        int fid = Integer.parseInt((request.getParameter("fid")));

        Fahrt FahrtToDisplay;

        try(FahrtStore fs = new FahrtStore()) {
            FahrtToDisplay = fs.getFahrt(fid);
            request.setAttribute("FahrtToDisplay", FahrtToDisplay);
            request.getRequestDispatcher("Fahrt_details.ftl").forward(request, response);
            fs.complete();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {*/
        Benutzer user = new Benutzer();

        if (request.getParameter("action").equals("DeleteFahrt")) {
            String fidFromLink = request.getParameter("fid");
            int fid = Integer.parseInt(fidFromLink);
            List<Fahrt> UserFahrtList = new ArrayList<Fahrt>();
            List<Fahrt> AvailableFahrtList = new ArrayList<Fahrt>();


            // Dispatch message to template engine
            try (FahrtStore fs = new FahrtStore()) {
                if (fs.isErsteller(user, fid)) {
                    // current user is the creator of the drive

                    //Delete the faht
                    fs.deleteFahrte(fid);

                    //Forward to view_main after deleting a Drive
                    UserFahrtList = fs.getUserFahrte(user);
                    AvailableFahrtList = fs.getAvailableFahrten(user);
                    request.setAttribute("Fahrt1", UserFahrtList);
                    request.setAttribute("Fahrt2", AvailableFahrtList);
                    request.getRequestDispatcher("/view_main.ftl").forward(request, response);

                } else {
                    // current user is not the creator of the drive
                    request.setAttribute("errormessage", "Sie haben keine Benutzerrechte um diesen Fahrt zu löschen");
                    request.getRequestDispatcher("/error.ftl").forward(request, response);
                }
                fs.complete();


            } catch (ServletException | IOException | SQLException e) {
                e.printStackTrace();
            }

        }

    }
}








