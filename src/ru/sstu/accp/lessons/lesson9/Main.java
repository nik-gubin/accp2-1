package ru.sstu.accp.lessons.lesson9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        try {
            //Добавить для логгера указание на сохранение сообщений в файл
            FileHandler fh = new FileHandler("log.txt");
            Logger.getLogger("app").addHandler(fh);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        //отправка в логгер информациооного сообщения
        Logger.getLogger("app").log(Level.INFO, "Запуск приложения");
        System.out.println("Исключительные ситуации");

        //отправка в логгер информациооного сообщения
        Logger.getLogger("app").log(Level.INFO, "Тестирование исключений");

        //генерация и отлов исключений
        try {
            Integer.valueOf("a");
            int b = 0;
            int a = 5 / b;

            Object o = null;
            o.toString();
            System.out.println("try без ошибок");

        } //каждый catch отлавливает свой вид ошибок
        catch (ArithmeticException e) {//арифметические ошибки
            System.out.println("Делить на ноль нельзя");

            //отправка в логгер предупреждающего сообщения
            Logger.getLogger("app").log(Level.WARNING, "Деление на ноль");

        } catch (NullPointerException e) {//ошибка обращения через пустую ссылку
            System.out.println("Error with null reference");
        } catch (Exception e) {//все отсальные ошибки
            System.out.println("Ошибка " + e.getMessage());
            e.printStackTrace();
            //отправка в логгер критического сообщения
            Logger.getLogger("app").log(Level.SEVERE, "Что-то пошло не так");
            System.exit(1);
        }

        //создание объетка генерирует  
        //обязательную (checked) к обработке ошибку 
        //FileInputStream fis = new FileInputStream("test.txt");
        //обработка checked-исключения
        try {
            FileInputStream fis = new FileInputStream("test.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден");
        }

        //пример error
        //рекурсия
        req();

        //пример с обработкой исключения
        int r = readInt();
        System.out.println("r = " + r);

        testFinnaly();

        try {
            workFile("test.txt");
        } catch (Exception e) {
            System.out.println("Err workFile");
        }
        int age = 131;
        if (age >= 0) {
            try {
                setAge(age);
            } catch (AgeUserException e) {
                age = e.age - 10;
                setAge(age);
            }
        }
    }

    //рекурсия может породить error
    public static void req() {
        req();
    }

    public static int readInt() {
        while (true) {
            try {
                System.out.print("Введите целое число: ");
                Scanner scanner = new Scanner(System.in);
                int b = scanner.nextInt();
                return b;
            } catch (Exception e) {
                System.out.println("Введено не целое цисло");
            }
        }
    }

    //тестирование finnaly
    public static void testFinnaly() {
        System.out.println("----------------");
        try {
            int i = 5 / 0;
            System.out.println("Без ошибок");
        } catch (Exception e) {
            System.out.println("С ошибками");
        } finally {
            //блок finally выполняется абсолютно всегда 
            System.out.println("finally");
        }
    }

    //проброс на верх обработки исключения
    public static void workFile(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
    }

    //генерация исключения
    public static void setAge(int age) {
        if (age < 0) {
            //генерация стандартного исключения
            throw new IllegalArgumentException("age is negave");
        } else if (age > 130) {
            //генерация собственного исключения
            throw new AgeUserException("age is very big", age);
        } else {
            age = age;
        }
    }
}
