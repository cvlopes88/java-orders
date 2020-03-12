package com.orders.credyorders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "customers")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long custcode;
    @Column(nullable = false)
    private String custname;
    private String custcity;
    private String workingarea;
    private String custcountry;
    private String grade;
    private double openingamt;
    private double receiveamt;
    private double paymentamt;
    private double outstandingamt;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false)
    @JsonIgnoreProperties({"customers"})
    private Agents agent;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("customers")
    private List<Orders> orders = new ArrayList<>();

    public Customers(String custname, String custcity, String workingarea, String custcountry, String grade, double openingamt, double receiveamt, double paymentamt, double outstandingamt, String phone, Agents agent) {
        this.custname = custname;
        this.custcity = custcity;
        this.workingarea = workingarea;
        this.custcountry = custcountry;
        this.grade = grade;
        this.openingamt = openingamt;
        this.receiveamt = receiveamt;
        this.paymentamt = paymentamt;
        this.outstandingamt = outstandingamt;
        this.phone = phone;
        this.agent = agent;

    }


    public Customers() {

    }

    public long getCustCode() {
        return custcode;
    }

    public void setCustCode(long custCode) {
        this.custcode = custCode;
    }

    public String getCustName() {
        return custname;
    }

    public void setCustName(String custName) {
        this.custname = custName;
    }

    public String getCustCity() {
        return custcity;
    }

    public void setCustCity(String custCity) {
        this.custcity = custCity;
    }

    public String getWorkingArea() {
        return workingarea;
    }

    public void setWorkingArea(String workingArea) {
        this.workingarea = workingArea;
    }

    public String getCustCountry() {
        return custcountry;
    }

    public void setCustCountry(String custCountry) {
        this.custcountry = custCountry;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getOpeningAmt() {
        return openingamt;
    }

    public void setOpeningAmt(double openingAmt) {
        this.openingamt = openingAmt;
    }

    public double getReceiveAmt() {
        return receiveamt;
    }

    public void setReceiveAmt(double receiveAmt) {
        this.receiveamt = receiveAmt;
    }

    public double getPaymentAmt() {
        return paymentamt;
    }

    public void setPaymentAmt(double paymentAmt) {
        this.paymentamt = paymentAmt;
    }

    public double getOutstandingAmt() {
        return outstandingamt;
    }

    public void setOutstandingAmt(double outstandingAmt) {
        this.outstandingamt = outstandingAmt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Agents getAgent() {
        return agent;
    }

    public void setAgent(Agents agent) {
        this.agent = agent;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
