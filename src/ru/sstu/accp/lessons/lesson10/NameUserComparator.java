package ru.sstu.accp.lessons.lesson10;

import java.util.Comparator;
//правило сортировки пользователей
public class NameUserComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        if (o1.getLastName().equalsIgnoreCase(o2.getLastName())) {
            return 0;
        }
        int c = o1.getLastName().compareToIgnoreCase(o2.getLastName());
        return -c;
    }

}
