package ru.vegd.entity;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Objects;
@Component("users")
public class User {

    private long user_id;
    private String login;
    private String hash_password;
    private String user_name;
    private String user_last_name;
    private Timestamp date_of_registration;

    public User(long user_id, String login, String hash_password, String user_name, String user_last_name, Timestamp date_of_registration) {
        this.user_id = user_id;
        this.login = login;
        this.hash_password = hash_password;
        this.user_name = user_name;
        this.user_last_name = user_last_name;
        this.date_of_registration = date_of_registration;
    }

    public User() { }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHash_password() {
        return hash_password;
    }

    public void setHash_password(String hash_password) {
        this.hash_password = hash_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_last_name() {
        return user_last_name;
    }

    public void setUser_last_name(String user_last_name) {
        this.user_last_name = user_last_name;
    }

    public Timestamp getDate_of_registration() {
        return date_of_registration;
    }

    public void setDate_of_registration(Timestamp date_of_registration) {
        this.date_of_registration = date_of_registration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return user_id == user.user_id &&
                Objects.equals(login, user.login) &&
                Objects.equals(hash_password, user.hash_password) &&
                Objects.equals(user_name, user.user_name) &&
                Objects.equals(user_last_name, user.user_last_name) &&
                Objects.equals(date_of_registration, user.date_of_registration);
    }

    @Override
    public int hashCode() {

        return Objects.hash(user_id, login, hash_password, user_name, user_last_name, date_of_registration);
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", login='" + login + '\'' +
                ", hash_password='" + hash_password + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_last_name='" + user_last_name + '\'' +
                ", date_of_registration='" + date_of_registration + '\'' +
                '}';
    }
}
