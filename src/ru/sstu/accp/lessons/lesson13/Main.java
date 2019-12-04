/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sstu.accp.lessons.lesson13;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Губин_Н
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Файлы/Трехслойка");

        File file = new File("test.txt");
        if (file.exists()) {//проверка на существование
            System.out.println("File exists");

            boolean b = file.delete();//удаление файла
            if (b) {
                System.out.println("File delete");
            }

        } else {
            System.out.println("File not exists");

            try {
                boolean b = file.createNewFile();//создание файла
                if (b) {
                    System.out.println("File create");
                }
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        File f = new File("test2.txt");
        System.out.println(f.getName());//имя файла
        System.out.println(f.getAbsolutePath());//полное имя файла
        System.out.println(f.getParentFile());//родительская папка
        System.out.println(new Date(f.lastModified()));//время последней модификации
        System.out.println(f.getTotalSpace());//размер диска
        System.out.println(f.getFreeSpace());//свободное местно на диске
        System.out.println(f.getUsableSpace());//занятое место на диске

        File dir = new File("folder");
        dir.mkdir();//создать директорию

        File dir2 = new File("folder2/f/f3");
        dir2.mkdirs();//создать вложенную диеркторию

        System.out.println(dir2.getAbsolutePath());

        for (int i = 0; i < 10; i++) {

            File f3 = new File(dir2.getAbsolutePath() + "/f" + i + ".txt");
            try {
                f3.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        

        //dir.delete();//удалить директорию
        //dir2.delete();
        File[] files = dir2.listFiles();//массив вложенных файлов и директорий
        for (int i = 0; i < files.length; i++) {
            files[i].delete();
        }
        dir2.delete();
        dir2.getParentFile().delete();
        dir2.getParentFile().getParentFile().delete();

        System.out.println("-------------");
        File dir3 = new File("src/ru/sstu/accp/lessons");
        File[] files2 = dir3.listFiles();
        for (int i = 0; i < files2.length; i++) {
            if (files2[i].isFile()) {//проверка на тип (файл или директория)
                System.out.print("f ");
            } else {
                System.out.print("d ");
            }
            System.out.println(files2[i].getName());

            if (!files2[i].isFile()) {
                File[] files3 = files2[i].listFiles();
                for (int j = 0; j < files3.length; j++) {
                    if (files3[j].isFile()) {
                        System.out.print("  f ");
                    } else {
                        System.out.print("  d ");
                    }
                    System.out.println(files3[j].getName());
                }
            }
        }

        File f5 = new File("test5.txt");
        // f5.renameTo(new File("test5.txt"));
        f5.renameTo(new File("folder/test5.txt"));

        //описание пути
        Path p1 = Paths.get("test2.txt");
        Path p2 = Paths.get("test", "test2", "test3", "test2.txt");
        System.out.println(p1);
        System.out.println(p2);

        Path p3 = Paths.get("C:\\Documents and Settings\\Губин_Н\\Мои документы\\NetBeansProjects\\accp2-1\\src\\ru\\sstu\\accp\\lessons\\lesson13", "test2.txt");
        System.out.println("-----------------");
        for (Path p : p3) {
            System.out.println(p);
        }
        System.out.println(p1 + ": " + Files.exists(p1));

        Path p4 = Paths.get("file3.ttt");
        //класс  Files - направлен для удобного работы с директориями
        try {
            if (!Files.exists(p4)) {
                Files.createFile(p4);
            } else {
                Files.delete(p4);
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        Path p5 = Paths.get("./");
        try {
            Files.walkFileTree(p5, new MyVisitor());//поиск файлов в папке сопределенным расширением
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
