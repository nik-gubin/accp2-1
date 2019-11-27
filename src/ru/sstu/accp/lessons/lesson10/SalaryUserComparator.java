package ru.sstu.accp.lessons.lesson10;

import java.util.Comparator;

//правило сортировки пользователей
public class SalaryUserComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        if (o1.getSalary() == o2.getSalary()) {
            return 0;
        } else if (o1.getSalary() > o2.getSalary()) {
            return 1;
        } else {
            return -1;
        }
    }

}
