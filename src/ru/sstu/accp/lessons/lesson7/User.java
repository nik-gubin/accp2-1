package ru.sstu.accp.lessons.lesson7;


//абстрактный класс - может содержать абстракные методы
public abstract class User extends Object {

    //про мофикаторы доступа
    public String lastName;//public - доступ в любом классе
    protected String firstName;//protected - доступ в пакете и в классе-наследнике
    int age;//по умолчанию - доступ внутри пакета
    double salary;
    private String middleName;//private - доступ внутри класса

    public User() {

    }

    User(String lastName, String firstName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.middleName = "22";
    }

    void getInfo() {
        System.out.println(lastName + " " + firstName + " \n   возраст: "
                + age + "г. \n   з/п: " + salary);
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

//    public void job(){
//        System.out.println("Что-то делает");
//    }
    
    //если реализация метода неизвестна,
    //то метод необходимо сделать абстрактным,
    //тогда реализация ложится на классы-потомки
    public abstract void job();

    public String toString() {
        return lastName + " " + firstName + " \tвозраст: "
                + age + "г. \tз/п: " + salary;
    }

}
