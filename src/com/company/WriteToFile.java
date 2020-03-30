package com.company;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
public class WriteToFile {


    Scanner input = new Scanner(System.in);
    ArrayList<User> user_arrray;

    public void getArray(ArrayList<User> argument_array){
        this.user_arrray = argument_array;
    }

    public void writeArray() {


        //objectFile is file name. Error execption handling for opening our file here:
        try (ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream("objectFile"))) {


            ArrayList<User> objectArray = user_arrray;
            fileOut.writeObject(objectArray);


        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        } //end catch

    }

}
