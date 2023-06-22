package ru.sfedu.myApp.lab1.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import ru.sfedu.myApp.ConfigUtils;
import ru.sfedu.myApp.HibernateUtil;
import ru.sfedu.myApp.entity.Storage;
import ru.sfedu.myApp.entity.User;

import java.io.IOException;
import java.util.List;

import static ru.sfedu.myApp.Constans.STORAGE_DB;
import static ru.sfedu.myApp.Constans.USER_DB;

public class HibernateDataProvider {
    Logger log = LogManager.getLogger(HibernateDataProvider.class);
    ConfigUtils con = new ConfigUtils();

    public void startHibernate() throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Storage> getListStorage() throws IOException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            NativeQuery query = session.createNativeQuery("SELECT * FROM " + con.getConfigurationEntry(STORAGE_DB));
            List<Storage> result = query.list();
            return result;
        }
    }

    public List<String> getListTable() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            NativeQuery query = session.createNativeQuery("SHOW TABLES ");
            List<String> result = query.list();
            for (String s : result) {
                log.info(s);
            }
            return result;
        }
    }

    public List<User> getInfoUser() throws IOException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            NativeQuery query = session.createNativeQuery("SELECT DISTINCT * FROM " + con.getConfigurationEntry(USER_DB));
            List<User> result = query.list();
            return result;
        }
    }

    public List<String> getDataBases() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            NativeQuery query = session.createNativeQuery("SHOW DATABASES");
            List<String> result = query.list();
            for (String s : result) {
                log.info(s);
            }
            return result;
        }
    }
}
