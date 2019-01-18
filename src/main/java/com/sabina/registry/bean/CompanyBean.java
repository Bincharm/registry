package com.sabina.registry.bean;

import com.sabina.registry.dao.CompanyDAO;
import com.sabina.registry.entity.Company;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import java.util.List;

@ManagedBean(name = "companyBean", eager = true)
@SessionScoped
public class CompanyBean {

    private Integer id;

    private String typeOfOwnership;

    private String legalForm;

    public CompanyBean() {

    }

//    private static final Company[] companyList = new Company[] {
//        new Company("Intel CPU", "123"),
//        new Company("Intel weCPU", "1323"),
//        new Company("Intel 23CPU", "12233"),
//    };

//    public Company[] getCompanyList() {
////        return companyList;
////    }

    public List<Company> getCompanyList() {
        CompanyDAO companyDAO = new CompanyDAO();
        return companyDAO.getAll();
    }

    public String save() {
        CompanyDAO companyDAO = new CompanyDAO();
        Company company = new Company(typeOfOwnership, legalForm);
        companyDAO.save(company);
        System.out.println("Company has been successfully saved.");

        return "list-companies";
    }

    public String updatePage(Company o) {
        this.id = o.getId();
        this.typeOfOwnership = o.getTypeOfOwnership();
        this.legalForm = o.getLegalForm();

        return "edit-company";
    }

    public String update() {
        CompanyDAO companyDAO = new CompanyDAO();
        Company company = new Company(typeOfOwnership, legalForm);
        company.setId(id);
        companyDAO.update(company);
        System.out.println("Company has been successfully saved.");

        return "list-companies";
    }

    public String delete(int id) {
        CompanyDAO companyDAO = new CompanyDAO();
        companyDAO.delete(id);
        System.out.println(id);
        System.out.println("Company successfully deleted.");

        return "list-companies";
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

    public void validateTheCourseCode(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        if (value == null) {
            return;
        }

        String data = value.toString();

        // course validation
        if (!data.startsWith("Sabina")) {

            FacesMessage message = new FacesMessage("Course must start with Sabina");

            throw new ValidatorException(message);
        }
    }

}







