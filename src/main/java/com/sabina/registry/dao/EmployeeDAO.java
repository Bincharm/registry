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
//        session.createQuery("delete Entity where id = " + id).executeUpdate();
//        session.close();
    }

//    public Integer getId() {
//        String hql = "select max(user.id) from Employee employee";
//        Query query = session.createQuery(hql);
//        List<Integer> results = query.list();
//        int userId = 1;
//        if (results.get(0) != null) {
//            userId = results.get(0) + 1;
//        }
//        return userId;
//    }

    public List<Employee> getAllEmployees() {
        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.createQuery("select * from employee").list();
        List<Employee> employees = session.createCriteria(Employee.class).list();
        session.close();

        return employees;
    }
}