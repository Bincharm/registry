package com.sabina.registry.dao;

import com.sabina.registry.entity.Employee;
import com.sabina.registry.util.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

public class EmployeeDAO {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void save(Employee employee) {
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }

    public void update(Employee employee) {
        session.beginTransaction();
        session.update(employee);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Integer id) {
        Employee entity = new Employee();
        entity.setId(id);
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }

    public Employee getEmployee(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Employee employee = (Employee) session.get(Employee.class, id);
        session.close();

        return employee;
    }

    public List<Employee> getAllEmployees() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> employees = session.createCriteria(Employee.class).list();
        session.close();

        return employees;
    }

    public List<Employee> getAllEmployees(int companyId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> employees = session.createQuery("SELECT p FROM Employee p WHERE p.company.id = :companyId").setParameter("companyId", companyId).list();
        session.close();

        return employees;
    }
}