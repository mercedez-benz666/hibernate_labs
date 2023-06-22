package ru.sfedu.myApp.lab3.strtg2.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.sfedu.myApp.lab3.strtg2.model.Action;
import ru.sfedu.myApp.lab3.strtg2.model.Storage;

import java.io.File;


public class HibernateUtil {
    private static String defaultConfigPath = "src/main/resources/API.properties";
    private static SessionFactory sessionFactory = buildSessionFactory();

    public HibernateUtil() {
    }

    private static SessionFactory buildSessionFactory() {
        try {
            File file = new File("/home/viktor/Desktop/Project/src/main/resources/hibernate.cfg.lab3strtg2.xml");
            Configuration configuration = new Configuration();
            configuration.configure(file);
            configuration.addAnnotatedClass(Action.class);
            configuration.addAnnotatedClass(Storage.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }

}


