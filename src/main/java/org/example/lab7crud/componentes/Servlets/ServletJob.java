package org.example.lab7crud.componentes.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lab7crud.componentes.Daos.DaoJobs;
import org.example.lab7crud.componentes.Beans.*;
import java.util.ArrayList;

import java.io.IOException;

@WebServlet (name= "ServletJob", value = "/Jobservlet")
public class ServletJob extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");

        DaoJobs jobdao = new DaoJobs();
        ArrayList<Jobs> listaTrabajos = jobdao.listajobs();
        req.setAttribute("lista",listaTrabajos);

        RequestDispatcher view = req.getRequestDispatcher("job/listaTrabajos.jsp");
        view.forward(req,resp);

    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

}
