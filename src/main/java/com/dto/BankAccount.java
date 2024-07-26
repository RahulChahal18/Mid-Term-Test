package com.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
//@Table(name = "bank_accounts")
public class BankAccount {

    @Id
    private int actNumber;
    private String customerName;
    private double actBalance;
    private String city;
    private int branchCode;

    // Default constructor
    public BankAccount() {}

    // Parameterized constructor
    public BankAccount(int actNumber, String customerName, double actBalance, String city, int branchCode) {
        this.actNumber = actNumber;
        this.customerName = customerName;
        this.actBalance = actBalance;
        this.city = city;
        this.branchCode = branchCode;
    }

    // Getters and Setters
    public int getActNumber() {
        return actNumber;
    }

    public void setActNumber(int actNumber) {
        this.actNumber = actNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getActBalance() {
        return actBalance;
    }

    public void setActBalance(double actBalance) {
        this.actBalance = actBalance;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(int branchCode) {
        this.branchCode = branchCode;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "actNumber=" + actNumber +
                ", customerName='" + customerName + '\'' +
                ", actBalance=" + actBalance +
                ", city='" + city + '\'' +
                ", branchCode=" + branchCode + "\n"+
                '}';
    }
}

