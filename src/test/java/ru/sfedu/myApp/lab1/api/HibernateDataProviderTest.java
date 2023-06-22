package ru.sfedu.myApp.lab1.api;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HibernateDataProviderTest {
    HibernateDataProvider h = new HibernateDataProvider();

    @Test
    void startHibernate() throws Exception {
        h.startHibernate();

    }

    @Test
    void getListStorage() throws IOException {
        h.getListStorage().stream().forEach(System.out::println);


    }

    @Test
    void getListTable() throws IOException{
        h.getListTable().stream().forEach(System.out::println);

    }

    @Test
    void getInfoUser() throws IOException {
        h.getInfoUser().stream().forEach(System.out::println);
    }

    @Test
    void getDataBases() throws IOException{
        h.getDataBases().stream().forEach(System.out::println);

    }
}