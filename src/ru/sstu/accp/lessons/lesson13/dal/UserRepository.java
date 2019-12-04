/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sstu.accp.lessons.lesson13.dal;

import java.util.ArrayList;
import ru.sstu.accp.lessons.lesson13.entities.User;

public class UserRepository {

    final static ArrayList<User> USERS = new ArrayList<>();

    static {
        USERS.add(new User("Petrov", "Petr", 30, 15000));
        USERS.add(new User("Sidorova", "Masha", 40, 10001));
        USERS.add(new User("Sidorova", "Marina", 40, 10001));
        USERS.add(new User("Sidorov", "Sidr", 20, 20000));
        USERS.add(new User("Ivanov", "Ivan", 20, 10000));
        USERS.add(new User("Ivanov", "Ivan", 30, 10000));
    }

    public void add(User user) {

    }

    public void delete(User user) {

    }

    public void update(User user) {

    }

    public User getById(int id) {
        return null;
    }

    public ArrayList<User> getAll() {
        return USERS;
    }
}
