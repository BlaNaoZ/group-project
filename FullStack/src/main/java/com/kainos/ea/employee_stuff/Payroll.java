package com.kainos.ea.employee_stuff;

public class Payroll {
    private float taxRate = 0.25f;

    public double netPay(Employee payee) {
        double grossPay = payee.calcPay();
        double taxToPay = Math.round(grossPay * taxRate);
        return grossPay - taxToPay;
    }
}

