package com.sabina.registry.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "type_of_ownership")
    private String typeOfOwnership;

    @Column(name = "legal_form")
    private String legalForm;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "manager_name")
    private String managerName;

    @Column(name = "fax")
    private String fax;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "web_page")
    private String webPage;

    @Column(name = "license_number")
    private String licenseNumber;

    @Column(name = "license_date")
    private Date licenseDate;

    @Column(name = "certificate_number")
    private String certificateNumber;

    @Column(name = "certificate_date")
    private Date certificateDate;

    @Column(name = "address")
    private String address;

    @Column(name = "attached_files_path")
    private String attachedFilesPath;

    public Company() { }

    public Company(String typeOfOwnership, String legalForm, String companyName, String managerName, String fax, String phoneNumber,
                   String webPage, String licenseNumber, Date licenseDate, String certificateNumber, Date certificateDate,
                   String address, String attachedFilesPath) {
        this.typeOfOwnership = typeOfOwnership;
        this.legalForm = legalForm;
        this.companyName = companyName;
        this.managerName = managerName;
        this.fax = fax;
        this.phoneNumber = phoneNumber;
        this.webPage = webPage;
        this.licenseNumber = licenseNumber;
        this.licenseDate = licenseDate;
        this.certificateNumber = certificateNumber;
        this.certificateDate = certificateDate;
        this.address = address;
        this.attachedFilesPath = attachedFilesPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeOfOwnership() {
        return typeOfOwnership;
    }

    public void setTypeOfOwnership(String typeOfOwnership) {
        this.typeOfOwnership = typeOfOwnership;
    }

    public String getLegalForm() {
        return legalForm;
    }

    public void setLegalForm(String legalForm) {
        this.legalForm = legalForm;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Date getLicenseDate() {
        return licenseDate;
    }

    public void setLicenseDate(Date licenseDate) {
        this.licenseDate = licenseDate;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public Date getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(Date certificateDate) {
        this.certificateDate = certificateDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAttachedFilesPath() {
        return attachedFilesPath;
    }

    public void setAttachedFilesPath(String attachedFilesPath) {
        this.attachedFilesPath = attachedFilesPath;
    }

}