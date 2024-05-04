package de.unidue.inf.is;


import de.unidue.inf.is.domain.Benutzer;
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

@WebServlet("main")
public final class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Benutzer user = new Benutzer();

        List<Fahrt> UserList = new ArrayList<Fahrt>();
        List<Fahrt> AvailableFahrtList=new ArrayList<>();

        try (FahrtStore fs = new FahrtStore()) {
            //meine fahrte
            UserList = fs.getUserFahrte(user);

            //verfügbare fahrten
            AvailableFahrtList = fs.getAvailableFahrten(user);
            request.setAttribute("Fahrt1", UserList);
            request.setAttribute("Fahrt2", AvailableFahrtList);
            request.getRequestDispatcher("/view_main.ftl").forward(request, response);
            fs.complete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
        doGet(request, response);
    }
}