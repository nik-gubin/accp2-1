package ru.sstu.accp.lessons.lesson4;

/**
 * БД Пользовтелей
 */
public class UserRepository {

    static User[] users;

    /**
     * Заполение массива пользователей, 
     * которые будут созданы во время запуска приложения
     */
    static {
        users = new User[3];
        users[0] = new User("Ivanov", "Ivan", 35, 15000);
        users[1] = new User("Petrov", "Alex", 37, 145000);
        users[2] = new User("Ivanova", "Alexandra", 55, 42000);
    }

    /**
     * Добавление нового пользователя в БД
     * @param user 
     */
    static void addUser(User user) {
        User[] temp = new User[users.length + 1];
        for (int i = 0; i < users.length; i++) {
            temp[i] = users[i];
        }
        users = temp;
        users[users.length-1] = user;
    }

    /**
     * получение пользователя из бд по его номеру
     * @param ind
     * @return 
     */
    static User getByIndex(int ind) {
        return users[ind];
    }

    /**
     * Расчет средней арифметической зарплаты 
     * для всех пользователей, хранящихся в БД
     * @return 
     */
    static double averageSalary() {
        double avg = 0;
        for (int i = 0; i < users.length; i++) {
            avg = avg +users[i].getSalary();
        }
        avg = avg / users.length;
        return avg;
    }

    /**
     * Вывод на экран информации о пользователях, хранящихся в БД
     */
    static void getInfo() {
        System.out.println("---------------------");
        System.out.println("Count items: " + users.length);
        for (int i = 0; i < users.length; i++) {
            User user = users[i];
            System.out.println((i + 1) + ". " + user.getLastName()
                    + " " + user.getFirstName()
                    + " " + user.getSalary());
        }
    }
}
