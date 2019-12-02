package ru.sstu.accp.lessons.lesson12;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
//        System.setOut(new PrintStream("log.txt"));//изменение вывода консоли в файл
//        System.setErr(new PrintStream("err.txt"));
        System.out.println("Ввод/вывод");

        try {
            //байтовый поток
            //чтение побайтово  из файла
            FileInputStream fis = new FileInputStream("test.txt");
            int b;
            while ((b = fis.read()) != -1) {
                System.out.print((char) b);
            }
            fis.close();

            //байтовый поток
            //запись побайтово  в файл
            FileOutputStream fos = new FileOutputStream("test2.txt");
            fos.write('z');
            fos.write('z');
            fos.write('z');
            fos.write('z');
            String s1 = "String s1";
            fos.write(s1.getBytes());
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("---------------------");
        try {
            //символьный поток
            FileReader fr = new FileReader("test.txt");
            BufferedReader br = new BufferedReader(fr);
            String str;
            //чтение построчно из файла
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("---------------------");
        ArrayList<String> arrayList = new ArrayList<>();
        try {
             //символьный поток
            FileReader fr = new FileReader("test.txt");
            BufferedReader br = new BufferedReader(fr);
            String str;
            
            //чтение построчно из файла и сохранение в список
            while ((str = br.readLine()) != null) {
                arrayList.add(str);
            }
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        //сортровка в список
        Collections.sort(arrayList);
        for (String item : arrayList) {
            System.out.println(item);
        }

        try {
            //символьный поток
            FileWriter fw = new FileWriter("test-sort.txt");
            PrintWriter out = new PrintWriter(fw);
            //запись списка строк в файл
            for (String item : arrayList) {
                out.println(item);
            }
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

//        System.in//стандартный поток ввода
//        System.out//стандартный поток вывода
//        System.err//стандартный поток ошибок
        System.err.println("Err!!!!");
        System.out.println("---------------------");
        try {
            //чтение из файла с кодировкой
            FileInputStream fr = new FileInputStream("test4.txt");
            InputStreamReader isr = new InputStreamReader(fr, "cp1251");
            BufferedReader br = new BufferedReader(isr);
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("---------------------");
        try {
            //запись в файла с кодировкой
            FileOutputStream fos = new FileOutputStream("test4-cp1251.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos, "windows-1258");
            PrintWriter out = new PrintWriter(osw);
            out.println("яффывфывыфв");
            out.println("фыыфц");
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        //список кодировок
        for (Map.Entry<String, Charset> entry : Charset.availableCharsets().entrySet()) {
            System.out.println(entry.getKey());
        }

        System.out.println("--------------");
        User u1 = new User("Ivanov", "Ivan", 20, 10000);
        try {
            //сериализация объекта
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("obj.txt"));
            outputStream.writeObject(u1);
            outputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            //десериализация объекта
            ObjectInputStream outputStream = new ObjectInputStream(new FileInputStream("obj.txt"));
            User user = (User) outputStream.readObject();
            outputStream.close();
            System.out.println(user);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
