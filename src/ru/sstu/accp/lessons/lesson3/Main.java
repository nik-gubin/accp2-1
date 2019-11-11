package ru.sstu.accp.lessons.lesson3;

import java.io.Console;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введение в классы");

        System.out.println("---------------------");
        //создание объекта пользователя
        User ivan = new User();
        //установка значений для полей
        ivan.firstName = "Иван";
        ivan.lastName = "Иванов";
        ivan.age = 35;
        ivan.salary = 10000;
        System.out.println(ivan.lastName + " " + ivan.firstName
                + " " + ivan.age + " " + ivan.salary);

        System.out.println("---------------------");
        //создание объекта пользователя
        User user2 = new User();
        user2.lastName = "Петрова";
        user2.firstName = "Мария";
        user2.age = 30;
        user2.salary = 30000.5;
        System.out.println(user2.lastName + " " + user2.firstName
                + " " + user2.age + " " + user2.salary);

        System.out.println("---------------------");
        ivan.age = ivan.age + 1;//измение значений полей
        ivan.salary = ivan.salary + ivan.salary * 0.04;//измение значений полей
        System.out.println(ivan.lastName + " " + ivan.firstName
                + " " + ivan.age + " " + ivan.salary);

        System.out.println("---------------------");
        User user3 = new User(); //создание объекта пользователя
        System.out.println(user3.lastName + " " + user3.firstName
                + " " + user3.age + " " + user3.salary);

        System.out.println("---------------------");
        User user4 = new User("Петров", "Василий", 45, 45111);
        System.out.println(user4.lastName + " " + user4.firstName
                + " " + user4.age + " " + user4.salary);

        System.out.println("---------------------");
        //вызов метода вывода на экран для пользовтелей
        ivan.getInfo();
        user2.getInfo();
        user4.getInfo();

        System.out.println("---------------------");
        user2.addSalary(20);//изменение зп у пользователя
        user2.getInfo();

        System.out.println("---------------------");
        double d = user2.calcFee();//расчет налога
        d = Math.round(d * 100) / 100.0;
        System.out.println("Налог 13%: " + d);
        System.out.println("Чистые: " + user2.calcSalary());

        // user2.salary = -36000;
        user2.setSalary(-36000);//использование метода для установки значений
        user2.getInfo();

        //double s = user2.salary;
        double s = user2.getSalary();//использование метода для получения значения поля
    }
}
