package com.sabina.registry.bean;

import com.sabina.registry.dao.EmployeeDAO;
import com.sabina.registry.entity.Employee;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import java.util.List;

@ManagedBean(name = "employeeBean", eager = true)
@SessionScoped
public class EmployeeBean {

    private Integer id;

    private String firstName;

    private String lastName;

    public EmployeeBean() {

    }

    private static final Employee[] employeeList = new Employee[] {
        new Employee("Intel CPU", "123"),
        new Employee("Intel weCPU", "1323"),
        new Employee("Intel 23CPU", "12233"),
    };

//    public Employee[] getEmployeeList() {
////        return employeeList;
////    }

    public List<Employee> getEmployeeList() {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        return employeeDAO.getAllEmployees();
    }

    public String save() {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = new Employee(firstName, lastName);
        employeeDAO.save(employee);
        System.out.println("Employee successfully saved.");

        return "list-employees";
    }

    public String updatePage(Employee o) {
        this.id = o.getId();
        this.firstName = o.getFirstName();
        this.lastName = o.getLastName();

        return "edit-employee";
    }

    public String update() {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = new Employee(firstName, lastName);
        employee.setId(id);
        employeeDAO.update(employee);
        System.out.println("Employee has been successfully saved.");

        return "list-employees";
    }

    public String delete(int id) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.delete(id);
        System.out.println(id);
        System.out.println("Employee successfully deleted.");

        return "list-employees";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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







