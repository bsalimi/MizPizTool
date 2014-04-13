
import com.mizpiz.biz.CRUD;
import com.mizpiz.biz.EntityDao;
import com.mizpiz.biz.HibernateUtil;
import com.mizpiz.biz.MizpizException;
import com.mizpiz.presist.obj.*;
import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Array;

import javax.transaction.Transaction;
import java.awt.*;
import java.lang.ExceptionInInitializerError;
import java.lang.String;
import java.lang.System;
import java.lang.Throwable;
import java.util.*;
import java.util.List;

/**
 * Created by The Killer on 16/03/14.
 */
public class Main {


    public void printProperty() {
        Property p1 = new Property();
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        p1 = (Property) session.load(Property.class, 1);
        System.out.print(p1.toString());
    }

    public void MakeDEfaultEntity() {
        Entity e1 = new Entity();
        Property p1 = new Property();
        Property p2 = new Property();
        p1.setType("String");
        p2.setType("String");

        p1.setName("price");
        p2.setName("Brand");

        e1.setName("bicycle");
        Set<Property> propertySet = new HashSet<Property>();
        propertySet.add(p1);
        propertySet.add(p2);
        e1.setProperties(propertySet);
        CRUD crud = new CRUD();
        try {
            System.out.print(e1.toString());
            crud.entityDao.createEntity(e1);
        } catch (MizpizException e) {
            e.printStackTrace();
            System.out.print("e");

        }
    }

    public void testInstance() {
        org.hibernate.Transaction trns = null;
        Query query = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Instance instance = new Instance();
        instance.setName("mybic");
        Entity entity= (Entity) session.load(Entity.class, new Integer(2));
        instance.setEntity(entity);

        Set<Value> valuset=new HashSet<Value>();
        Property[]  properties= new Property[10] ;
        StringVal stringVal1=new StringVal();
        StringVal stringVal2=new StringVal();
        stringVal1.setValue("200");
        stringVal2.setValue("kohestan");
        Set<Property> propertySet = entity.getProperties();
        int i=0;

        for (Property property : propertySet) {
            if(property.getId()!= 0)
            properties[i]=property;
            System.out.print(i);
            i++;

        }

        for (int j = 0; j < 2; j++) {

            Property property = properties[j];

         //   System.out.print(properties[j].toString());

        }
        stringVal1.setProperty(properties[1]);
        stringVal2.setProperty(properties[2]);
        valuset.add(stringVal1) ;
        valuset.add(stringVal2);
        CRUD crud = new CRUD();
        instance.setValue(valuset);
      //  System.out.print("instance is :"+ instance.getValue().toString());
       try{

           crud.instanceDao.createInstance(instance);
       } catch (MizpizException e) {
           e.printStackTrace();
           System.out.print("e");
       }
    }

    public static void main(String[] args) throws MizpizException {
    //    new Main().MakeDEfaultEntity();
   //     CRUD crud = new CRUD();
   //       crud.entityDao.deleteEntity(1);
        new Main().testInstance();
        //   new Main().testInstance();
        //   System.out.print("Done!");


    }


}
