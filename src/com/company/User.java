package com.company;
import java.util.ArrayList;
import java.util.Random;
import java.io.Serializable;
public class User implements Serializable {

    int id;
    String name;
    String password;
    ArrayList<Computer> stock = new ArrayList<>();

    public User(String name, String password){
        Random rnd = new Random();
        //Generates random 6 digit number for identification
        this.id = 100000 + rnd.nextInt(900000);  //There needs to be a check for pre-existing id's
        this.name = name;
        this.password = password;
    }


    //DESKTOP CREATION
    //new destkop and new laptop methods
    //this methods handles desktops
    public void newComputer(String processorBrand, String processorSpeed, String videoOutput,
                            int hardDriveSize, int RAMSize, int displayMonitorSize, int caseSize)
    {
        stock.add(new Desktop(processorBrand, processorSpeed, videoOutput,
                hardDriveSize, RAMSize, displayMonitorSize, caseSize));
    }

    //LAPTOP CREATION
    //This overloaded method has two extra variables AND no case size variable
    public void newComputer(String processorBrand, String processorSpeed, String videoOutput,
                            int hardDriveSize, int RAMSize, int displayMonitorSize,
                            boolean hasTrackPad, boolean hasDvdDrive)
    {
        stock.add(new Laptop(processorBrand, processorSpeed, videoOutput,
                hardDriveSize, RAMSize, displayMonitorSize, hasTrackPad, hasDvdDrive));
    }

    //returns computers based on their processor brand
    public Computer findComputer(String processorBrand){
        Computer comp = null;
        for (Computer i : stock) {
            if (i.processorBrand.equals(processorBrand)) {
                comp = i;
                break;
            }
        }
        return comp;
    }


    public ArrayList<Computer> returnAllPossessions(){
        return stock;
    }


}

