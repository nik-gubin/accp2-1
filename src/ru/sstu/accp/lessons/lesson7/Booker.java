package ru.sstu.accp.lessons.lesson7;

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
    
    //реализация абстрактного метода
    @Override
    public void job(){
        System.out.println("Бух Сводит дебет с кредитом");
    }
    
    public void service(){
        System.out.println("Бух сервис");
    }
}
