package com.mizpiz.biz.crud;

import com.mizpiz.biz.HibernateUtil;
import com.mizpiz.biz.MizpizException;
import com.mizpiz.presist.obj.Myentity;
import com.mizpiz.presist.obj.Value;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by babak on 2014-04-15.
 */
public class ValueDao {
    public static Value createValue(Value value) throws MizpizException {
        Transaction trns = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(value);
            session.getTransaction().commit();
            System.out.print("Saved! \n");
        } catch (HibernateException e) {
            e.printStackTrace();
            if (trns != null) {
                trns.rollback();
                throw new MizpizException(MizpizException.PERSISTING_ERROR);
            }
        } finally {
            session.close();
            return value;
        }
    }

    public static void deleteValue(int ValueID) throws MizpizException {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Myentity entity = (Myentity) session.load(Myentity.class, new Integer(ValueID));
            session.delete(entity);
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

    public static void updateValue(Myentity entity) throws MizpizException {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
                throw new MizpizException(MizpizException.PERSISTING_ERROR);
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public static long loadbyDV(String dic, String val) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Myentity> result = session.createCriteria(Value.class)
                .add(Restrictions.like("value", val))
                .list();
        if (!result.isEmpty()) {
            return  result.get(0).id;
        } else return 0;
    }

    public static Value loadbyID(long ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Value) session.load(Value.class, ID);
    }
}
