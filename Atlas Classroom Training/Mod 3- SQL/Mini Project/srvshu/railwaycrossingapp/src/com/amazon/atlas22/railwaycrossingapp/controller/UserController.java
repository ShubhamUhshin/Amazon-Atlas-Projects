package com.amazon.atlas22.railwaycrossingapp.controller;

import com.amazon.atlas22.railwaycrossingapp.db.DB;
import com.amazon.atlas22.railwaycrossingapp.model.User;

public class UserController {
    //Responsibilities 1.register, 2.login, 3.get number of users.
    private static UserController userController;
    private UserController()
    {

    }
    //using singleton
    public static UserController getInstance(){
        if(userController==null)
        {
            userController= new UserController();
        }
        return userController;
    }
    DB db = DB.getInstance();

    //Method to register users
    public boolean registerUser(User user)
    {
        if(user.validate()) {
            return db.set(user);
        }else {
            System.err.println("Email or password can not be empty!");
        }
        return false;
    }

    //method to log user in

    public boolean userLogin(User user)
    {
        if(user.validate())
        {
            User retrievedUser = (User) db.retrieve(user.getEmail());
            if(retrievedUser!=null && retrievedUser.getUserType()== User.userType.USER){
                user.setName(retrievedUser.getName());
                return retrievedUser.getEmail().equalsIgnoreCase(user.getEmail()) &&
                        retrievedUser.getPassword().equalsIgnoreCase(user.getPassword());
            }

        }
        return false;
    }

    public int getUserCount()
    {
        return db.getUserCount();
    }

}