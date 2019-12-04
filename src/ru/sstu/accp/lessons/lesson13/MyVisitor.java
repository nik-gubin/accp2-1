/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sstu.accp.lessons.lesson13;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

//класс для перебора всех вложенных файлов и папок
public class MyVisitor implements FileVisitor<Path> {

    String extension="txt";

    //открытие папки
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
       // System.out.println(dir);
        return FileVisitResult.CONTINUE;
    }

    //просмотр файла
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toString().endsWith(extension)) {
            System.out.println(file);
            //System.out.println(attrs);
        }

        return FileVisitResult.CONTINUE;
    }

    //при ошибке просмотра файла
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    //закрытие папки
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

}
