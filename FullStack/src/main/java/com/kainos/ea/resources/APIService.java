package com.kainos.ea.resources;


import com.kainos.ea.WebServiceApplication;
import io.swagger.annotations.Api;
import org.eclipse.jetty.util.ajax.JSON;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Path("/api")
@Api("Engineering Academy Dropwizard API")
public class APIService {

    @GET
    @Path("/report/finance")
    @Produces(MediaType.APPLICATION_JSON)
    public String getFinanceEmployees() {
        try {
            Connection con = WebServiceApplication.getConnection();
            Statement st = con.createStatement();
            //st.execute("USE ddata_LauraP");
            ResultSet rs = st.executeQuery("Select * from Employee where department = 'FINANCE'");
            List<String> allHREmployees = new ArrayList();
            while (rs.next()) {
                String number = String.valueOf(rs.getInt("number"));
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String post = rs.getString("postcode");
                String address = rs.getString("address");
                String nin = rs.getString("nin");
                String bank_account = rs.getString("bank_account");
                String  starting_salary = String.valueOf(rs.getInt("starting_salary"));
                String isManager = String.valueOf(rs.getInt("isManager"));
                String department = rs.getString("department");

                String total = number + " " + fname + " "
                        + lname + " " +post + " " + address +" " + nin
                        + " " + bank_account + " " + starting_salary+" "+
                         isManager + " " + department;
                allHREmployees.add(total);

            }

            return JSON.toString(allHREmployees);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }

    @GET
    @Path("/report/sales")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSalesEmployees() {
        try {
            Connection con = WebServiceApplication.getConnection();
            Statement st = con.createStatement();
            //st.execute("USE ddata_LauraP");
            ResultSet rs = st.executeQuery("Select * from Employee where department = 'SALES'");
            List<String> allHREmployees = new ArrayList();
            while (rs.next()) {
                String number = String.valueOf(rs.getInt("number"));
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String post = rs.getString("postcode");
                String address = rs.getString("address");
                String nin = rs.getString("nin");
                String bank_account = rs.getString("bank_account");
                String  starting_salary = String.valueOf(rs.getInt("starting_salary"));
                String isManager = String.valueOf(rs.getInt("isManager"));
                String department = rs.getString("department");

                String total = number + " " + fname + " "
                        + lname + " " +post + " " + address +" " + nin
                        + " " + bank_account + " " + starting_salary+" "+
                        isManager + " " + department;
                allHREmployees.add(total);

            }

            return JSON.toString(allHREmployees);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @GET
    @Path("/report/hr")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHREmployees() {
        try {
            Connection con = WebServiceApplication.getConnection();
            Statement st = con.createStatement();
            //st.execute("USE ddata_LauraP");
            ResultSet rs = st.executeQuery("Select * from Employee where department = 'HR'");
            List<String> allHREmployees = new ArrayList();
            while (rs.next()) {
                String number = String.valueOf(rs.getInt("number"));
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String post = rs.getString("postcode");
                String address = rs.getString("address");
                String nin = rs.getString("nin");
                String bank_account = rs.getString("bank_account");
                String  starting_salary = String.valueOf(rs.getInt("starting_salary"));
                String isManager = String.valueOf(rs.getInt("isManager"));
                String department = rs.getString("department");

                String total = number + " " + fname + " "
                        + lname + " " +post + " " + address +" " + nin
                        + " " + bank_account + " " + starting_salary+" "+
                        isManager + " " + department;
                allHREmployees.add(total);

            }

            return JSON.toString(allHREmployees);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @POST
    @Path("/enter/employee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String enterEmployee(Message message) {
        // Return a string for testing purposes

        // TODO: use the fields of 'message' to add an employee to the database
        String fname = message.getFname();
        String lname = message.getLname();
        String address = message.getAddress();
        String postcode = message.getPostcode();
        String nin = message.getNin();
        String bankAccount = message.getBankAccount();
        String startingSalary = String.valueOf(message.getStartingSalary());
        boolean isManager = true;
        String department = String.valueOf(message.getDepartment());



        Connection con = WebServiceApplication.getConnection();
        try {
            String sql = "INSERT INTO Employee (fname, lname, postcode, address, nin," +
                    "bank_account, starting_salary, isManager, department) VALUES " +
                    "(?,?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, fname);
            statement.setString(2, lname);
            statement.setString(3, postcode);
            statement.setString(4, address);
            statement.setString(5, nin);
            statement.setString(6, bankAccount);
            statement.setString(7, startingSalary);
            statement.setBoolean(8, isManager);
            statement.setString(9, department);
            statement.execute();
            return "Data inserted successfully";
        }
        catch (SQLException e) {
            // Bad practice :)
            //TODO: actually handle this exception
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }

        return  "Something went wrong. Database not updated.";
    }

    @POST
    @Path("/enter/salesEmployee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String enterSalesEmployee(MessageSales message) {
        // Return a string for testing purposes

        String fname = message.getFname();
        String lname = message.getLname();
        String address = message.getAddress();
        String postcode = message.getPostcode();
        String nin = message.getNin();
        String bankAccount = message.getBankAccount();
        String startingSalary = String.valueOf(message.getStartingSalary());
        boolean isManager = true;
        String department = "Sales";
        String salesTotal = String.valueOf(message.getSalesTotal());
        String commissionRate = String.valueOf(message.getCommissionRate());



        try {
            Connection con = WebServiceApplication.getConnection();

            String sql = "INSERT INTO Employee (fname, lname, postcode, address, nin," +
                    "bank_account, starting_salary, isManager, department) VALUES " +
                    "(?,?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, fname);
            statement.setString(2, lname);
            statement.setString(3, postcode);
            statement.setString(4, address);
            statement.setString(5, nin);
            statement.setString(6, bankAccount);
            statement.setString(7, startingSalary);
            statement.setBoolean(8, isManager);
            statement.setString(9, department);
            statement.execute();


            Statement st = con.createStatement();
            ResultSet ID = st.executeQuery("SELECT number FROM Employee WHERE fname = '" + fname
                    + "' AND lname = '" + lname + "';");
            int number = 0;
            if (ID.next()) {
                number = ID.getInt(1);
            }

            String sqlSales = "INSERT INTO SalesEmployee (number, commission_rate, sales_total) VALUES " +
                    "(?,?, ?);";

            PreparedStatement statementSales = con.prepareStatement(sqlSales);
            statement.setString(1, String.valueOf(number));
            statement.setString(2, commissionRate);
            statement.setString(3, salesTotal);


            return "Data inserted successfully";
        }
        catch (SQLException e) {
            // Bad practice :)
            //TODO: actually handle this exception
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }

        return  "Something went wrong. Database not updated.";
    }


}
