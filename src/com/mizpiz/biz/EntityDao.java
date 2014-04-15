package com.mizpiz.biz;


import com.mizpiz.presist.obj.Myentity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by babak on 2014-04-03.
 */
public class EntityDao {
    public  Myentity createEntity(Myentity entity) throws MizpizException {
        Transaction trns = null;
        Query query = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(entity);
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
            return entity;
        }
    }


    public  void deleteEntity(int entityID) throws MizpizException {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Myentity entity = (Myentity) session.load(Myentity.class, new Integer(entityID));
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

    public  void updateEntity(Myentity entity) throws MizpizException {
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


    public long loadbyName(Myentity entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Myentity> result = session.createCriteria(Myentity.class)
                .add(Restrictions.like("name", entity.name))
                .list();
        if (!result.isEmpty()) {
            entity = (Myentity) result.get(0);
            return entity.id;
        } else return 0;

    }

    public Myentity loadbyID(long ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Myentity) session.load(Myentity.class, ID);
    }
}
