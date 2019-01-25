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
    }

    public List<Company> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Company> companies = session.createCriteria(Company.class).list();
        session.close();

        return companies;
    }

    public Company getCompany(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Company company = (Company) session.get(Company.class, id);
        session.close();

        return company;
    }
}