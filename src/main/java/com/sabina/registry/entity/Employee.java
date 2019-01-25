package com.sabina.registry.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "home_phone_number")
    private String homePhoneNumber;

    @Column(name = "cellphone_number")
    private String cellphoneNumber;

    @Column(name = "work_phone_number")
    private String workPhoneNumber;

    @Column(name = "home_address")
    private String homeAddress;

    @Column(name = "email")
    private String email;

    @Column(name = "bank_details")
    private String bankDetails;

    @Column(name = "position")
    private String position;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Employee() { }

    public Employee(String employeeName, String homePhoneNumber, String cellphoneNumber, String workPhoneNumber,
                    String homeAddress, String email, String bankDetails, String position, int companyId) {
        this.employeeName = employeeName;
        this.homePhoneNumber = homePhoneNumber;
        this.cellphoneNumber = cellphoneNumber;
        this.workPhoneNumber = workPhoneNumber;
        this.homeAddress = homeAddress;
        this.email = email;
        this.bankDetails = bankDetails;
        this.position = position;
        Company company = new Company();
        company.setId(companyId);
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getWorkPhoneNumber() {
        return workPhoneNumber;
    }

    public void setWorkPhoneNumber(String workPhoneNumber) {
        this.workPhoneNumber = workPhoneNumber;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(String bankDetails) {
        this.bankDetails = bankDetails;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}