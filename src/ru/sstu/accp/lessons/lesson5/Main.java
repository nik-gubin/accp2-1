package ru.sstu.accp.lessons.lesson5;

public class Main {

    public static void main(String[] args) {
        System.out.println("Наследование");
        User u = new User();
        User u1 = new User("Ivanov", "Ivan", 33, 33333);

        u.getInfo();
        u1.getInfo();

        System.out.println("----------------------------");
        Manager manager = new Manager();
        manager.getInfo();
        Manager manager1 = new Manager("Pupkin", "Vasiliy", 21, 10000, 10);
        manager1.getInfo();

        // u.bonus = 4;
        manager.bonus = 5;
        double s = manager1.calcSalary();
        System.out.println("salary = " + s);
        double fee = manager1.calcFee();
        System.out.println("fee = " + fee);
        
        
        System.out.println("----------------------------");
        System.out.println(u.toString());
        System.out.println(u1.toString());
        System.out.println(manager.toString());
        System.out.println(manager1.toString());

    }

}
