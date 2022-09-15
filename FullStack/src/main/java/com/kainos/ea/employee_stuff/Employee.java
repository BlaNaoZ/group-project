package com.kainos.ea.employee_stuff;

public class Employee {
    private String fname;
    private String lname;
    private String postcode;
    private String address;
    private String nin;
    private String bankAccount;
    private double startingSalary;
    private boolean isManager;
    private String department;

    public Employee(String fname,
                   String lname,
                   String postcode,
                   String address,
                   String nin,
                   String bankAccount,
                   double startingSalary,
                   boolean isManager,
                   String department) {
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

    public double calcPay(){
        return getStartingSalary() / 12;
    }

}
