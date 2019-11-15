package ru.sstu.accp.lessons.lesson5;

//Класс Бухгалтер
//Наследник класса Пользователь (дочерний)
public class Booker extends User {

    Booker() {
    }

    Booker(String lastName, String firstName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }
}
