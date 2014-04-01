package com.mizpiz.biz;

import com.mizpiz.presist.obj.Property;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CRUD {
    public static void createProperty(Property property) throws MizpizException {
        try {
            SessionFactory sf = new Configuration().configure().buildSessionFactory();
            Session session = sf.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(property);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new MizpizException(MizpizException.PERSISTING_ERROR);
        }
    }

    public static void main(String[] args) throws MizpizException {
        Property property = new Property();
        property.setName("testProperty");
        property.setType("testType");
        createProperty(property);
    }
}
