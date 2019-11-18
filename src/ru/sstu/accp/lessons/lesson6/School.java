/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sstu.accp.lessons.lesson6;

public class School {

    String title;
    String address;
    String inn;

    public School(String title, String address, String inn) {
        this.title = title;
        this.address = address;
        this.inn = inn;
    }

    ClassRoom[] rooms;

    Teacher boss;

    void addRoom(ClassRoom classRoom) {
        if (rooms == null) {
            rooms = new ClassRoom[1];
        }
        rooms[0] = classRoom;
    }
}
