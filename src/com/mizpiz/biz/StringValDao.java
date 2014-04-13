package com.mizpiz.biz;

import com.mizpiz.presist.obj.StringVal;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by babak on 2014-04-04.
 */
public class StringValDao {
    public static void createString(StringVal string) throws MizpizException{
        Transaction trns = null;
        Query query=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
     //       String hql = "FROM  com.mizpiz.presist.obj.Value E WHERE  E.valE.value = :string_val";
     //       query = session.createQuery(hql);
     //       query.setParameter("string_val",string.getValue());
     //       List results = query.list();
     //       System.out.print("results size"+ results.size()+ "\n");
     //       if(results.size() != 0) {
     //           System.out.print(string.toString()+"Already exists \n");
    //            throw new MizpizException(MizpizException.Uniqueness_ERROR);
            //    string.toString();
       //         session.s;
            session.save(string);
            session.getTransaction().commit();
                System.out.print("Value Saved! \n" );

        } catch (HibernateException e) {
            if (trns != null) {
                System.out.print("Exeption! \n" );
                trns.rollback();
                throw new MizpizException(MizpizException.PERSISTING_ERROR);
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }


    public static void deleteString(int stringID) throws MizpizException {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String string = (String) session.load(StringVal.class, new Integer(stringID));
            session.delete(string);
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

    public static void updateString(StringVal string) throws MizpizException {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(string);
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
