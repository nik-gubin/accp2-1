package ru.sstu.accp.lessons.lesson9;


public class AgeUserException extends RuntimeException {
    int age;

    public AgeUserException(String messge, int age) {
        super(messge);
        this.age = age;
    }

}
