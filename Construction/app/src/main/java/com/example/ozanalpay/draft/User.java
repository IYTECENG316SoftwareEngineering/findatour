package com.example.ozanalpay.draft;

/**
 * Created by OzanAlpay on 11.5.2015.
 */
public abstract class User {


    public enum USER_TYPE {
        TOURIST, TOUR_GUIDE, MODERATOR, ADMIN

    }

    private int user_id;
    private String username;
    private String password;
    private String e_mail;
    USER_TYPE user_type;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", e_mail='" + e_mail + '\'' +
                ", user_type=" + user_type +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    protected User(int user_id, String username, String password, String e_mail, USER_TYPE user_type) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.e_mail = e_mail;
        this.user_type = user_type;
    }
}
