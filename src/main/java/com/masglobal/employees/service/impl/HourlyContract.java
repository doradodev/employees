package com.masglobal.employees.service.impl;

import com.masglobal.employees.service.interfaces.Contract;
import com.masglobal.employees.util.Constants;

public class HourlyContract implements Contract {
    private double hourlySalary;

    public HourlyContract(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public HourlyContract() {
    }

    public static HourlyContractBuilder builder() {
        return new HourlyContractBuilder();
    }

    @Override
    public Double calculateSalary() {
        return hourlySalary * Constants.HOURS_PER_MONTH * Constants.MONTHS_PER_YEAR;
    }

    public double getHourlySalary() {
        return this.hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof HourlyContract)) return false;
        final HourlyContract other = (HourlyContract) o;
        if (!other.canEqual((Object) this)) return false;
        if (Double.compare(this.getHourlySalary(), other.getHourlySalary()) != 0) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof HourlyContract;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $hourlySalary = Double.doubleToLongBits(this.getHourlySalary());
        result = result * PRIME + (int) ($hourlySalary >>> 32 ^ $hourlySalary);
        return result;
    }

    public String toString() {
        return "HourlyContract(hourlySalary=" + this.getHourlySalary() + ")";
    }

    public static class HourlyContractBuilder {
        private double hourlySalary;

        HourlyContractBuilder() {
        }

        public HourlyContractBuilder hourlySalary(double hourlySalary) {
            this.hourlySalary = hourlySalary;
            return this;
        }

        public HourlyContract build() {
            return new HourlyContract(hourlySalary);
        }

        public String toString() {
            return "HourlyContract.HourlyContractBuilder(hourlySalary=" + this.hourlySalary + ")";
        }
    }
}
