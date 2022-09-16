package com.kainos.ea.resources;


import com.kainos.ea.WebServiceApplication;
import com.kainos.ea.employee_stuff.Employee;
import com.kainos.ea.employee_stuff.SalesEmployee;
import io.swagger.annotations.Api;

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
    public MessageList getFinanceEmployees() {
        try {
            Connection con = WebServiceApplication.getConnection();
            Statement st = con.createStatement();
            //st.execute("USE ddata_LauraP");
            ResultSet rs = st.executeQuery("Select * from Employee where department = 'FINANCE'");
            List<Message> allHREmployees = new ArrayList();
            while (rs.next()) {
                Message mess = new Message(rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("postcode"),
                        rs.getString("address"),
                        rs.getString("nin"),
                        rs.getString("bank_account"),
                        rs.getDouble("starting_salary"),
                        rs.getBoolean("isManager"),
                        rs.getString("department"));
                allHREmployees.add(mess);
            }

            return new MessageList(allHREmployees);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("/report/sales")
    @Produces(MediaType.APPLICATION_JSON)
    public MessageList getSalesEmployees() {
        try {
            Connection con = WebServiceApplication.getConnection();
            Statement st = con.createStatement();
            //st.execute("USE ddata_LauraP");
            ResultSet rs = st.executeQuery("Select * from Employee where department = 'SALES'");
            List<Message> allHREmployees = new ArrayList();
            while (rs.next()) {
                Message mess = new Message(rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("postcode"),
                        rs.getString("address"),
                        rs.getString("nin"),
                        rs.getString("bank_account"),
                        rs.getDouble("starting_salary"),
                        rs.getBoolean("isManager"),
                        rs.getString("department"));
                allHREmployees.add(mess);
            }


            return new MessageList(allHREmployees);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @GET
    @Path("/report/hr")
    @Produces(MediaType.APPLICATION_JSON)
    public MessageList getHREmployees() {
        try {
            Connection con = WebServiceApplication.getConnection();
            Statement st = con.createStatement();
            //st.execute("USE ddata_LauraP");
            ResultSet rs = st.executeQuery("Select * from Employee where department = 'HR'");
            List<Message> allHREmployees = new ArrayList();
            while (rs.next()) {
                Message mess = new Message(rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("postcode"),
                        rs.getString("address"),
                        rs.getString("nin"),
                        rs.getString("bank_account"),
                        rs.getDouble("starting_salary"),
                        rs.getBoolean("isManager"),
                        rs.getString("department"));
                allHREmployees.add(mess);
            }

            return new MessageList(allHREmployees);

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

            System.err.println(number);

            String sqlSales = "INSERT INTO SalesEmployee (number, commission_rate, sales_total) VALUES " +
                    "(?,?,?);";

            PreparedStatement statementSales = con.prepareStatement(sqlSales);
            statementSales.setInt(1, number);
            statementSales.setString(2, commissionRate);
            statementSales.setString(3, salesTotal);
            statementSales.execute();


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


    @GET
    @Path("/finance/report")
    @Produces(MediaType.APPLICATION_JSON)
    public MessageList getFinanceReport() {
        try {
            Connection con = WebServiceApplication.getConnection();
            Statement st = con.createStatement();
            //st.execute("USE ddata_LauraP");
            ResultSet rs = st.executeQuery("Select * from Employee");
            //List<Employee> allEmploy = new ArrayList();
            List<Message> allHREmployees = new ArrayList<>();
            while (rs.next()) {
                Employee emp = new Employee(rs.getInt("number"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("postcode"),
                        rs.getString("address"),
                        rs.getString("nin"),
                        rs.getString("bank_account"),
                        rs.getInt("starting_salary"),
                        rs.getBoolean("isManager"),
                        rs.getString("department"));

                Message mess = new Message(rs.getString("fname"),
                            rs.getString("lname"),
                            rs.getString("postcode"),
                            rs.getString("address"),
                            rs.getString("nin"),
                            rs.getString("bank_account"),
                            emp.calcPay(),
                            rs.getBoolean("isManager"),
                            rs.getString("department"));
                allHREmployees.add(mess);

                //allHREmployees.add(total);

            }

            return new MessageList(allHREmployees);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("/getHighestEarningEmployee")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getHighestEarningSalesEmployee() {
        try {
            Connection con = WebServiceApplication.getConnection();
            Statement st = con.createStatement();
            //st.execute("USE ddata_LauraP");
            ResultSet rs = st.executeQuery("Select * from SalesEmployee WHERE sales_total IN (SELECT MAX(sales_total) FROM SalesEmployee);");
            //List<Employee> allEmploy = new ArrayList();
            List<String> financeR = new ArrayList<>();

            int empNumber = 0;
            float commissionRate = 0.0f;
            int salesTotal = 0;

            while (rs.next()) {
                empNumber = rs.getInt("number");
                commissionRate = rs.getFloat("commission_rate");
                salesTotal = rs.getInt("sales_total");


                //allHREmployees.add(total);

            }

            String sqlGetEmployee = "SELECT * FROM Employee WHERE number = " + empNumber + ";";

            ResultSet rsEmp = st.executeQuery(sqlGetEmployee);

            Message newMessage = null;

            while(rsEmp.next()) {
                SalesEmployee salesEmp = new SalesEmployee(empNumber,
                        rsEmp.getString("fname"),
                        rsEmp.getString("lname"),
                        rsEmp.getString("postcode"),
                        rsEmp.getString("address"),
                        rsEmp.getString("nin"),
                        rsEmp.getString("bank_account"),
                        rsEmp.getInt("starting_salary"),
                        rsEmp.getBoolean("isManager"),
                        rsEmp.getString("department"),
                        commissionRate,
                        salesTotal);

                newMessage = new MessageSales(rsEmp.getString("fname"),
                        rsEmp.getString("lname"),
                        rsEmp.getString("postcode"),
                        rsEmp.getString("address"),
                        rsEmp.getString("nin"),
                        rsEmp.getString("bank_account"),
                        rsEmp.getInt("starting_salary"),
                        rsEmp.getBoolean("isManager"),
                        rsEmp.getString("department"),
                        commissionRate,
                        salesTotal);
                financeR.add(String.format(salesEmp.getNumber() + ": " + salesEmp.getFname() + " " + salesEmp.getLname() + " " + salesEmp.getSalesTotal()));

            }

            return newMessage;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
