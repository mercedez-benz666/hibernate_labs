package ru.sfedu.myApp.lab2.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.sfedu.myApp.HibernateUtil;
import ru.sfedu.myApp.lab1.api.HibernateDataProvider;
import ru.sfedu.myApp.lab2.model.User;

public class DataProviderSecond {
    Logger log = LogManager.getLogger(HibernateDataProvider.class);
    public DataProviderSecond() {
    }

    public void saveUser(User user) throws Exception {
        Session session;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        Transaction tx = session.beginTransaction();
        try {
            session.persist(user);
            session.save(user);
            tx.commit();
            log.info("Entity has been saved");
        }catch (HibernateException ex) {
            throw new HibernateException(ex.getMessage());
        }
    }

    public void deleteUser(Long id) throws Exception {
        Session session;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        Transaction tx = session.beginTransaction();
        User user = session.get(User.class, id);
        if (user != null) {
            session.delete(user);
            tx.commit();
            log.info("Entity has been deleted");
        } else
            throw new Exception("Entity not found in data source");
    }

    public void updateUser(User user) throws Exception {
        Session session;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        Transaction tx = session.beginTransaction();
        try {
            session.saveOrUpdate(user);
            tx.commit();
            log.info("Entity has been updated");
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    public void getUser(Long id) throws Exception {
        Session session;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        User user = session.get(User.class, id);
        if (user != null) {
            log.info("Entity has been updated");
        } else
            throw new Exception("Entity not found in data source");
    }
}

