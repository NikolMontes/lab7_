package org.example.lab7crud.componentes.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lab7crud.componentes.Beans.Employees;
import org.example.lab7crud.componentes.Daos.DaoEmployee;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet (name = "CrudEmployee", value = "/home")

public class ServletEmployee extends HttpServlet{

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");

        String action = req.getParameter("action") == null ? "lista" : req.getParameter("action");

        DaoEmployee employeedao = new DaoEmployee();

        switch (action){
            case "lista":
                //saca del modelo
                ArrayList<Employees> listaemployees = employeedao.listar();

                //mandar la lista a la vista -> job/lista.jsp
                req.setAttribute("lista",listaemployees);
                RequestDispatcher rd = req.getRequestDispatcher("job/listaemployee.jsp");
                rd.forward(req,resp);
                break;
            case "new":
                req.getRequestDispatcher("job/form_new.jsp").forward(req,resp);
                break;
            case "edit":
                String id = req.getParameter("employee_id");
                Employees employees = employeedao.busquedaporId(id);

                if(employees != null){
                    req.setAttribute("employees",employees);
                    req.getRequestDispatcher("job/editionform.jsp").forward(req,resp);
                }else{
                    resp.sendRedirect(req.getContextPath() + "/home");
                }
                break;
            case "del":
                String idd = req.getParameter("employee_id");
                Employees employees1 = employeedao.busquedaporId(idd);

                if(employees1 != null){
                    try {
                        employeedao.borrarporId(idd);
                    } catch (SQLException e) {
                        System.out.println("Log: excepcion: " + e.getMessage());
                    }
                }
                resp.sendRedirect(req.getContextPath() + "/home");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("text/html");

        String action = req.getParameter("action")== null ? "crear" : req.getParameter("action");

        DaoEmployee employeedao = new DaoEmployee();

        switch (action) {
            case "create":
                String firstName = req.getParameter("first_name");
                String lastName = req.getParameter("last_name");
                String email = req.getParameter("email");
                String phoneNumber = req.getParameter("phone_number");
                String hireDate = req.getParameter("hire_date");
                String salary = req.getParameter("salary");
                String comissionPCT = req.getParameter("comission_pct");
                String employeeId = req.getParameter("employee_id");
                boolean isAllValid = true;

                if(isAllValid){

                    Employees employees = employeedao.busquedaporId(employeeId);

                    if(employees == null){
                        employeedao.crear(employeeId,firstName,lastName,email,phoneNumber, email, hireDate, salary, comissionPCT);
                        resp.sendRedirect(req.getContextPath() + "/home");
                    }else{
                        req.getRequestDispatcher("job/form_new.jsp").forward(req,resp);
                    }
                }else{
                    req.getRequestDispatcher("job/form_new.jsp").forward(req,resp);
                }

                break;
            case "update":
                String id = req.getParameter("id");
                String firstNameUpdate = req.getParameter("first_name");
                String lastNameUpdate = req.getParameter("last_name");
                String emailUpdate = req.getParameter("email");
                String phoneNumberUpdate = req.getParameter("phone_number");
                String hireDateUpdate = req.getParameter("hire_date");
                String jobIdUpdate = req.getParameter("job_id");
                boolean isAllValid2 = true;

                if(isAllValid2){
                    Employees employees = new Employees();
                    employees.setFullNameEmployee(firstNameUpdate, lastNameUpdate);
                    employees.setEmail(emailUpdate);
                    employees.setPhone_number(phoneNumberUpdate);
                    employees.setHire_date(hireDateUpdate);

                    employeedao.editarporId(employees);
                    resp.sendRedirect(req.getContextPath() + "/home");
                }else{
                    req.setAttribute("employee",employeedao.busquedaporId(jobIdUpdate));
                    req.getRequestDispatcher("job/editionform.jsp").forward(req,resp);
                }
                break;
            default:
                resp.sendRedirect(req.getContextPath() + "/home");
                break;
        }
    }

}
