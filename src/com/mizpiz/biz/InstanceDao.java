package com.mizpiz.biz;

import com.mizpiz.presist.obj.Entity;
import com.mizpiz.presist.obj.Instance;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by babak on 2014-04-03.
 */
public class InstanceDao {
    public static void createEntity(Instance instance) throws MizpizException {
        Transaction trns = null;
        Query query=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            trns = session.beginTransaction();
            String hql = "FROM  com.mizpiz.presist.obj.Instance E WHERE E.name = :Instance_name";
            query = session.createQuery(hql);
            query.setParameter("Instance_name",instance.getName() );
            List results = query.list();
            System.out.print("results size"+ results.size()+ "\n");
            if(results.size() != 0) {
                System.out.print(instance.toString()+"Already exists \n");
                throw new MizpizException(MizpizException.Uniqueness_ERROR);
            }
            else {
                session.save(instance);
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


    public static void deleteEntity(int entityID) throws MizpizException {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Entity entity = (Entity) session.load(Entity.class, new Integer(entityID));
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

    public static void updateEntity(Entity entity) throws MizpizException {
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
            session.flush();
            session.close();
        }
    }
}
