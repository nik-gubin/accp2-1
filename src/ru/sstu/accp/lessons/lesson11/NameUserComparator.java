package ru.sstu.accp.lessons.lesson11;

import java.util.Comparator;

public class NameUserComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        if (o1.lastName.equals(o2.lastName)) {
            int a = o1.firstName.compareTo(o2.firstName);
            if (a == 0) {
                if (o1.age == o2.age) {
                    return 0;
                } else if (o1.age > o2.age) {
                    return 1;
                } else {
                    return -1;
                }
            }
            return a;
        } else if (o1.lastName.compareTo(o2.lastName) > 0) {
            return 1;
        } else {
            return -1;
        }
    }

}
