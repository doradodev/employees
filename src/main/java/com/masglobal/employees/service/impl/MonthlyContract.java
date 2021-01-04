package com.masglobal.employees.service.impl;

import com.masglobal.employees.service.interfaces.Contract;
import com.masglobal.employees.util.Constants;

public class MonthlyContract implements Contract {
    private double monthlySalary;

    public MonthlyContract(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public MonthlyContract() {
    }

    public static MonthlyContractBuilder builder() {
        return new MonthlyContractBuilder();
    }

    @Override
    public Double calculateSalary() {
        return monthlySalary * Constants.MONTHS_PER_YEAR;
    }

    public double getMonthlySalary() {
        return this.monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MonthlyContract)) return false;
        final MonthlyContract other = (MonthlyContract) o;
        if (!other.canEqual((Object) this)) return false;
        if (Double.compare(this.getMonthlySalary(), other.getMonthlySalary()) != 0) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MonthlyContract;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $monthlySalary = Double.doubleToLongBits(this.getMonthlySalary());
        result = result * PRIME + (int) ($monthlySalary >>> 32 ^ $monthlySalary);
        return result;
    }

    public String toString() {
        return "MonthlyContract(monthlySalary=" + this.getMonthlySalary() + ")";
    }

    public static class MonthlyContractBuilder {
        private double monthlySalary;

        MonthlyContractBuilder() {
        }

        public MonthlyContractBuilder monthlySalary(double monthlySalary) {
            this.monthlySalary = monthlySalary;
            return this;
        }

        public MonthlyContract build() {
            return new MonthlyContract(monthlySalary);
        }

        public String toString() {
            return "MonthlyContract.MonthlyContractBuilder(monthlySalary=" + this.monthlySalary + ")";
        }
    }
}
