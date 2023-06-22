package ru.sfedu.myApp.lab3.strtg2.api;

import org.junit.jupiter.api.Test;
import ru.sfedu.myApp.lab3.strtg2.model.Storage;
import ru.sfedu.myApp.lab3.strtg2.model.Action;

import static org.jgroups.util.Util.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class HibernateDataProviderTest {
    HibernateDataProvider dataProvider=new HibernateDataProvider();

    @Test
    void saveEntity() throws Exception {
        Storage storage = new Storage(123,123,234);
        Action action = new Action();
        dataProvider.saveEntity(action);
        dataProvider.saveEntity(storage);
        Object obj = dataProvider.getEntity(Storage.class,storage.getId());
        assertNotNull(obj);
        //dataProvider.deleteEntity(storage);
    }
}