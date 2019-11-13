package ru.sstu.accp.lessons.lesson4;

/**
 *
 * 
 */
public class Document {

    String type;
    int number;

    public Document() {
    }

    public Document(String type, int number) {
        this.type = type;
        this.number = number;
    }

    String getInfo() {
        return type + " №" + number;
    }

}
