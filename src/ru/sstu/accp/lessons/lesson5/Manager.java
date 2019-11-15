package ru.sstu.accp.lessons.lesson5;

//Класс Менаджер
//Наследник класса Пользователь (дочерний)
public class Manager extends User {

    double bonus;//поле Менаджера

    public Manager() {
    }

    public Manager(String lastName, String firstName,
            int age, double salary, double bonus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    //переопределение метода базового класса 
    //елси необходимо заменить реализацию метода базового класса
    double calcFee() {
        double n = salary * 13.0 / 100;
        n = n + salary * bonus / 100 * 13.0 / 100;
        return n;
    }
    
    //переопределение метода базового класса 
    //елси необходимо заменить реализацию метода базового класса
    double calcSalary() {
        double n = salary - calcFee() + salary * bonus / 100;
        n = Math.round(n * 100) / 100.0;
        return n;
    }    
    
     //переопределение метода базового класса 
    //елси необходимо заменить реализацию метода базового класса
    public String toString() {
        return lastName + " " + firstName + " \tвозраст: "
                + age + "г. \tз/п: " + salary
                + " \tbonus: " + bonus + "%";
    }

}
