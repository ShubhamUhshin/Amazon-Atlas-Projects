package com.amazon.atlas22.railwaycrossingapp;

import com.amazon.atlas22.railwaycrossingapp.controller.RailwayCrossingController;
import com.amazon.atlas22.railwaycrossingapp.controller.UserController;
import com.amazon.atlas22.railwaycrossingapp.model.RailwayCrossing;
import com.amazon.atlas22.railwaycrossingapp.model.RailwayCrossingFlatten;
import com.amazon.atlas22.railwaycrossingapp.model.User;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class PublicApp {
    Scanner scanner;
    UserController controller;
    RailwayCrossingController railController;
    private static PublicApp app;
    private PublicApp(){
        scanner=new Scanner(System.in);
        controller = UserController.getInstance();
        railController = RailwayCrossingController.getInstance();
    }
    public static PublicApp getInstance(){
        if(app==null){
            app = new PublicApp();
        }
        return app;
    }
    public void startPublicApp() {
        System.out.println("---------------------------------------");
        System.out.println("Welcome To Railway Crossing Aap!");
        System.out.println("We have "+controller.getUserCount()+" Users in the DataBase");
        System.out.println("1: Register");
        System.out.println("2: Login");
        System.out.println("----------------------------------------");


        int choice = scanner.nextInt();
        switch (choice) {

            case 1:
                register();
                break;

            case 2:
                login();
                break;

            default:
                System.err.println("Invalid Choice");
        }

    }

    void Home(){
        while(true) {

            System.out.println("-----------------------------------");
            System.out.println("Welcome to Railway Crossing Home");
            System.out.println("1: List Railway Crossings");
            System.out.println("2: Search Railway Crossings");
            System.out.println("3: Get the status of a Crossing");
            System.out.println("4: Sort Railway Crossings by Schedule"); // yet to be implemented
            System.out.println("5: Close Public Application");
            System.out.println("-----------------------------------");

            int choice = scanner.nextInt();
            switch (choice) {

                case 1:
                    listCrossings();
                    break;

                case 2:searchCrossing();

                    break;

                case 3:getStatus();
                    break;
                case 4: sortCrossing();
                    break;

                case 5:
                    System.out.println("Thank You for using Railway Crossing App");
                    break;

                default:
                    System.err.println("Invalid Choice");
            }

            if(choice == 5) {
                break;
            }
        }
    }


    void sortCrossing()
    {
        ArrayList<RailwayCrossingFlatten> railwayCrossingArrayList = new ArrayList<>();
        for(RailwayCrossing rc:GovernmentApp.getCrossings(railController,true))
        {
            Map<String,String> schedule = rc.getSchedules();
            for(String key:schedule.keySet())
            {
                String from=key;
                String to=schedule.get(key);
                railwayCrossingArrayList.add(new RailwayCrossingFlatten(rc.getName(), rc.getAddress(),rc.getStatus(),from,to,rc.getPersonInCharge().getName()));
            }
        }

        railwayCrossingArrayList.sort((obj1,obj2)->{
            return obj1.getFrom().compareTo(obj2.getFrom());
        });
        System.out.println("------DISPLAYING RAILWAY CROSSING IN SORTED ORDER OF TIME---------");
        for(RailwayCrossingFlatten rcf:railwayCrossingArrayList)
        {
            System.out.println(rcf.toString());
            System.out.println();
        }

    }
    void getStatus(){
        scanner.nextLine();
        System.out.println("Enter the Crossing name:");
        String crossingName =scanner.nextLine();
        Map<String, RailwayCrossing> crossings = (Map<String,RailwayCrossing>) railController.fetchCrossings();
        for(String key:crossings.keySet())
        {
            if(crossings.get(key).getName().equalsIgnoreCase(crossingName)) {
                System.out.println("Current status of railway crossing:"+crossingName +" is:");
                System.out.println((crossings.get(key).getStatus()));
                break;
            }
        }
        System.err.println("Crossing not found!");

    }
    void listCrossings(){
        GovernmentApp.getCrossings(railController,false);
    }

    void searchCrossing()
    {
        scanner.nextLine();
        System.out.println("Enter the Crossing name:");
        String crossingName =scanner.nextLine();
        railController.searchCrossing(crossingName);

    }



    void login()
    {
        scanner.nextLine();
        User user = new User();
        System.out.println("Enter Email: ");
        user.setEmail(scanner.nextLine());
        System.out.println("Enter Password: ");
        user.setPassword(scanner.nextLine());

        user.setUserType(User.userType.USER);

        if(controller.userLogin(user)) {
            System.out.println(user.getName()+", You have Logged In Successfully..");
            System.out.println("Navigating to the Home Page");
            Home();
        }else {
            System.err.println("Something Went Wrong. Please Try Again");
        }
    }


    void register() {
        User user = new User();
        scanner.nextLine();
        System.out.println("Enter Name: ");
        user.setName(scanner.nextLine());

        System.out.println("Enter Email: ");
        user.setEmail(scanner.nextLine());

        System.out.println("Enter Password: ");
        user.setPassword(scanner.nextLine());

        user.setUserType(User.userType.USER);

        if(controller.registerUser(user)) {
            System.out.println(user.getName()+", You have Registered Successfully..");
            System.out.println("Navigating to the Home page!");
            Home();

        }else {
            System.err.println("Either user already exists or Something Went Wrong. Please Try Again");
        }
    }


}
