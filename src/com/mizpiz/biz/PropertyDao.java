package com.mizpiz.biz;
import com.mizpiz.presist.obj.Property;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by babak on 2014-04-03.
 */
public class PropertyDao {
    public static void createProperty(Property property) throws MizpizException{
        Transaction trns = null;
        Query query=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            String hql = "FROM  com.mizpiz.presist.obj.Property E WHERE E.name = :property_name";
            query = session.createQuery(hql);
            query.setParameter("property_name",property.getName());
            List results = query.list();
            System.out.print("results size"+ results.size()+ "\n");
            if(results.size() != 0) {
                 System.out.print(property.toString()+"Already exists \n");
               // throw new MizpizException(MizpizException.Uniqueness_ERROR);
            }
                else {
                session.save(property);
                session.getTransaction().commit();
                System.out.print("Saved! \n" );
            }

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
}
