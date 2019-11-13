package ru.sstu.accp.lessons.lesson4;

public class User {

    String lastName;
    String firstName;
    int age;
    double salary = -1;
    String gender;
    Document[] documents = new Document[0];

    /**
     * Статические переменные (общие для всего класса в целом)
     */
    static int countUser;
    static final String USER_MALE = "Male";//константа
    static final String USER_FEMALE = "Female";//константа

    User() {
        
    }

    User(String lastName, String firstName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        countUser = countUser + 1;
    }

    void getInfo() {
        System.out.println(lastName + " " + firstName + " \n   возраст: "
                + age + "г. \n   з/п: " + salary);
        if (documents.length == 0) {
            System.out.println("   Документы отсутствуют");
        } else {
            System.out.println("   Документы:");
            for (int i = 0; i < documents.length; i++) {
                Document document = documents[i];
                System.out.println("      "+(i + 1) + ". " + document.getInfo());
            }
        }
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

    //передача аргумента по значению(для примитивов это копия числа)
    public void methodA(int a) {
        a = 10;
    }
    
    //передача аргумента по значению(для примитивов это копия ссылки на объект)
    public void methodB(ClassB data) {
        data.value = 10;
    }

    //метод, который принимает документ 
    //и добавляет его в массив документов пользователя
    void addDocument(Document d) {
        Document[] temp = new Document[documents.length + 1];
        for (int i = 0; i < documents.length; i++) {
            temp[i] = documents[i];
        }
        documents = temp;
        documents[documents.length - 1] = d;
    }
}
