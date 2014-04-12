
import com.mizpiz.biz.CRUD;
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
    public void AddEntity() {
        Entity e1 = new Entity();
        e1.setName("Bicycle");
        Set<Property> propertySet = new HashSet<Property>();
        Property p1, p2, p3;
        p1 = p2 = p3 = new Property();
        p1.setName("Color");
        p1.setType("String");
        p2.setName("Price");
        p2.setType("String");
        p3.setName("model");
        p3.setType("String");
        propertySet.add(p1);
        propertySet.add(p2);
        propertySet.add(p3);
        e1.setProperties(propertySet);
        CRUD crud = new CRUD();
        try {
            crud.entityDao.createEntity(e1);
        } catch (MizpizException e) {
            e.printStackTrace();
            //  System.out.print("e");
        }
    }

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
        p1.setType("color");
        p2.setName("price");
        p2.setType(" Brand");
        e1.setName("bicycle");
        Set<Property> propertySet = new HashSet<Property>();
        propertySet.add(p1);
        propertySet.add(p2);
        e1.setProperties(propertySet);
        CRUD crud = new CRUD();
        try {
            crud.entityDao.createEntity(e1);
        } catch (MizpizException e) {
            e.printStackTrace();
            //  System.out.print("e");
        }
    }

    public void testInstance() {
        org.hibernate.Transaction trns = null;
        Query query = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Instance instance = new Instance();
        instance.setName("mybic");
        Entity entity= (Entity) session.load(Entity.class, new Integer(1));
        instance.setEntity(entity);

        Set<Value> valuset=new HashSet<Value>();
        Property[]  properties= new Property[10] ;
        StringVal stringVal1=new StringVal();
        StringVal stringVal2=new StringVal();
        stringVal1.setValue("200");
        stringVal2.setValue("kohestan");
        Set<Property> propertySet = entity.getProperties();
        int i=0;
        for (Iterator<Property> iterator = propertySet.iterator(); iterator.hasNext(); ) {
            Property next = iterator.next();
            properties[i]=next;
            i++;
        }
        stringVal1.setProperty(properties[1]);
        stringVal2.setProperty(properties[2]);
        valuset.add(stringVal1) ;
        valuset.add(stringVal2);
        CRUD crud = new CRUD();
        instance.setValue(valuset);
        System.out.print(instance.toString());
        try {
            crud.instanceDao.createInstance(instance);
        } catch (MizpizException e) {
            e.printStackTrace();
            System.out.print("e");
        }
    }

    public static void main(String[] args) {
        new Main().AddEntity();
        new Main().testInstance();
        //   new Main().testInstance();
        //   System.out.print("Done!");


    }


}
