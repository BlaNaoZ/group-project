package com.kainos.ea.employee_stuff;

public class Employee implements Payable{

    private int number;
    private String fname;
    private String lname;
    private String postcode;
    private String address;
    private String nin;
    private String bankAccount;
    private double startingSalary;
    private boolean isManager;
    private String department;

    public Employee(int number,
                    String fname,
                    String lname,
                    String postcode,
                    String address,
                    String nin,
                    String bankAccount,
                    double startingSalary,
                    boolean isManager,
                    String department) {
        this.setNumber(number);
        this.setFname(fname);
        this.setLname(lname);
        this.setPostcode(postcode);;
        this.setAddress(address);
        this.setNin(nin);
        this.setBankAccount(bankAccount);
        this.setStartingSalary(startingSalary);
        this.setIsManager(isManager);
        this.setDepartment(department);
    }
    public void setFname(String fname) { this.fname = fname; }
    public void setLname(String lname) { this.lname = lname; }
    public void setPostcode(String postcode) { this.postcode = postcode; }
    public void setAddress(String address) { this.address = address; }
    public void setNin(String nin) { this.nin = nin; }
    public void setBankAccount(String bankAccount) { this.bankAccount = bankAccount; }
    public void setStartingSalary(Double startingSalary) { this.startingSalary = startingSalary; }
    public void setIsManager(boolean isManager) { this.isManager = isManager; }
    public void setDepartment(String department) { this.department = department; }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getAddress() {
        return address;
    }

    public String getNin() {
        return nin;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public double getStartingSalary() {
        return startingSalary;
    }

    public boolean isManager() {
        return isManager;
    }

    public String getDepartment() {
        return department;
    }

    public int calcPay(){
        return (int) (getStartingSalary() / 12);
    }

    @Override
    public String getName() {
        return fname + " " + lname;
    }

    @Override
    public void setName(String name) {
        String[] splitName = name.split(" ");
        this.fname = splitName[0];
        this.lname = splitName[1];
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
