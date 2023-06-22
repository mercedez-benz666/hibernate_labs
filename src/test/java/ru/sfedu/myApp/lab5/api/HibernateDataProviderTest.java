package ru.sfedu.myApp.lab5.api;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;
import ru.sfedu.myApp.lab5.model.Delivery;
import ru.sfedu.myApp.lab5.model.Stock;
import ru.sfedu.myApp.lab5.model.User;
import ru.sfedu.myApp.lab5.util.HibernateUtil;

class HibernateDataProviderTest {
    HibernateDataProvider dataProvider = new HibernateDataProvider();


    @Test
    public void testOneToOneCrud() throws Exception {
        User user = new User("GGGjk", "asd", "user");
        Stock stock = new Stock("main st222");
        user.setStock(stock);
        stock.setUser(user);

        dataProvider.saveEntity(user);
        dataProvider.updateEntity(user);
        dataProvider.deleteEntity(user);
    }

    @Test
    public void testOneToManyCrud() throws Exception {
        User user = new User("asd", "asdsdsa", "customer");
        Delivery delivery = new Delivery(11, 222, 33, 123.87);
        Delivery delivery1 = new Delivery(111, 555, 888, 765.09);
        user.addDelivery(delivery);
        delivery1.setUser(user);
        user.addDelivery(delivery1);
        delivery.setUser(user);
        dataProvider.saveEntity(user);
    }

    @Test
    public void testManyToManyCrud() throws Exception {
        Delivery delivery = new Delivery(234, 765, 876, 777.98);
        Delivery delivery1 = new Delivery(11, 222, 3333, 888.98);

        Stock stock = new Stock("main st 1");
        Stock stock1 = new Stock("main st132456");

        delivery.addStock(stock);
        delivery.addStock(stock1);
        delivery1.addStock(stock1);

        dataProvider.saveEntity(delivery);
        dataProvider.saveEntity(delivery1);
    }

    @Test
    public void testHQL() throws Exception {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = new User("asd", "asdsdsa", "customer");

        Query query = session.createQuery(" SELECT s FROM User s WHERE s.id = :id")
                .setParameter("id", user.getId());
        long start = System.currentTimeMillis();
        query.list();
        long result = System.currentTimeMillis() - start;

        transaction.commit();
        session.close();

        System.out.println(result);//~94


    }
    @Test
    public void testCriteria(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        User user = new User("asd", "asdsdsa", "customer");
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(builder.equal(root.get("id"), user.getId()));

        long start = System.currentTimeMillis();
        session.createQuery(criteriaQuery.select(root)).getResultList();
        long finish = System.currentTimeMillis();
        session.close();

        System.out.println(finish-start);//~125
    }
    @Test
    void testNativeSQL() throws Exception{
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        User user = new User("asd", "asdsdsa", "customer");
        String sql = " SELECT id FROM users WHERE id = 'user.getId()'";
        long start = System.currentTimeMillis();
        session.createNativeQuery(sql).getResultList();
        long finish = System.currentTimeMillis();
        session.close();

        System.out.println(finish-start);//~70
    }
}