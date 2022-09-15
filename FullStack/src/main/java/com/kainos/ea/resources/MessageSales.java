package com.kainos.ea.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageSales extends Message {


    private float commissionRate;

    private int salesTotal;

    public MessageSales(@JsonProperty("fname") String fname,
                        @JsonProperty("lname") String lname,
                        @JsonProperty("postcode") String postcode,
                        @JsonProperty("address") String address,
                        @JsonProperty("nin") String nin,
                        @JsonProperty("bankAccount") String bankAccount,
                        @JsonProperty("startingSalary") double startingSalary,
                        @JsonProperty("isManager") boolean isManager,
                        @JsonProperty("department") String department,
                        @JsonProperty("commissionRate") float commissionRate,
                        @JsonProperty("salesTotal") int salesTotal) {
        super(fname, lname, postcode, address, nin, bankAccount, startingSalary, isManager, department);
        this.setCommissionRate(commissionRate);
        this.setSalesTotal(salesTotal);

    }

    public float getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(float commissionRate) {
        this.commissionRate = commissionRate;
    }

    public int getSalesTotal() {
        return salesTotal;
    }

    public void setSalesTotal(int salesTotal) {
        this.salesTotal = salesTotal;
    }
}
