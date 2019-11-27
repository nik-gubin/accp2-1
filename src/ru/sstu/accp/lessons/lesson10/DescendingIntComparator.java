package ru.sstu.accp.lessons.lesson10;

import java.util.Comparator;
//правило сортировки чисел
public class DescendingIntComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1 > o2) {
            return -1;
        } else {
            return 1;
        }
    }

}
