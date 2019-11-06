package ru.sstu.accp.lessons.lesson1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!!!");//вывод на экран с переходом на новую строку
        System.out.print("Hi, C#!!!");//вывод на экран строки без перехода на новую
        System.out.println("\tHello, \n Java!!!");//вывод на экран с переходом на новую строку

        //целочисленные переменные
        int a = 123;
        byte b = 15;
        short c = 15;
        long d = 465;

        //вещественные переменные
        float f = 15.5f;
        double g = 15.23;

        //символьная переменная
        char c1 = '2';

        //логическая переменная
        boolean b1 = true;
        boolean b2 = false;

        int count;//объявление переменных
        count = 15;//инициализация переменных (первое присвоение)
        int apple = 5;//объявление и инициализация

        //вывод на экран значений переменных
        System.out.println("Количество яблок " + apple);
        System.out.println("Float " + f + " Double " + g);
        System.out.println("b1 = " + b1);

        Scanner sc = new Scanner(System.in);//для чтения с клавиатуры
        String name;
        System.out.println("Введите ваше имя: ");
        name = sc.nextLine();//чтение строки
        System.out.println("Введите ваше возраст: ");
        int age = sc.nextInt();//чтение целого числа

        System.out.println("Hi, " + name + "!!!!Age " + age);

        //+,-,*,/,%
        int a1 = 8 + age;
        double a2 = 5.0 / 2;
        System.out.println(a2);

//        System.out.println(5/0);
        System.out.println(5 / 0.0);

        System.out.println(8 % 2);

        //>, <, >=, <=, ==, !=
        boolean b4 = 5 > 3;
        boolean b5 = 5 == 3;
        System.out.println("b4 = " + b4);
        System.out.println("b5 = " + b5);
        boolean b6 = false == false;
        System.out.println("b6 = " + b6);

        //&&, ||
        //++,--
        int x = 7;
        x++;
        ++x;
        x--;
        --x;
        x = 10;
        int y = x++;
        System.out.println("x = " + x + "; y  = " + y);

        x = 10;
        y = ++x;
        System.out.println("x = " + x + "; y  = " + y);

        //=,+=,-= ...
        int n = a + x;
        n += 5;
        n = n + 5;

        int i = 10;
        float f1 = i;

        float f2 = 5.5F;
        int i2 = (int) f2;

        double s = Math.sqrt(81);
        double p = Math.pow(2, 10);
        double fa = Math.abs(-10);

        System.out.println(Math.toDegrees(Math.PI));
        System.out.println(Math.toDegrees(Math.PI / 4));

        double d1 = 15 / 7.0;
        System.out.println(d1);
        double d2 = Math.round(d1 * 1000) / 1000.0;
        double d3 = Math.ceil(d1 * 1000) / 1000.0;
        double d4 = Math.floor(d1 * 1000) / 1000.0;

        System.out.println("round = " + d2);
        System.out.println("ceil = " + d3);
        System.out.println("floor = " + d4);
    }

}
