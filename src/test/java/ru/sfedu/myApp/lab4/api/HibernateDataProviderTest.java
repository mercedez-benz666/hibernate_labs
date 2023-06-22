package ru.sfedu.myApp.lab4.api;

import org.junit.jupiter.api.Test;

import ru.sfedu.myApp.lab4.model.*;

import ru.sfedu.myApp.lab4.api.HibernateDataProvider;


import static org.jgroups.util.Util.assertNotNull;


class HibernateDataProviderTest {
    HibernateDataProvider dataProvider = new HibernateDataProvider();
    @Test
    public void testSetCollectionCrud() throws Exception{
        Storage storage = new Storage();
        storage.addAddress("Malugina123");
        storage.addAddress("Milchakova10");
        storage.addAddress("Filimonovskaya111");
        dataProvider.saveEntity(storage);
        Object obj = dataProvider.getEntity(Storage.class,storage.getId());
        assertNotNull(obj);
        //dataProvider.deleteEntity(obj);
    }
    @Test
    public void testListCollectionCrud() throws Exception {
        User user = new User("Van","Main st 22222");
        user.addCars(892890904);
        user.addCars(141241241);
        user.addCars(214412414);
        dataProvider.saveEntity(user);
        user.addCars(124141241);
        dataProvider.updateEntity(user);
        Object obj = dataProvider.getEntity(User.class,user.getId());
        assertNotNull(obj);
        System.out.println(user.getCars().stream().toList());
        //dataProvider.deleteEntity(obj);
    }
    @Test
    public void testMapCollectionCrud() throws Exception {
        User user = new User("John", "123 St");
        user.getMyMap().put("BMW", "X5");
        user.getMyMap().put("Audi", "Q5");
        user.addCars(1);
        user.addCars(2);
        dataProvider.saveEntity(user);
        System.out.println(user.getCars().stream().toList());
        assertNotNull(user.getId());
    }
}