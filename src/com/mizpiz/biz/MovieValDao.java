package com.mizpiz.biz;

import com.mizpiz.presist.obj.*;
import com.mizpiz.presist.obj.SubValues.MovieVal;
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
    public class  MovieValDao {
        public static void createEntity(MovieVal val ) throws MizpizException {
            Transaction trns = null;
            Query query=null;
            Session session = HibernateUtil.getSessionFactory().openSession();
            try{
                trns = session.beginTransaction();
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


        public  void deleteValue(int ValID) throws MizpizException {
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

        public  void updateValue(MovieVal val) throws MizpizException {
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


