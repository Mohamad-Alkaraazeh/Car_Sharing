package de.unidue.inf.is;

import de.unidue.inf.is.domain.Benutzer;
import de.unidue.inf.is.stores.FahrtStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateFahrtenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        request.getRequestDispatcher("Fahrt_erstellen.ftl").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {

        String Startort = request.getParameter("Startort");
        String Zielort = request.getParameter("Zielort");
        String maxplaetze = request.getParameter("maxplaetze");
        String fahrtkosten = request.getParameter("fahrtkosten");
        String Transportmittel = request.getParameter("Transportmittel");
        String fahrtdatumzeit = request.getParameter("fahrtdatum");
        String Beschreibnug = request.getParameter("Beschreibung");

        Benutzer user = new Benutzer();
        try(FahrtStore fs = new FahrtStore()){

            fs.createNewFahrten(Startort,Zielort,fahrtdatumzeit,maxplaetze,fahrtkosten,Transportmittel,Beschreibnug);
            request.setAttribute("message", "Fahrt erfolgreich erstellt!");
            request.getRequestDispatcher("Fahrt_details.ftl").forward(request, response);
            fs.complete();
        } catch (ServletException | IOException e){
            e.printStackTrace();
        }
    }

}
