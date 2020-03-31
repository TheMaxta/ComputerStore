package com.company;
import java.util.ArrayList;
import java.util.Random;

public class Manager extends User {
    int id;
    ArrayList<User> user_list = new ArrayList<>();
    User user_instance;
    //manager is the same as user, but can also add or remove a specified users account and possesions (stock).
    public Manager( String name, String password) {
        super(name, password);

        Random rnd = new Random();
        this.id = 100000 + rnd.nextInt(900000);  //There needs to be a check for pre-existing id's
    }

    public void getUsers(ArrayList<User> user_list){
        this.user_list = user_list;
    }
    //somehow the manager class needs access to it's parent objects users arraylist

    public void findUser(String name){
        for (User i : user_list) {
            if (i.name.equals(name)){
                //user found.
                user_instance = i;
                System.out.printf("User Found at ID: %d, Name: %s, Inventory: ", i.id, i.name, i.stock.size());
            }
        }
    }

    public void findUserByID(int id){
        for (User i : user_list) {
            if ( i.id == id ){
                //user found.
                user_instance = i;
                System.out.printf("User Found at ID: %d, Name: %s, Inventory: ", i.id, i.name, i.stock.size());
            }
        }
    }

    public void outputUserList(){
        int counter = 1;
        for (User i : user_list) {
            System.out.printf("#%d). User Id: %d -- User Name:  %s -- Computers Owned: %d\n", counter, i.id, i.name, i.stock.size());
            counter++;
        }
    }

    public ArrayList<User> destroyUser(){
        int index;
        index = user_list.indexOf(user_instance);
        user_list.remove(index);
        return user_list;
    }

    public ArrayList<User> destroyAllUsers(){
        user_list.removeAll(user_list);
        //needs to return empty user_list to Computer Store
        return (user_list);
    }

}
