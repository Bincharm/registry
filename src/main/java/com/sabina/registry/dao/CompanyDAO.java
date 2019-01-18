package com.sabina.registry.dao;

import com.sabina.registry.entity.Company;
import com.sabina.registry.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class CompanyDAO {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void save(Company company) {
        session.beginTransaction();
        session.save(company);
        session.getTransaction().commit();
        session.close();
    }

    public void update(Company company) {
        session.beginTransaction();
        session.update(company);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Integer id) {
        Company entity = new Company();
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

    public List<Company> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.createQuery("select * from employee").list();
        List<Company> companies = session.createCriteria(Company.class).list();
        session.close();

        return companies;
    }
}