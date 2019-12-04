/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sstu.accp.lessons.lesson13.ui;

import java.util.ArrayList;
import ru.sstu.accp.lessons.lesson13.entities.User;
import ru.sstu.accp.lessons.lesson13.services.UserService;

/**
 *
 * @author Губин_Н
 */
public class UserView {

    UserService userService = new UserService();

    public void showUsers() {
        ArrayList<User> users = userService.getUsers();
        for (User u : users) {
            System.out.println(u);
        }
    }

    public void showSalary() {
        double s = userService.getSalaries();
        System.out.println("З/п: " + s);
    }

}
