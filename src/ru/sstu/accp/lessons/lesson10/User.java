package ru.sstu.accp.lessons.lesson10;

public class User extends Object {

    String lastName;
    String firstName;
    int age;
    double salary;

    User() {

    }

    User(String lastName, String firstName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }
   

    void addSalary(double per) {
        salary = salary + salary * per / 100;
    }

    double calcFee() {
        double n = salary * 13.0 / 100;
        return n;
    }

    double calcSalary() {
        double n = salary - calcFee();
        n = Math.round(n * 100) / 100.0;
        return n;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Отрицательна з/п");
        }
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

 
    public String toString() {
        return lastName + " " + firstName + " \tвозраст: "
                + age + "г. \tз/п: " + salary;
    }

}
