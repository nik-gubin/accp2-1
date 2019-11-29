package ru.sstu.accp.lessons.lesson11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        System.out.println("Коллекции ч. 2");

        //множество (поддерживает уникальность элементов)
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(4);//добавить элемент
        hashSet.add(1);//добавить элемент
        hashSet.add(-2);//добавить элемент
        hashSet.add(3);//добавить элемент
        hashSet.add(1);//добавить элемент
        hashSet.add(1);//добавить элемент

        System.out.println("Size set :" + hashSet.size());//размер множества

        //перебор элементов множества
        for (Integer item : hashSet) {
            System.out.println(item);
        }

        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("String");
        hashSet1.add("hashSet1");
        hashSet1.add("HashSet");
        hashSet1.add("new");
        hashSet1.add("add");
        hashSet1.add("HashSet");
        hashSet1.add("item");

        System.out.println("-----------------------");
        for (String item : hashSet1) {
            System.out.println(item);
        }

        HashSet<User> users = new HashSet<>();

        User u1 = new User("Petrov", "Petr", 30, 15000);
        users.add(u1);
        users.add(u1);

        User a = new User("Sidorova", "Masha", 40, 10001);
        users.add(a);

        users.add(new User("Sidorova", "Marina", 40, 10001));

        users.add(new User("Sidorov", "Sidr", 20, 20000));

        User u2 = new User("Ivanov", "Ivan", 20, 10000);
        User u3 = new User("Ivanov", "Ivan", 30, 10000);
        users.add(u2);
        users.add(u3);

        System.out.println("-----------------------");
        for (User item : users) {
            System.out.println(item);
        }

        boolean b1 = users.contains(new User("Ivanov", "Ivan", 30, 10000));//проверка элемента на содержание
        boolean b2 = users.contains(new User("Ivanov", "Vasya", 30, 10000));
        System.out.println("user 1 contains: " + b1);
        System.out.println("user 2 contains: " + b2);

        users.remove(new User("Ivanov", "Ivan", 30, 10000));//удаление элемента из множества
        System.out.println("-----------------------");
        for (User item : users) {
            System.out.println(item);
        }

        System.out.println("-----------------------");
        HashSet<String> setA = new HashSet<>();
        setA.add("A");
        setA.add("B");
        setA.add("C");
        HashSet<String> setB = new HashSet<>();
        setB.add("B");
        setB.add("C");
        setB.add("D");

        //объединение множеств (setA+setB)
        HashSet<String> setC = new HashSet<>();
        setC.addAll(setA);
        setC.addAll(setB);

        for (String item : setC) {
            System.out.println(item);
        }

        //пересечение множества (setA V setB)
        setC = new HashSet<>();
        setC.addAll(setA);
        setC.retainAll(setB);

        System.out.println("-----------------------");
        for (String item : setC) {
            System.out.println(item);
        }

        //вычиатние множеств (setA-setB)
        setC = new HashSet<>();
        setC.addAll(setA);
        setC.removeAll(setB);
        System.out.println("-----------------------");
        for (String item : setC) {
            System.out.println(item);
        }

        TreeSet<Integer> integers = new TreeSet<>();
        integers.add(4);
        integers.add(1);
        integers.add(-2);
        integers.add(3);
        integers.add(1);
        integers.add(1);

        System.out.println("-----------------------");
        for (Object item : integers) {
            System.out.println(item);
        }

        System.out.println("-----------------------");
        for (Object item : users) {
            System.out.println(item);
        }

        //упорядоченное множество
        TreeSet<User> usersTree = new TreeSet<>(new NameUserComparator());
        usersTree.addAll(users);
        System.out.println("-----------------------");
        for (Object item : usersTree) {
            System.out.println(item);
        }

        int count0 = integers.floor(0);//элемент ближайший к 0
        System.out.println("elem floor 5:" + count0);

        System.out.println("-----------------------");

        //карта
        //хранит пары (ключ-значение)
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(-10, "Ivan");//поместить элемент в карту
        hashMap.put(2, "Masha");
        hashMap.put(3, "Vasya");
        hashMap.put(4, "Fedya");
        if (hashMap.containsKey(1)) {//проверка на сожержание ключа
            hashMap.remove(1);//удаление по ключу
            System.out.println("remove");
        } else {
            hashMap.put(1, "Alex");
            System.out.println("put");
        }

        //перебор элементов карты
        for (Map.Entry<Integer, String> item : hashMap.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }

        //упорядоченное по ключу карта
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.putAll(hashMap);

        System.out.println("-----------------------");
        for (Map.Entry<Integer, String> item : treeMap.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }
        
        TreeMap<User,String> treeMap1 = new TreeMap<>(new NameUserComparator());

    }
}
