package com.kainos.ea.employee_stuff;

import java.util.Objects;

public class SalesEmployee extends Employee {
        private float commissionRate;

        private int salesTotal;

        public SalesEmployee(int number,
                            String fname,
                             String lname,
                             String postcode,
                             String address,
                             String nin,
                             String bankAccount,
                             double startingSalary,
                             boolean isManager,
                             String department,
                             float commissionRate,
                             int salesTotal) {
            super(number, fname, lname, postcode, address, nin, bankAccount, startingSalary, isManager, department);
            this.commissionRate = commissionRate;
            this.salesTotal = salesTotal;
        }

        @Override
        public String toString() {
            return super.toString() + "SalesEmployee{" +
                    "commissionRate=" + commissionRate +
                    ", salesTotal=" + salesTotal +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            SalesEmployee that = (SalesEmployee) o;
            return Float.compare(that.commissionRate, commissionRate) == 0 && salesTotal == that.salesTotal;
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), commissionRate, salesTotal);
        }

        @Override
        public int calcPay() {
            return (super.calcPay() + Math.round(commissionRate * salesTotal));
        }
        public float getComissionRate() {
            return commissionRate;
        }

        public void setComissionRate(float comissionRate) {
            this.commissionRate = comissionRate;
        }

        public int getSalesTotal() {
            return salesTotal;
        }

        public void setSalesTotal(int salesTotal) {
            this.salesTotal = salesTotal;
        }

}
