/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sstu.accp.lessons.lesson13.services;

import java.util.ArrayList;
import ru.sstu.accp.lessons.lesson13.dal.UserRepository;
import ru.sstu.accp.lessons.lesson13.entities.User;

/**
 *
 * @author Губин_Н
 */
public class UserService {

    UserRepository userRepository = new UserRepository();

    public void addUser(User user) {
        userRepository.add(user);
    }

    public ArrayList<User> getUsers() {
        return userRepository.getAll();
    }

    public double getSalaries() {
        ArrayList<User> users = userRepository.getAll();
        double sum = 0;
        for (User u : users) {
            sum += u.getSalary();
        }
        return sum;
    }

}
