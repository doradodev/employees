package com.masglobal.employees.vo;

import com.masglobal.employees.service.interfaces.Contract;

public class EmployeeDTO {

    public EmployeeDTO(CONTRACT_TYPE contractType, Contract contract, double paymentRate, String fullName, Long id) {
        this.contractType = contractType;
        this.contract = contract;
        this.paymentRate = paymentRate;
        this.fullName = fullName;
        this.id = id;
    }

    public EmployeeDTO() {
    }

    private CONTRACT_TYPE contractType;
    private Contract contract;
    private double paymentRate;
    private String fullName;
    private Long id;

    private String name;
    private String contractTypeName;
    private int roleId;
    private String roleName;
    private String roleDescription;
    private double hourlySalary;
    private double monthlySalary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContractTypeName() {
        return contractTypeName;
    }

    public void setContractTypeName(String contractTypeName) {
        this.contractTypeName = contractTypeName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }



    public static EmployeeVOBuilder builder() {
        return new EmployeeVOBuilder();
    }

    public CONTRACT_TYPE getContractType() {
        return this.contractType;
    }

    public Contract getContract() {
        return this.contract;
    }

    public double getPaymentRate() {
        return this.paymentRate;
    }

    public String getFullName() {
        return this.fullName;
    }

    public Long getId() {
        return this.id;
    }

    public void setContractType(CONTRACT_TYPE contractType) {
        this.contractType = contractType;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public void setPaymentRate(double paymentRate) {
        this.paymentRate = paymentRate;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public enum CONTRACT_TYPE {
        HourlySalaryEmployee, MONTHLY
    }

    public double getSalary(){
        return contract.calculateSalary();
    }

    public static class EmployeeVOBuilder {
        private CONTRACT_TYPE contractType;
        private Contract contract;
        private double paymentRate;
        private String fullName;
        private Long id;

        EmployeeVOBuilder() {
        }

        public EmployeeVOBuilder contractType(CONTRACT_TYPE contractType) {
            this.contractType = contractType;
            return this;
        }

        public EmployeeVOBuilder contract(Contract contract) {
            this.contract = contract;
            return this;
        }

        public EmployeeVOBuilder paymentRate(double paymentRate) {
            this.paymentRate = paymentRate;
            return this;
        }

        public EmployeeVOBuilder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public EmployeeVOBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public EmployeeDTO build() {
            return new EmployeeDTO(contractType, contract, paymentRate, fullName, id);
        }

    }
}
