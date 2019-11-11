package ru.sstu.accp.lessons.lesson3;

//класс для описания характеристик и поведения пользователей
public class User {
    
    ////////////////////////////////////
    ///////////////Поля/////////////////
    ////////////////////////////////////
    /**
     * Фамилия
     */
    String lastName;
    /**
     * имя
     */
    String firstName;
    /**
     * возраст
     */
    int age;
    /**
     * Зарплата
     */
    double salary = -1;
    
    ////////////////////////////////////
    ///////////Конструкторы/////////////
    ////////////////////////////////////
    /**
     * Конструктор по умолчанию
     */
    User() {        
        age = 18;
    }
    
    /**
     * Конструтор устанавливающий фамилию и имя
     * @param lastName Фамилия 
     * @param firstName Имя
     */
    User(String lastName, String firstName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Конструктор для создания пользователя, со всеми параметрами
     *
     * @param lastName фамиля
     * @param firstName имя
     * @param age возраст
     * @param salary зп
     */
    User(String lastName, String firstName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }
    
    /**
     * Конструктор устанавливающий 3 поля
     * @param lastName
     * @param firstName
     * @param age 
     */
    User(String lastName, String firstName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    
    /**
     * Конструктор устанавливающий фамилию и возраст
     * @param last
     * @param age 
     */
    User(String last, int age) {
        this.age = age;
        this.lastName = last;
    }
    
    
    ////////////////////////////////////
    //////////////Методы/**/////////////
    ////////////////////////////////////
    
    /**
     * Выводит информацио о пользователе в консоль
     */
    void getInfo() {
        System.out.println(lastName + " " + firstName + " \n\tвозраст: "
                + age + "г. \n\tз/п: " + salary);
    }
    
    /**
     * Увеличение з/п на процент
     * @param per Значение на которое увеличится з/п
     */
    void addSalary(double per) {
        salary = salary + salary * per / 100;
    }
    
    /**
     * Расчет НДФЛ
     * @return Значение рассичанного НДФЛ
     */
    double calcFee() {
        double n = salary * 13.0 / 100;
        return n;
    }
    
    /**
     * Расчет чистой з/п
     * @return Значение расчитанное з/п
     */
    double calcSalary() {
        double n = salary - calcFee();
        n = Math.round(n * 100) / 100.0;
        return n;
    }
    
    /**
     * Установка возраста
     * @param age 
     */
    public void setAge(int age) {
        this.age = age;
    }
    
    /**
     * Установка имени
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * Установка фамилии
     * @param lastName 
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * Установка з/п
     * @param salary 
     */
    public void setSalary(double salary) {
        if (salary >= 0) {            
            this.salary = salary;
        }else{
            System.out.println("Отрицательна з/п");
        }
    }

    /**
     * получение возраста
     * @return 
     */
    public int getAge() {
        return age;
    }

    /**
     * Полученике имени
     * @return 
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Получение фамилии
     * @return 
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Получение з/п
     * @return 
     */
    public double getSalary() {
        return salary;
    }
}
