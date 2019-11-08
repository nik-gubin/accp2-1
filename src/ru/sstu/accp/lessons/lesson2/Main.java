package ru.sstu.accp.lessons.lesson2;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Условия, циклы и массивы");
        int year = 2000;
        int s = year / 100;
        if (year % 100 > 0) {
            s++;
        }
        System.out.println(s);
        //конструкция ветвления
        /*if (булево значение) {
            //верное значение
        } else {
           //ложное значение
        }  */
        
        //пример на определения знака числа
        int a = 0;
        if (a > 0) {
            System.out.println("positive");
        } else {
            System.out.println("zero or negativ");
        }

        //пример на определение знака числа и нуля
        if (a > 0) {
            System.out.println("positive");
        } else if (a == 0) {
            System.out.println("zero");
        } else {
            System.out.println("negative");
        }

        //пример на и/или
        a = 6;
        if (a == 1 || a == 3) {//или
            System.out.println("OR ||");//выполняется если хотя бы один из операндов в значении истина
        }
        if (a > 4 && a < 10) {//и
            System.out.println("AND &&");//выполняется елси все операнды в значение истина
        }

        //частный случай if 
        //если известны все возможные значения переменной n
        int n = 8;
        switch (n) {
            case 1:
                System.out.println("Пн");
                break;
            case 2:
                System.out.println("Вт");
                break;
            case 3:
                System.out.println("Ср");
                break;
            default:
                System.out.println("Not found");
                break;
        }

        int t = 1;
        if (t > 0) {
            t = 9;
        } else {
            t = -9;
        }

        t = a > 0 && t == 0 ? 9 : -9;//тернарный оператор

        //цикл со счетчиком от 0 до 10
        for (int i = 0; i < 50; i++) {
            System.out.print("a");
        }
        System.out.println();
        
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                System.out.print("a");
            } else {
                System.out.print("A");
            }
        }
        System.out.println();

        //вывод кватратов числел от 0 до 10
        for (int i = 0; i < 10; i++) {
            System.out.print(i * i + " ");
        }
        System.out.println();

        //вывод кубов от -9 до 5
        for (int i = -9; i < 5; i++) {
            System.out.print(i * i * i + " ");
        }
        System.out.println();

        //цикл от 100 до 0
        for (int i = 100; i > 0; i--) {
            System.out.print(i + " ");
        }
        System.out.println();

        //цикл с условием
        n = 10;
        while (n > 0) {
            System.out.print(n + " ");
            n--;
        }

        while (true) {
            System.out.println("while - true");
            if (Math.random() < 0.1) {
                break;//завершение работы цикла
            }
        }

        //частный случай цикла while 
        //тело цикла выполнится как минимум один раз
        do {
            System.out.print("do ");
            if (Math.random() < 0.9) {
                break;
            }
        } while (true);

        int[] arr;//объявление массива
        arr = new int[10];//инициализация массива на 10 элементов
        int[] arr2 = new int[5];//объявление массива на 5 элементов
        int[] arr3 = {1, 2, 3, 13, 1};//объявление массива и запалнение
        char[] cs = {'2', 's', 'w'};
        String[] strs = {"Hello", "apple", "house"};
        System.out.println();
        System.out.println("arr - " + arr.length);//длина массива (количество элементов)
        System.out.println("arr3 - " + arr3.length);

        strs[0] = "Other string";//изменение нулевого элемента массива
        
        //заполение массива числами от 0 до 10
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        
//Заполнение массива с клавиатуры        
//        Scanner sc = new Scanner(System.in);
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = sc.nextInt();
//        }

        //заполнение случайными числами
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10) - 5;
        }

        //вывод на экран элементов массива
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        //нахождение суммы значений элементов массива
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        System.out.println("sum array = " + sum);

        
        //поиск минимального элемента
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("min value array = " + min);

        //поиск элемента по значения
        //посчет количества найденных элементов
        int f = 3;
        boolean b = false;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (f == arr[i]) {
                b = true;
                count++;
            }
        }
        if (b == true) {
            System.out.println("3 found items " + count);
        } else {
            System.out.println("3 not found");
        }
    }
}
