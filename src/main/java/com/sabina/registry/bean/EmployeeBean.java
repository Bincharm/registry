package com.sabina.registry.bean;

import com.sabina.registry.dao.EmployeeDAO;
import com.sabina.registry.entity.Employee;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "employeeBean")
@RequestScoped
public class EmployeeBean {
    private List<Employee> employeeList;

    private int id;
    private String employeeName;
    private String homePhoneNumber;

    private String cellphoneNumber;
    private String workPhoneNumber;
    private String homeAddress;
    private String email;
    private String bankDetails;
    private String position;

    private int companyId;

    private String requiredMessage = "This field is required";

    public EmployeeBean() {

    }

    @PostConstruct
    public void init() {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Map<String, String> requestParameterMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        String employeeId = requestParameterMap.get("id");
        String compId = requestParameterMap.get("companyId");

        // get employee details
        if (employeeId != null) {
            int parsedId = Integer.parseInt(employeeId);
            System.out.println("ID =  " + parsedId);

            Employee employee = employeeDAO.getEmployee(parsedId);

            if (employee == null) {
                System.out.println("User not found: " + parsedId);
                return;
            }

            id = parsedId;
            employeeName = employee.getEmployeeName();
            homePhoneNumber = employee.getHomePhoneNumber();
            cellphoneNumber = employee.getCellphoneNumber();
            workPhoneNumber = employee.getWorkPhoneNumber();
            homeAddress = employee.getHomeAddress();
            email = employee.getEmail();
            bankDetails = employee.getBankDetails();
            position = employee.getPosition();
            companyId = employee.getCompany().getId();
        }

        // get employees by companies
        else if (compId != null) {
            int parsedId = Integer.parseInt(compId);
            System.out.println("companyId = " + parsedId);
            employeeList = employeeDAO.getAllEmployees(parsedId);
            companyId = parsedId;
        }

        // get all employees
        else {
            employeeList = employeeDAO.getAllEmployees();
        }
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public String save() {

        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = new Employee(employeeName, homePhoneNumber, cellphoneNumber, workPhoneNumber,
                                         homeAddress, email, bankDetails, position, companyId);
        employeeDAO.save(employee);
        System.out.println("Employee has been successfully saved.");

        return "list-employees?faces-redirect=true&companyId=" + companyId;
    }

    public String redirectToUpdatePage(int id) {
        return "edit-employee?faces-redirect=true&id=" + id;
    }

    public String update() {
        System.out.println(employeeName + " " + homePhoneNumber + " Id: " + id);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = new Employee(employeeName, homePhoneNumber, cellphoneNumber, workPhoneNumber,
                                         homeAddress, email, bankDetails, position, companyId);
        employee.setId(id);
        employeeDAO.update(employee);
        System.out.println("Employee has been successfully saved.");

        return "list-employees?faces-redirect=true";
    }

    public String delete(int id) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.delete(id);
        System.out.println(id);
        System.out.println("Employee has been successfully deleted.");

        return "list-employees?faces-redirect=true";
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

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getRequiredMessage() {
        return requiredMessage;
    }

    public void setRequiredMessage(String requiredMessage) {
        this.requiredMessage = requiredMessage;
    }

}







