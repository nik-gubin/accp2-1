package ru.sstu.accp.lessons.lesson4;

public class Main {

    public static void main(String[] args) {
        System.out.println("");
        System.out.println("countUser = " + User.countUser);//обращение к статическому полю идет через имя класса
        User ivan = new User("Ivanov", "Ivan", 18, 10000);
        System.out.println("countUser = " + User.countUser);//обращение к статическому полю идет через имя класса
        User a = new User("Sidorova", "Masha", 40, 10001);
        System.out.println("countUser = " + User.countUser);//обращение к статическому полю идет через имя класса

        System.out.println("---------------------");
        System.out.println("countUser = " + User.countUser);//обращение к статическому полю идет через имя класса
        ivan.countUser = 10;//измение значения у статического поля
        //User.USER_FEMALE = "ggg";//изменить константу нельзя
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);//стандартная константа
        System.out.println("---------------------");

        System.out.println("---------------------");
        a.getInfo();

        //про передачу параметров в метод
        System.out.println("---------------------");
        int b = 5;
        System.out.println("b = " + b);
        ivan.methodA(b);
        System.out.println("b = " + b);

        //про передачу параметров в метод
        System.out.println("---------------------");
        ClassB b1 = new ClassB();
        b1.value = 5;
        System.out.println("b1.value = " + b1.value);
        ivan.methodB(b1);
        System.out.println("b1.value = " + b1.value);

        UserRepository.getInfo();//обращение к статическому методу идет через имя класса
        System.out.println("Avg salary = " + UserRepository.averageSalary());//обращение к статическому методу идет через имя класса

        UserRepository.addUser(ivan);//обращение к статическому методу идет через имя класса
        UserRepository.getInfo();//обращение к статическому методу идет через имя класса
        System.out.println("Avg salary = " + UserRepository.averageSalary());

        System.out.println("---------------------");
        a.getInfo();
        System.out.println("---------------------");

        //Создание документов
        Document d1 = new Document("Паспорт", 123124);
        Document d2 = new Document("Загран аспорт", 123);
        Document d3 = new Document("СНИЛС", 948546);

        //прикрепление документа для пользователя
        a.addDocument(d1);
        a.addDocument(d3);

        //прикрепление документа для пользователя
        ivan.addDocument(d2);

        ivan.getInfo();
        a.getInfo();

        ivan.gender = User.USER_MALE;
        a.gender = User.USER_FEMALE;

    }
}
