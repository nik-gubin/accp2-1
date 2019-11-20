package ru.sstu.accp.lessons.lesson7;

public class Main {

    public static void main(String[] args) {
        System.out.println("Полиморфиз и абстрактные классы");
        //  User user = new User();
        //   System.out.println(user);

        Booker booker = new Booker();
        booker.job();

        //User u = new User();
        //u.job();
        Manager manager = new Manager();
        manager.job();

        System.out.println("------------------------");
        User u1 = booker;
        Object o1 = u1;
        u1.job();
        //u1.service();
        booker.service();

        // u1=new Manager();
        if (u1 instanceof Booker) {
            Booker b2 = (Booker) u1;
            b2.service();
        } else {
            System.out.println("НЕ БУХГАЛТЕР");
        }

        User[] users = new User[4];
        users[0] = manager;
        users[1] = booker;
        users[2] = new Manager("Ivanov", "Ivan", 33, 10000, 10);
        users[3] = new Manager("Ivanov", "Petr", 43, 60000, 30);

        double salary = 0;
        for (int i = 0; i < users.length; i++) {
            User user1 = users[i];
            System.out.println(user1);
            user1.job();
            salary += user1.calcSalary() + user1.calcFee();
        }
        System.out.println("total salary: " + salary);

        User u2 = booker;
        fee(users[3]);

        //u.job();
    }

    public static void fee(User u) {
        double f = u.getSalary() * 0.13;
        System.out.println("Fee = " + f);

    }
    /* public static void fee(User u) {
        double f = u.getSalary() * 0.13;
        System.out.println("Fee = " + f);
    }

    public static void fee(Manager u) {
        double f = u.getSalary() * 0.13;
        System.out.println("Fee = " + f);
    }

    public static void fee(Booker u) {
        double f = u.getSalary() * 0.13;
        System.out.println("Fee = " + f);
    }*/
}
