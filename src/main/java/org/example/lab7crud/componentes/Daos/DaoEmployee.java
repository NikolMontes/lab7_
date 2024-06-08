package org.example.lab7crud.componentes.Daos;

import org.example.lab7crud.componentes.Beans.Employees;
import org.example.lab7crud.componentes.Beans.Jobs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;
import java.sql.Date;

public class DaoEmployee {

    public ArrayList<Employees> listar() {
        ArrayList<Employees> listadeemployees = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/hr";
        String user = "root";
        String pass = "123456";

        String sql = "SELECT e.*, j.job_title FROM employees e JOIN jobs j ON e.job_id = j.job_id";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Employees empl = new Employees();

                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                empl.setFullNameEmployee(firstName,lastName);
                empl.setEmail(rs.getString("email"));
                empl.setPhone_number(rs.getString("phone_number"));
                empl.setHire_date(rs.getDate("hire_date"));
                empl.setSalary(rs.getFloat("salary"));
                empl.setCommission_pct(rs.getFloat("commission_pct"));
                empl.setJobTitle(rs.getString("job_title"));

                listadeemployees.add(empl);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    return listadeemployees;
    }

    public Employees busquedaporId(String emply_id){
        Employees employ = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/hr";
        String user = "root";
        String pass = "123456";

        String sql = "SELECT e.*, j.job_title FROM employees e JOIN jobs j ON e.job_id = j.job_id" +
                " WHERE e.employee_id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,emply_id);

            try (ResultSet rs = pstmt.executeQuery()){
                while(rs.next()) {
                    employ = new Employees();
                    employ.setEmployee_id(rs.getInt("employee_id"));
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    employ.setFullNameEmployee(firstName, lastName);
                    employ.setEmail(rs.getString("email"));
                    employ.setPhone_number(rs.getString("phone_number"));
                    employ.setHire_date(rs.getDate("hire_date"));
                    employ.setSalary(rs.getFloat("salary"));
                    employ.setCommission_pct(rs.getFloat("commission_pct"));
                    employ.setJobTitle(rs.getString("job_title"));
                }
            }

        } catch(SQLException a){
            throw new RuntimeException(a);
        }

        return employ;
    }

    public void editarporId(Employees employee){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        String user = "root";
        String pass = "123456";

        String sql = "UPDATE employees SET first_name = ?, last_name = ?, hire_date = ?, email= ?, phone_number = ?, salary = ?," +
                " commission_pct = ? WHERE employee_id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            String[] names = employee.getFullNameEmployee().split(" ");
            String firstName = names[0];
            String lastName = names.length > 1 ? names[1] : "";

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setDate(3, new java.sql.Date(employee.getHire_date().getTime()));
            pstmt.setString(4, employee.getEmail());
            pstmt.setString(5, employee.getPhone_number());
            pstmt.setFloat(6, employee.getSalary());
            pstmt.setFloat(7, employee.getCommission_pct());
            pstmt.setInt(8, employee.getEmployee_id());

            pstmt.executeUpdate();
        } catch(SQLException a){
            throw new RuntimeException(a);
        }

    }

    public void borrarporId (String id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        String user = "root";
        String pass = "123456";

        String sql = "delete from employees where employee_id = ?";

        try(Connection conn = DriverManager.getConnection(url,user,pass);
        PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1,id);
            pstmt.executeUpdate();

        }catch (SQLException a){
            throw new RuntimeException(a);
        }

    }

    public void crear(Employees employee,String employid, String firstname, String lastName, String phoneNumber, String email, Date hireDate, float salary, float comissionPCT) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/hr";
        String user = "root";
        String pass = "123456";

        String sql = "INSERT INTO employees (employee_id, first_name, last_name, email, phone_number, " +
                "hire_date, salary, commission_pct) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            /*String fullNameEmployee = employee.getFullNameEmployee();
            String[] names = fullNameEmployee.split(" ");
            String firstName = names[0];
            lastName = names.length > 1 ? names[1] : "";*/

            stmt.setInt(1, Integer.parseInt(employid));
            stmt.setString(2, firstname);
            stmt.setString(3, lastName);
            stmt.setString(4, email);
            stmt.setString(5, phoneNumber);
            stmt.setDate(6, hireDate);
            stmt.setFloat(7, salary);
            stmt.setFloat(8, comissionPCT);

            stmt.executeUpdate();

        } catch (SQLException a) {
            throw new RuntimeException(a);
        }
    }
}





