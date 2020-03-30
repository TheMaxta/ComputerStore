package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.EOFException;
import java.io.*;

public class ReadFile {
    ArrayList<User> user_array = new ArrayList<>();
    Scanner input = new Scanner(System.in);



    public ArrayList<User> returnUserArray(){
        return this.user_array;
    }

    public void readArray(){
        try (ObjectInputStream fileIn = new ObjectInputStream( new FileInputStream("objectFile"))){
            while (true){
                user_array = (ArrayList<User>) fileIn.readObject(); //this method generally reads in all objects but we only need one arraylist
                //user_array.display();
            } //end try and close file automatically
        } catch (EOFException e)
        {} //end of file exception terminates infinite while loop
        catch (Exception e){
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        } //end 2nd catch





    } //end readfile method





} //end class
