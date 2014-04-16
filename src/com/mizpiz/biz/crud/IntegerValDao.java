package com.mizpiz.biz.crud;

import com.mizpiz.biz.HibernateUtil;
import com.mizpiz.biz.MizpizException;
import com.mizpiz.presist.obj.SubValues.IntegerVal;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by babak on 2014-04-04.
 */
public class IntegerValDao {
    public static void createInteger(IntegerVal integer) throws MizpizException {
        Transaction trns = null;
        Query query=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            String hql = "FROM  com.mizpiz.presist.obj.IntegerVal E WHERE E.name = :integer_val";
            query = session.createQuery(hql);
            query.setParameter("integer_val",integer.getValue());
            List results = query.list();
            System.out.print("results size"+ results.size()+ "\n");
            if(results.size() != 0) {
                System.out.print(integer.toString()+"Already exists \n");
                throw new MizpizException(MizpizException.Uniqueness_ERROR);
            }
            else {
                session.save(integer);
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


    public static void deleteInteger(int integerID) throws MizpizException {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Integer integer = (Integer) session.load(IntegerVal.class,  new Integer(integerID));
            session.delete(integer);
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

    public static void updateInteger(IntegerVal integer) throws MizpizException {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(integer);
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
