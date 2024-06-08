package org.example.lab7crud.componentes.Servlets;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.lab7crud.componentes.Daos.*;
import org.example.lab7crud.componentes.Beans.Jobs;
import java.io.*;
import jakarta.servlet.*;


@WebServlet(name = "EditJobServlet", value = "/edit-job")
public class EditJobServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String jobId = req.getParameter("id");
        DaoJobs jobDao = new DaoJobs();
        Jobs job = jobDao.obtenerporId(jobId);
        req.setAttribute("job", job);

        RequestDispatcher view = req.getRequestDispatcher("editJob.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    }
}
