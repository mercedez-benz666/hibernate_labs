package ru.sfedu.myApp.lab3.strtg1.api;

import org.junit.jupiter.api.Test;
import ru.sfedu.myApp.lab3.strtg1.model.Storage;
import ru.sfedu.myApp.lab4.api.HibernateDataProvider;

import static org.jgroups.util.Util.assertNotNull;

class HibernateDataProviderTest  {
    HibernateDataProvider dataProvider = new HibernateDataProvider();

    @Test
    void Entity() throws Exception {
        Storage storage = new Storage(123,123,234);
        dataProvider.saveEntity(storage);
        Object obj = dataProvider.getEntity(Storage.class,storage.getId());
        assertNotNull(obj);
        dataProvider.deleteEntity(storage);
    }
}