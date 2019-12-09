/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sstu.accp.lessons.lesson15;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Губин_Н
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        System.out.println("БД");
        try {
            Class.forName("org.sqlite.JDBC");//загрузка драйвера
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Драйвер загружен");

        //подключение к бд
        Connection conn = DriverManager.getConnection("jdbc:sqlite:Z:\\java_db\\users.db");
        System.out.println("Подключено к БД");

        //создание репозитория
        UserRepository userRepository = new UserRepository(conn);

        System.out.println("---------------------");
        ArrayList<User> users = userRepository.getAll();//получение списка пользователей из 
        for (User u : users) {
            System.out.println(u);
        }
        System.out.println("---------------------");
        User u = userRepository.getById(1);
        System.out.println(u);
        User u2 = userRepository.getById(5);
        System.out.println(u2);

        User u3 = new User("Николаев", "Николай", 33, 33333.33);
        userRepository.add(u3);//добавить пользователя в бд

        System.out.println("---------------------");
        users = userRepository.getAll();
        for (User item : users) {
            System.out.println(item);
        }

        User u4 = userRepository.getById(5);
        if (u4 != null) {
            u4.setSalary(44444.45);
            u4.setFirstName("Василий");
            userRepository.update(u4);//обновить данные для пользователя

            System.out.println("---------------------");
            users = userRepository.getAll();
            for (User item : users) {
                System.out.println(item);
            }
        }

        userRepository.delete(5);//удалить пользователя по id
        System.out.println("---------------------");
        users = userRepository.getAll();
        for (User item : users) {
            System.out.println(item);
        }

    }
}
