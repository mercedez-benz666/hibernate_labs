package ru.sfedu.myApp.lab2.api;

import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.myApp.lab2.model.Address;
import ru.sfedu.myApp.lab2.model.User;


import java.util.Date;

class DataProviderSecondTest {

        private static final Logger log = LogManager.getLogger(DataProviderSecond.class);
        private static DataProviderSecond dataProvider = new DataProviderSecond();

        static Address address1 = new Address("Russia","Rostov","pushkinskaya",110);

        static Address address2=new Address("Russia","Rostov","stachki",112);
        static User user = new User("Viktor","rider",new Date(),false);

    @Test
    void saveUser() throws Exception {
        dataProvider.saveUser(user);
    }


    @Test
    void deleteUser() throws Exception {
        dataProvider.deleteUser(1L);
    }

    @Test
    void updateUser() throws Exception {
        dataProvider.updateUser(user);
    }

    @Test
    void getUser() throws Exception {
        dataProvider.getUser(2L);
    }
}