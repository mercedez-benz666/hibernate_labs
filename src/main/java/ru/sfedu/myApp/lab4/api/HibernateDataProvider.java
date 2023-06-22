package ru.sfedu.myApp.lab4.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.sfedu.myApp.lab4.util.HibernateUtil;

public class HibernateDataProvider {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Session session ;
    private Transaction transaction;
    private Logger log = LogManager.getLogger(HibernateDataProvider.class);
    public void saveEntity(Object entity) throws Exception {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    public Object getEntity(Class cl, String id){
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        return session.get(cl, id);
    }

    public void updateEntity(Object entity){
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }
    public void deleteEntity(Object obj) throws Exception {
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.delete(obj);
        transaction.commit();
        session.close();
        }

}
