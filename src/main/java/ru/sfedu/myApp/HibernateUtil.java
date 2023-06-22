package ru.sfedu.myApp;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.sfedu.myApp.lab2.model.User;

import java.io.File;


public class HibernateUtil {
    private static String defaultConfigPath = "src/main/resources/API.properties";
    private static SessionFactory sessionFactory = buildSessionFactory();
    public HibernateUtil(){
    }
    private static SessionFactory buildSessionFactory() {
        try {
            File file=new File("/home/viktor/Desktop/Project/src/main/resources/hibernate.cfg.lab3strtg1.xml");
            Configuration configuration = new Configuration().configure(file);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            MetadataSources metadataSources = new MetadataSources(serviceRegistry);
            metadataSources.addAnnotatedClass(User.class);
            sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
            return sessionFactory;
        }
        catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }

}


