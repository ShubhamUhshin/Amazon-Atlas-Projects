package com.amazon.atlas22.railwaycrossingapp.db;

import com.amazon.atlas22.railwaycrossingapp.model.RailwayCrossing;
import com.amazon.atlas22.railwaycrossingapp.model.User;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

public class DB implements DAO{
    private String path1 ="C:/Amazon/Atlas/Mod 2- Java and DSA/Mini Project/USER_DATA";
    private String path2 ="C:/Amazon/Atlas/Mod 2- Java and DSA/Mini Project/Railway_DATA";
    private LinkedHashMap<String,User> users = new LinkedHashMap<>();
    private LinkedHashMap<String, RailwayCrossing> crossings = new LinkedHashMap<>();

    private static DB db;
    private DB(){
        populateAdminUser();
    }
    //Singleton design pattern
    public  static DB getInstance(){
        if(db==null){
             db= new DB();
        }

        return db;

    }

    void populateAdminUser() {
        set( new User("Shubham", "srvshu@amazon.com", "ShubhamAtlas123", 2));

    }

    //performs both inset and update
    public boolean set(Object object){
        if(object instanceof User)
        {
            User user = (User) object;
            users.put(user.getEmail(),user);
        }else{
            RailwayCrossing crossing =(RailwayCrossing) object;
            crossings.put(crossing.getPersonInCharge().getEmail(),crossing);
        }
        exportData();
        return true;
    }

    public boolean delete(Object object){
        if(object instanceof User)
        {
            User user = (User) object;
            users.remove(user.getEmail());
        }else{
            RailwayCrossing crossing =(RailwayCrossing) object;
            crossings.remove(crossing.getPersonInCharge().getEmail());
        }
        return true;

    }

    @Override
    public Map<String, ?> retrieve(Object object) {
        if(object instanceof User)
        {
            return users;
        }
        return crossings;
    }

    @Override
    public Object retrieve(String key) {
        if(users.containsKey(key))
            return  users.get(key);
        return crossings.get(key);
    }

    public int getUserCount() {
        return users.size();
    }

    public int getCrossingsCount() {
        return crossings.size();
    }


    public void exportData() {

        try {

            File file1 = new File(path1);
            File file2 = new File(path2);
            if(!file1.exists()) {
                file1.mkdir();
                System.out.println("Directory Created by the name of "+file1.getName());
            }
            if(!file2.exists()) {
                file2.mkdir();
                System.out.println("Directory Created by the name of "+file2.getName());
            }

            for(String key : users.keySet()) {
                File userFile = new File(path1, key+".txt");
                FileOutputStream stream = new FileOutputStream(userFile);
                ObjectOutputStream objectStream = new ObjectOutputStream(stream);
                objectStream.writeObject(users.get(key));
                System.out.println("User: "+key+" Exported...");
                objectStream.close();
                stream.close();
            }

            for(String key : crossings.keySet()) {
                File userFile = new File(path2, key+".txt");
                FileOutputStream stream = new FileOutputStream(userFile);
                ObjectOutputStream objectStream = new ObjectOutputStream(stream);
                objectStream.writeObject(crossings.get(key));
                System.out.println("Crossing: "+key+" Exported...");
                objectStream.close();
                stream.close();
            }

            System.out.println("EXPORT FINISHED :)");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void importData() {

        try {

            File file1 = new File(path1);
            String[] files = file1.list(); // Get Name of all the files in the users-data directory :)

            for(String fileName : files) {
                File userFile = new File(path1, fileName);
                FileInputStream stream = new FileInputStream(userFile);
                ObjectInputStream objectStream = new ObjectInputStream(stream);
                User user = (User) objectStream.readObject();
                users.put(user.getEmail(), user);
                objectStream.close();
                stream.close();
            }

            File file2 = new File(path2);
            String[] files1 = file2.list();

            for(String fileName : files1) {
                File userFile = new File(path2, fileName);
                FileInputStream stream = new FileInputStream(userFile);
                ObjectInputStream objectStream = new ObjectInputStream(stream);
                RailwayCrossing crossing = (RailwayCrossing) objectStream.readObject();
                crossings.put(crossing.getPersonInCharge().getEmail(), crossing);
                objectStream.close();
                stream.close();
            }

            System.out.println("IMPORT FINISHED :)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
