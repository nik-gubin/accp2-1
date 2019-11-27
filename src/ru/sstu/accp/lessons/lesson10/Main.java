package ru.sstu.accp.lessons.lesson10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Коллекции");

        //списки на массивах
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);//добавить элемент в конец
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(10);
        list.add(-10);
        list.add(-10);
        list.add(-10);

        int s = list.size();//размер списка
        System.out.println("size: " + s);

        list.set(0, -1);//заменить 0 элемент на -1

        printIntArray(list);

        list.add(33);
        list.add(44);

        printIntArray(list);

        list.add(0, 99);//добавить перед 0 элементом 99
        list.add(2, -99);//добавить перед 2 элементом -99

        printIntArray(list);

        list.remove(3);//удалить третий элемент

        printIntArray(list);

        list.remove(new Integer(-10));//удалить -10 из списка

        while (list.contains(-10)) {//проверка на нахождение -10 в списке
            list.remove(new Integer(-10));
        }
        printIntArray(list);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("aaa");
        strings.add("bbb");

        strings.remove("aaa");
        strings.remove(0);
        for (int i = 0; i < strings.size(); i++) {
            System.out.print(strings.get(i) + ", ");
        }
        System.out.println("\n-------------------------");

        ArrayList<User> users = new ArrayList<>();

        User u1 = new User("Petrov", "Petr", 30, 15000);
        users.add(u1);

        User a = new User("Sidorova", "Masha", 40, 10001);
        users.add(a);

        users.add(new User("Sidorov", "Sidr", 20, 20000));
        users.add(new User("Ivanov", "Ivan", 20, 10000));
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            System.out.println(u);
        }
        double sum = 0;
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            sum += u.getSalary();
        }
        System.out.println("\t\t\t\tСумма: " + sum);

        ArrayList<User> lowSalary = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            if (u.getSalary() <= 15000) {
                lowSalary.add(u);
            }
        }

        System.out.println("---------------------\n\nUsers with low saraly");
        for (int i = 0; i < lowSalary.size(); i++) {
            User u = lowSalary.get(i);
            System.out.println(u);
            u.addSalary(5);
        }
        System.out.println("---------------------");
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            System.out.println(u);
        }

        //двунаправленный связный список
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.addFirst(4);
        integers.addLast(5);
        integers.addAll(list);

        System.out.println("----------------");
        for (int i = 0; i < integers.size(); i++) {
            System.out.print(integers.get(i) + " ");
        }
        System.out.println("");

        Collections.sort(integers, new DescendingIntComparator());//сортировка списка

        System.out.println("----------------");
        for (int i = 0; i < integers.size(); i++) {
            System.out.print(integers.get(i) + " ");
        }
        System.out.println("");

        System.out.println("---------------------");
//        Collections.sort(users,new NameUserComparator());//сортировка списка
//        Collections.sort(users,new SalaryUserComparator());//сортировка списка
        Collections.sort(users, new AgeUserComparator());//сортировка списка
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            System.out.println(u);
        }

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("ab-13");
        list1.add("ab-2");
        list1.add("ab-1");
        list1.add("t");
        list1.add("f");
        list1.add("j");
        list1.add("t");
        Collections.sort(list1);//сортировка списка
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
    }

    private static void printIntArray(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int e = list.get(i);
            System.out.print(e + " ");
        }
        System.out.println("");
    }
}
