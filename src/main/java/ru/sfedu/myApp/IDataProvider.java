package ru.sfedu.myApp;

import ru.sfedu.myApp.entity.Action;
import ru.sfedu.myApp.entity.History;
import ru.sfedu.myApp.entity.User;

import java.util.List;

public interface IDataProvider {

    String createId();

    void saveUserRecord(User object) throws Exception;

    void saveActionRecord(Action object, String userId) throws Exception;

    void findForDelActionByUser(String id) throws Exception;

    void deleteUserRecord(String id) throws Exception;

    void deleteActionRecord(Action action) throws Exception;

    void deleteOneActionRecord(String id) throws Exception;

    //Action findForGetActionRecordByUserId(String id) throws Exception;

    User getUserRecordByID(String id) throws Exception;

    Action getActionRecordByUserID(String id) throws Exception;

    //Action getDeliveryRecordByID(String id) throws Exception;


    Action getActionRecordByID(String id) throws Exception;
}
