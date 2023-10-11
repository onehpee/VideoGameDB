package org.example;

import org.example.repository.TestDB;
import org.example.repository.TestFather;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        TestDB steve = new TestDB();
        steve.talk();
        steve.setMoney(100);
        System.out.println(steve.getMoney());
    }
}