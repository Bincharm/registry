package com.sabina.registry.bean;

import com.sabina.registry.dao.CompanyDAO;
import com.sabina.registry.entity.Company;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import java.util.List;
import java.util.Map;
import java.util.Date;

@ManagedBean(name = "companyBean")
@RequestScoped
public class CompanyBean {

    private Integer id;

    private String typeOfOwnership;

    private String legalForm;

    private String companyName;

    private String managerName;

    private String fax;

    private String phoneNumber;

    private String webPage;

    private String licenseNumber;

    private Date licenseDate;

    private String certificateNumber;

    private Date certificateDate;

    private String address;

    private String attachedFilesPath;

    public CompanyBean() {

    }

    private List<Company> companyList;


    @PostConstruct
    public void init() {
        CompanyDAO companyDAO = new CompanyDAO();
        Map<String, String> requestParameterMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        String companyId = requestParameterMap.get("id");

        // if "id" parameter is specified
        // retrieve company with such id
        // otherwise get list of all companies
        if (companyId != null) {
            int parsedId = Integer.parseInt(companyId);
            System.out.println("ID =  " + parsedId);

            Company company = companyDAO.getCompany(parsedId);

            // fulfill bean with entity properties
            id = parsedId;
            typeOfOwnership = company.getTypeOfOwnership();
            legalForm = company.getLegalForm();
            companyName = company.getCompanyName();
            managerName = company.getManagerName();
            fax = company.getFax();
            phoneNumber = company.getPhoneNumber();
            webPage = company.getWebPage();
            licenseNumber = company.getLicenseNumber();
            licenseDate = company.getLicenseDate();
            certificateNumber = company.getCertificateNumber();
            certificateDate = company.getCertificateDate();
            address = company.getAddress();
            attachedFilesPath = company.getAttachedFilesPath();
        } else {
            companyList = companyDAO.getAll();
        }

    }


    public List<Company> getCompanyList() {
        return companyList;
    }

    public String save() {
        CompanyDAO companyDAO = new CompanyDAO();
        Company company = new Company(typeOfOwnership, legalForm, companyName, managerName, fax, phoneNumber,
                webPage, licenseNumber, licenseDate, certificateNumber, certificateDate,
                address, attachedFilesPath);
        companyDAO.save(company);
        System.out.println("Company has been successfully saved.");

        return "list-companies?faces-redirect=true";
    }

    public String redirectToUpdatePage(Company o) {
        return "edit-company?faces-redirect=true&id=" + o.getId();
    }

    public String redirectToEmployeesPage(Company o) {
        return "/pages/employee/list-employees?faces-redirect=true&companyId=" + o.getId();
    }

    public String update() {
        CompanyDAO companyDAO = new CompanyDAO();
        Company company = new Company(typeOfOwnership, legalForm, companyName, managerName, fax, phoneNumber,
                webPage, licenseNumber, licenseDate, certificateNumber, certificateDate,
                address, attachedFilesPath);
        company.setId(id);
        companyDAO.update(company);
        System.out.println("Company has been successfully saved.");

        return "list-companies?faces-redirect=true";
    }

    public String delete(int id) {
        CompanyDAO companyDAO = new CompanyDAO();
        companyDAO.delete(id);
        System.out.println(id);
        System.out.println("Company has been successfully deleted.");

        return "list-companies?faces-redirect=true";
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

    public void setLegalForm(String lastName) {
        this.legalForm = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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