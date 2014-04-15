package com.mizpiz.biz;

import com.mizpiz.presist.obj.Myentity;
import com.mizpiz.presist.obj.SubValues.ImageVal;
import com.mizpiz.presist.obj.Value;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by babak on 2014-04-04.
 */

/**
 * Created by babak on 2014-04-03.
 */
public class ImageValDao {
    public static void createEntity(ImageVal val ) throws MizpizException {
        Transaction trns = null;
        Query query=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
     //       String hql = "FROM  com.mizpiz.presist.obj.Value E WHERE E.value = :val_value";
     //       query = session.createQuery(hql);
     //       query.setParameter(val.value);
     //       List results = query.list();
     //       System.out.print("results size"+ results.size()+ "\n");
   //         if(results.size() != 0) {
   //             System.out.print(val.value.toString()+"Already exists \n");
    //            throw new MizpizException(MizpizException.Uniqueness_ERROR);
    //        }
    //        else {
                session.save(val);
                session.getTransaction().commit();
                System.out.print("Saved! \n" );


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


    public static void deleteValue(int ValID) throws MizpizException {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Myentity entity = (Myentity) session.load(Value.class, new Integer(ValID));
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

    public static void updateValue(ImageVal val) throws MizpizException {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(val);
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


