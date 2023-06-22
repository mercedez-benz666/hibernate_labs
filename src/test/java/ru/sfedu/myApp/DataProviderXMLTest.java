package ru.sfedu.myApp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.sfedu.myApp.entity.Delivery;
import ru.sfedu.myApp.entity.Payment;
import ru.sfedu.myApp.entity.Storage;
import ru.sfedu.myApp.entity.User;


import static org.junit.jupiter.api.Assertions.*;

class DataProviderXMLTest {
    private static final Logger log = LogManager.getLogger(DataProviderXMLTest.class);
    private static DataProviderXML dataProvider;
    static Delivery test_action2 = new Delivery(123,12,23,true,20000,"delivery","Russia",2);
    static Storage test_action3 = new Storage(11,23,34,true,20,"storage","Russia",3);
    static Payment test_action4 = new Payment(1233, "payment","Russia",4);
    static Delivery test_action5 = new Delivery(12,21,45,false,10000,"delivery","Russia",5);
    static Delivery test_action8 = new Delivery(121,211,495,false,12000,"delivery","Chile",6);

    static Storage test_action6 = new Storage(100,22,22,false,12,"storage","Russia",7);
    static Payment test_action7 = new Payment(10000,"payment","Russia",8);

    static User test_user1 = new User("viktor","464103","admin");
    static User test_user2 = new User("ivan","112233","client");
    static User test_user3 = new User("max","1234","client");
    static User test_user4 = new User("nikita","1111","client");


    @BeforeAll
    static void init() throws Exception {
        dataProvider = new DataProviderXML();
        Payment test_action1 = new Payment(33000,"payment","Russia",1);
    }

    @Test
    void saveUserPositive() throws Exception {
        dataProvider.saveUserRecord(test_user1);
        assertNotNull(dataProvider.getUserRecordByID(test_user1.getUserId()));
    }

    @Test
    void saveUserNegative() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {dataProvider.saveUserRecord(test_user1);});
        assertEquals("User with those parameters has been created previously",
                exception.getMessage());
    }


    @Test
    void saveDeliveryNegative() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            dataProvider.saveActionRecord(test_action2, "29eda22f-c5b6-48a7-896c-7f6a02d134f1");
        });
        assertEquals("Impossible to save Action, user with this id not found, check user's id", exception.getMessage());
    }

    @Test
    void getUserRecordByIDPositive() throws Exception {
        dataProvider.saveUserRecord(test_user4);
        assertNotNull(dataProvider.getUserRecordByID(test_user4.getUserId()));
    }

    @Test
    void getUserRecordByIDNegative() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            dataProvider.getUserRecordByID("kmsdfsdfsdf");
        });
        assertEquals("Record not found", exception.getMessage());
    }

    @Test
    void getActionRecordByUserIDNegative() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            dataProvider.getActionRecordByUserID("kmsdfdsfsfsdfsdf");
        });
        assertEquals("Record not found", exception.getMessage());
    }

}