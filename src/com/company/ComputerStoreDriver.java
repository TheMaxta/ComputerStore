package com.company;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;

public class ComputerStoreDriver {
    public static void main(String[] args) {
        boolean flag;
        int ans = 999;
        Scanner input = new Scanner(System.in);
        ComputerStore testStore = new ComputerStore();
        WriteToFile writer = new WriteToFile();
        ReadFile reader = new ReadFile();

        ArrayList<User> user_array;


        while (ans != 0) {

            //Methods for reading data from file
            reader.readArray();     //reads input into a java array
            user_array = reader.returnUserArray();      //returns that array to our driver

            testStore.loadUserBase(user_array); //pass user_array as argument

            System.out.println("1) Sign Up     ----   (Create New Account)");
            System.out.println("2) Login       ----   (Existing User)");
            System.out.println("-------------------------------------");
            System.out.println("0) Exit Program ");

            ans = input.nextInt();
            if (ans == 1) {
                //create new user

                System.out.printf("Are you a manager? (Yes = true / No = false)");
                flag = input.nextBoolean();
                if (flag) {
                    testStore.addManager();
                } else {
                    testStore.addUser();
                }

            } else if (ans == 2) {
                //login existing user


                testStore.login();


            } else if (ans == 0) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Unrecognized input.");
            }


            //methods for writing output to file (saving progress)
            user_array = testStore.returnUsers();
            writer.getArray(user_array);
            //writer.open / create file
            writer.writeArray();
            //writer.getList(user_array);

        } //end while loop
    } //end main
} //end driver class
