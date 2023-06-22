package ru.sfedu.myApp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.sfedu.myApp.entity.Delivery;
import ru.sfedu.myApp.entity.Payment;
import ru.sfedu.myApp.entity.Storage;
import ru.sfedu.myApp.entity.User;


import static org.junit.jupiter.api.Assertions.*;

class DataBaseProviderTest {
    private static final Logger log = LogManager.getLogger(DataProviderXMLTest.class);
    private static DataBaseProvider dataProvider;

    static Storage test_action1 = new Storage(122,213,1232,true,3,"storage","monaco",5);
    static Storage test_action2 = new Storage(132,123,22,true,3,"storage","rus",5);
    static Storage test_action3 = new Storage(11,23,34,true,20,"storage","Russia",3);
    static Payment test_action4 = new Payment(1233, "payment","Russia",4);
    static Delivery test_action5 = new Delivery(12,21,45,false,10000,"delivery","Russia",5);
    static Storage test_action6 = new Storage(1322,22,45,false,6,"storage","usa",6);
    static User test_user1 = new User("Merc1234","123ASDF","admin");
    static User test_user2 = new User("Merc1235","123ASDD","user");
    static User test_user3 = new User("Merc1236","123ASDS","user");
    static User test_user4 = new User("Merc1237","123ASDW","user");
    static User test_user5 = new User("Merc1238","123ASDE","user");
    static User test_user6 = new User("Merc1239","123ASDR","user");
    static User test_user7 = new User("Merc12310","123ASDQ","user");

    @BeforeAll
    static void init() throws Exception {
        dataProvider = new DataBaseProvider();
    }

    @AfterAll
    static void closeDataBase() throws Exception{
        dataProvider.closeConnection();
    }

    @Test
    void saveUserPositive() throws Exception {
        dataProvider.saveUserRecord(test_user1);
        dataProvider.saveActionRecord(test_action5, test_user1.getUserId());
        assertNotNull(dataProvider.getUserRecordByID(test_user1.getUserId()));
    }

    @Test
    void saveUserNegative() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            dataProvider.saveUserRecord(test_user1);
            dataProvider.saveUserRecord(test_user1);
        });
        assertEquals("record with this id has been saved previously", exception.getMessage());
    }

    @Test
    void saveActionPositive() throws Exception {
        dataProvider.saveUserRecord(test_user2);
        dataProvider.saveActionRecord(test_action3, test_user2.getUserId());
        assertNotNull(dataProvider.getActionRecordByUserID(test_user2.getUserId()));
    }

    @Test
    void saveActionNegative() throws Exception{
        Exception exception = assertThrows(Exception.class, () -> {
            dataProvider.saveActionRecord(test_action6, "5eb16df4-c185-4979-ae11-e96926f092fb");
        });
        assertEquals("Action with this id has been saved previously", exception.getMessage());
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
        assertEquals("there is no record with this id", exception.getMessage());
    }

    @Test
    void getActionRecordByUserIDPositive() throws Exception {
        dataProvider.saveUserRecord(test_user5);
        dataProvider.saveActionRecord(test_action1, test_user5.getUserId());
        assertNotNull(dataProvider.getActionRecordByUserID(test_action1.getUserId()));
    }

    @Test
    void getActionRecordByUserIDNegative() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            dataProvider.getActionRecordByUserID("kmsdfdsfsfsdfsdf");
        });
        assertEquals("No records with this id", exception.getMessage());
    }

    @Test
    void getActionRecordByIDPositive() throws Exception {
        dataProvider.saveUserRecord(test_user6);
        dataProvider.saveActionRecord(test_action6, test_user6.getUserId());
        assertNotNull(dataProvider.getActionRecordByID(test_action6.getId()));
    }

    @Test
    void getActionRecordByIDNegative() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            dataProvider.getActionRecordByID("dfbnslkfmfsdiu");
        });
        assertEquals("No records with this id", exception.getMessage());
    }
    @Test
    void deleteOneActionRecordPositive() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            dataProvider.saveUserRecord(test_user7);
            dataProvider.saveActionRecord(test_action4, test_user7.getUserId());
            dataProvider.deleteOneActionRecord(test_action4.getId());
            dataProvider.getActionRecordByID(test_action4.getId());
        });
        assertEquals("there is no record with this id", exception.getMessage());
    }

    @Test
    void deleteOneActionRecordNegative() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            dataProvider.deleteOneActionRecord("lersdfdsfretmn");
        });
        assertEquals("No records with this id", exception.getMessage());

    }

    @Test
    void deleteUserRecordPositive() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            dataProvider.saveUserRecord(test_user3);
            dataProvider.saveActionRecord(test_action2, test_user3.getUserId());
            dataProvider.deleteUserRecord(test_user3.getUserId());
            dataProvider.getUserRecordByID(test_user3.getUserId());
        });
        assertEquals("there is no record with this id", exception.getMessage());
    }

    @Test
    void deleteUserRecordNegative() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            dataProvider.deleteUserRecord("sdfsfsdferwrvc");
        });
        assertEquals("Error at saving Mongo DB record", exception.getMessage());
    }
}