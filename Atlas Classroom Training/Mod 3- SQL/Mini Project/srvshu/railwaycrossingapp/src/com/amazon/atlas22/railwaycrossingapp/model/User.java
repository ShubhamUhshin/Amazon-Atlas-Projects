package com.amazon.atlas22.railwaycrossingapp.model;

import java.io.Serializable;

public class User implements Serializable {
   public enum userType{
        USER,
        ADMIN,
        INCHARGE
    }
    String name;
    String email;
    String password;
    userType userType; // 1 for End user 2 for Admin 3 In charge

    public User() {
        name="";
        email="";
        password="";
        userType= userType.USER;
    }

    public User(String name, String email, String password, userType userType) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public  userType convertUserType(String usertype){
        if(usertype.equals("USER")) {
            return userType.USER;
        }
        else if (usertype.equals("ADMIN")) {
            return userType.ADMIN;
        }else {
            return userType.INCHARGE;
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public userType getUserType() {
        return userType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(userType userType) {
        this.userType = userType;
    }

    public boolean validate(){
        return !email.isEmpty() && !password.isEmpty();
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }
}

