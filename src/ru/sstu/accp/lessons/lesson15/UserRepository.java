package ru.sstu.accp.lessons.lesson15;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserRepository {

    Connection connection;//объект подключения к бд

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    /**
     * Добавление новового пользователя
     *
     * @param user
     */
    public void add(User user) {
        try {
            //если в запросе есть параметры использовать PreparedStatement
            PreparedStatement st
                    = connection.prepareStatement(
                            "insert into user (lastname, firstname, age, salary)  "
                            + "values (?,?,?,?)");
            st.setString(1, user.getLastName());//установка параметра
            st.setString(2, user.getFirstName());//установка параметра
            st.setInt(3, user.getAge());//установка параметра
            st.setDouble(4, user.getSalary());//установка параметра
            st.execute();//для не select-запроса используем execute

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Удаление пользователя по id
     *
     * @param id
     */
    public void delete(int id) {
        try {
            //если в запросе есть параметры использовать PreparedStatement
            PreparedStatement st
                    = connection.prepareStatement(
                            "delete from user where id=?");
            st.setInt(1, id);//установка параметра
            st.execute();//для не select-запроса используем execute

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Обновление данных пользователя
     *
     * @param user
     */
    public void update(User user) {
        try {
            //если в запросе есть параметры использовать PreparedStatement
            PreparedStatement st
                    = connection.prepareStatement(
                            "update user set lastname=?, firstname=?, age=?, salary=?   "
                            + " where id=?");
            st.setString(1, user.getLastName());//установка параметра
            st.setString(2, user.getFirstName());//установка параметра
            st.setInt(3, user.getAge());//установка параметра
            st.setDouble(4, user.getSalary());//установка параметра
            st.setInt(5, user.getId());//установка параметра
            st.execute();//для не select-запроса используем execute

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Получение пользователя по id
     *
     * @param id
     * @return
     */
    public User getById(int id) {
        try {
            //если в запросе есть параметры использовать PreparedStatement
            PreparedStatement st
                    = connection.prepareStatement(
                            "select id,lastname,firstname,age,salary "
                            + "from user where id = ?");
            st.setInt(1, id);//установка параметра
            ResultSet rs = st.executeQuery();//для select-запроса используем executeQuery 

            if (rs.next()) {
                int id1 = rs.getInt(1);
                String l = rs.getString(2);
                String f = rs.getString("firstname");
                int age = rs.getInt(4);
                double s = rs.getDouble(5);
                User user = new User(id1, l, f, age, s);
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Получения списка всех пользователей
     *
     * @return
     */
    public ArrayList<User> getAll() {
        try {
            //если в запросе нет параметров использовать Statement
            Statement st = connection.createStatement();
            ResultSet rs
                    = st.executeQuery("select id,lastname,firstname,age,salary from user");//для select-запроса используем executeQuery
            ArrayList<User> users = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                String l = rs.getString(2);
                String f = rs.getString("firstname");
                int age = rs.getInt(4);
                double s = rs.getDouble(5);
                User user = new User(id, l, f, age, s);
                users.add(user);
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
