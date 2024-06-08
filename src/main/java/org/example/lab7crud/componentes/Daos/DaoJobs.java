package org.example.lab7crud.componentes.Daos;

import java.sql.*;
import java.util.ArrayList;
import org.example.lab7crud.componentes.Beans.Jobs;
public class DaoJobs {

    public ArrayList<Jobs> listajobs(){
        ArrayList<Jobs> listadeJobs= new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/hr";
        String user = "root";
        String pass = "123456";

        String sql = "select * from jobs";

        try(Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while(rs.next()){
                Jobs job = new Jobs();
                job.setJob_title(rs.getString("job_title"));
                job.setMin_salary(rs.getInt("min_salary"));
                job.setMax_salary(rs.getInt("max_salary"));

                listadeJobs.add(job);
            }

        } catch(SQLException e){
            throw new RuntimeException(e);
        }
        return listadeJobs;
    }

    public void crear(String jobid, String jobtitle, int minsalary, int maxsalary){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/hr";
        String user = "root";
        String pass = "123456";

        String sql = "insert into jobs (job_id, job_title, min_salary, max_salary) values (?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,jobid);
            stmt.setString(2,jobtitle);
            stmt.setInt(3,minsalary);
            stmt.setInt(3,maxsalary);

            stmt.executeUpdate();

        }catch (SQLException a){
            throw new RuntimeException(a);
        }
    }

    public Jobs obtenerporId(String jobid) {
        Jobs job = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/hr";
        String user = "root";
        String pass = "123456";

        String sql = " select * from jobs where job_id = ?";

        try(Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,jobid);
            try(ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    job = new Jobs();
                    job.setJob_id(rs.getString("job_id"));
                    job.setJob_title(rs.getString("job_title"));
                    job.setMin_salary(rs.getInt("min_salary"));
                    job.setMax_salary(rs.getInt("max_salary"));
                }

            }


        } catch(SQLException a){
            throw new RuntimeException(a);
        }
        return job;
    }

}
