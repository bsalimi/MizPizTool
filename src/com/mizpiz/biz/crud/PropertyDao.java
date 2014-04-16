package com.mizpiz.biz.crud;

import com.mizpiz.biz.HibernateUtil;
import com.mizpiz.biz.MizpizException;
import com.mizpiz.presist.obj.Property;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by babak on 2014-04-03.
 */
public class PropertyDao {
    public static void createProperty(Property property) throws MizpizException {
        Transaction trns = null;
        Query query = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(property);
            session.getTransaction().commit();
            System.out.print("Saved! \n");
        } catch (HibernateException e) {
            if (trns != null) {
                trns.rollback();
                throw new MizpizException(MizpizException.PERSISTING_ERROR);
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public static void deleteProperty(int propertyID) throws MizpizException {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Property property = (Property) session.load(Property.class, new Integer(propertyID));
            session.delete(property);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
                throw new MizpizException(MizpizException.PERSISTING_ERROR);
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public static void updateProperty(Property property) throws MizpizException {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(property);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
                throw new MizpizException(MizpizException.PERSISTING_ERROR);
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public static long loadbyNandT(Property property) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Property> result = session.createCriteria(Property.class)
                   .add(Restrictions.like("name", property.getName()))
                 .add(Restrictions.like("type", property.getType()))
              .list();
          System.out.print("list size"+result.size());
            if (!result.isEmpty()) {
               property = (Property) result.get(0);
                return property.getId();
            } else return 0;
    }

    public static Property loadbyID(long ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Property) session.load(Property.class, ID);
    }
}

