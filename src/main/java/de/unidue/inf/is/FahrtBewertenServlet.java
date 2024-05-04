package de.unidue.inf.is;


import de.unidue.inf.is.domain.Benutzer;
import de.unidue.inf.is.domain.Fahrt;
import de.unidue.inf.is.stores.FahrtStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class FahrtBewertenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        request.getRequestDispatcher("/Fahrt_bewerten.ftl").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {

        String bewertungstext = request.getParameter("bewertungstexttext");
        int rating = Integer.parseInt(request.getParameter("rating"));
        //int rating = Integer.parseInt(bewertungsrating);
        //Date Datum = request.getParameter("datum");
        String datum = request.getParameter("datum");

        if (request.getParameter("action").equals("xy")){

            Benutzer user = new Benutzer();
            int beid = user.getBid();
            // Dispatch message to template engine
            try (FahrtStore fs = new FahrtStore()){
                fs.insertBewertung(user.getBid(), bewertungstext, Date.valueOf(datum), rating);
                request.setAttribute("message", "Ihre Bewertung wurde erfolgreich gespeichert");
                request.getRequestDispatcher("/Fahrt_details.ftl").forward(request, response);
                fs.complete();
            } catch (ServletException | IOException e) {
                e.printStackTrace();
                request.setAttribute("errormessage", "Datenbank fehler, der Vorgang wurde abgebrochen");
                request.getRequestDispatcher("/error.ftl").forward(request, response);
            }
        }
    }
}