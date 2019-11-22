package ru.sstu.accp.lessons.lesson8;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        System.out.println("Строки");
        int a = 1;
        boolean b = false;
        String s1 = "Hello";
        String s3 = "Hello";
        String s2 = new String("Hello");
        String s4 = new String("hELLO");
        System.out.println("s1 == s2 : " + (s1 == s2));//сравнение по ссылке
        System.out.println("s1 == s3 : " + (s1 == s3));//сравнение по ссылке

        System.out.println("s1 equals s2 : " + (s1.equals(s2)));//сравненние по значению
        System.out.println("s1 equals s3 : " + (s1.equals(s3)));//сравненние по значению
        System.out.println("s1 equals s4: " + (s1.equals(s4)));//сравненние по значению
        System.out.println("s1 equalsIgnoreCase s4 : " + (s1.equalsIgnoreCase(s4)));//сравненние по значению игнорирую регистр
        
        //объединение строк
        String s41 = s1 + s2;//любая операция над строками порпождает новую строку

        String s = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            s = s + i;//любая операция над строками порпождает новую строку
        }
        long end = System.currentTimeMillis();
        System.out.println("time: " + (end - start) / 1000.0);

        
        StringBuilder sb = new StringBuilder();//класс для соединения строк
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sb.append(i);//добавление строки в конец
            sb.append(" ");
        }
        end = System.currentTimeMillis();
        System.out.println("time: " + (end - start) / 1000.);

        sb.insert(0, "hello");//вставка строки на позицию
        sb.delete(10, 20);//уделение части строки
        // System.out.println(sb.toString());

        String s7 = s1 + s2 + s3;
        int l = s7.length();//количество символов
        System.out.println("s7 len: " + l);
        char c1 = s7.charAt(0);//получение символа по его номеру
        char c3 = s7.charAt(2);
        System.out.println("c1 & c3 " + c1 + " & " + c3);
        for (int i = 0; i < s7.length(); i++) {
            char c = s7.charAt(i);
            System.out.println(c);
        }

        char[] chars = s7.toCharArray();//получение массива символов из строки
        chars[chars.length - 1] = '!';
        String s8 = new String(chars);//получение строки из массива символов
        System.out.println(s7);
        System.out.println(s8);

        String s10 = "System.out.prin.out.tln.out(\"s7 len: \" + l);";
        System.out.println(s10.startsWith("system"));//проверка на совпадение начала строки
        System.out.println(s10.startsWith("System"));
        System.out.println(s10.endsWith(";"));//проверка на совпадение конца строки
        System.out.println(s10.contains("out"));//проверка на содержание
        System.out.println(s10.indexOf("out"));//поиск с начала
        System.out.println(s10.lastIndexOf("out"));//поиск с конца

        String s11 = s10.substring(7);//извлечение строки с 7 символа
        System.out.println("s10: " + s10);
        System.out.println("s11: " + s11);

        int ind = s10.indexOf("out");
        String s12 = s10.substring(ind + 4, ind + 8);//извлесение строки с 7 до 11 символа
        System.out.println("s12: " + s12);

        String[] strings = s10.split("[\\.\\(\\)\\s]");//разделение строки на массив строк
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
        System.out.println("-----------------------");
        //разделение строки на строки
        StringTokenizer tokenizer = new StringTokenizer(s10, ".()\" :;+");
        while (tokenizer.hasMoreElements()) {
            String nextElement = tokenizer.nextToken();
            System.out.println(nextElement);
        }
        System.out.println("-----------------------");
        System.out.println(s10.toLowerCase());//перевод в нижний регистр
        System.out.println(s10.toUpperCase());//перевод в верхний регистр
        System.out.println("     wefjfiowe23     ");
        System.out.println("     wefjfiowe23     ".trim());//уделние пробелов

        String s13 = "322kjfsjf32423jkl23423k";
        String s14 = s13.replaceAll("[0-9]+", "*");//замена чисел на *
        System.out.println(s14);

        System.out.println("-----------------------");
        String s15="12 jkj kjkl 0 -9 "
                + "31.11.2019 fdsf sd 22.1.2019 or 2.1.2019or 32.1.2019or 32.21.2019";
        //регулярные выражения
//        String reg = "[a-z]";//буква
//        String reg = "[a-z]+";//слово
//        String reg = "\\d+";//число
//        String reg = "\\d{2}\\.\\d{2}.\\d{4}";\\число в формате ХХ.ХХ.ХХХХ
        String reg = "(([12]\\d)|(0?\\d)|30|31)\\.((0?\\d)||1[0-2]).\\d{4}";//дата
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(s15);
        while (m.find()) {
            String g = m.group();
            System.out.println(g);
        }
        
        String s16 = s15.replaceAll(reg, " ");//удалить из стори строку по регулярке
        System.out.println(s16);

    }
}
