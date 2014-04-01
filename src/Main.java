
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;import java.lang.ExceptionInInitializerError;import java.lang.String;import java.lang.System;import java.lang.Throwable;

/**
 * Created by The Killer on 16/03/14.
 */
public class Main {
    private static SessionFactory factory;
    public static void main(String[] args) {
        try{
            factory = new Configuration().configure().buildSessionFactory();
         }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        System.out.print("dahane amat koni!");
    }
}