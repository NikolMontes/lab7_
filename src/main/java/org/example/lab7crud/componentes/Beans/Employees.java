package org.example.lab7crud.componentes.Beans;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Employees {

    private int employee_id;
    //private String first_name;
    //private String last_name;
    private String email;
    private String phone_number;
    private Date hire_date;
    private float salary;
    private float commission_pct;
    private String fullNameEmployee;
    private String jobTitle;
    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    /*public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
*/
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getCommission_pct() {
        return commission_pct;
    }

    public void setCommission_pct(float commission_pct) {
        this.commission_pct = comission_pct;
    }
     public String getFullNameEmployee () {
        return fullNameEmployee;
     }

    public void setFullNameEmployee(String first_name, String last_name) {
        this.fullNameEmployee = first_name + " " + last_name;
    }
    public Employees(int employee_id, String email, String phone_number, Date hire_date, float salary, float commission_pct, String first_name, String last_name) {
        this.employee_id = employee_id;
        this.email = email;
        this.phone_number = phone_number;
        this.hire_date = hire_date;
        this.salary = salary;
        this.commission_pct = commission_pct;
        this.fullNameEmployee = first_name + " " + last_name;
    }
    public Employees(){

    }
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

}
