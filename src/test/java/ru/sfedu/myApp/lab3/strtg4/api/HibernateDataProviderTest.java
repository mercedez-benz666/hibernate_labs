package ru.sfedu.myApp.lab3.strtg4.api;

import org.junit.jupiter.api.Test;

import ru.sfedu.myApp.lab3.strtg4.model.Action;
import ru.sfedu.myApp.lab3.strtg4.model.Storage;

import static org.jgroups.util.Util.assertNotNull;


class HibernateDataProviderTest {
    HibernateDataProvider dataProvider = new HibernateDataProvider();

    @Test
    void saveEntity() throws Exception {
        Storage storage = new Storage(123,123,234,"storage","russia",1,true);
        dataProvider.saveEntity(storage);
        Object obj = dataProvider.getEntity(Storage.class,storage.getId());
        assertNotNull(obj);
        //dataProvider.deleteEntity(obj);
    }
}