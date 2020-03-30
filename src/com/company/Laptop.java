package com.company;

public class Laptop extends Computer {
        //laptop has no case
    boolean hasTrackPad;
    boolean hasDvdDrive;


    //worried it might be better to construct with an array -_- idk. this is a lot of arguments
    public Laptop(String processorBrand, String processorSpeed, String videoOutput, int hardDriveSize,
                  int RAMSize, int displayMonitorSize, boolean hasTrackPad, boolean hasDvdDrive) {

        super(processorBrand, processorSpeed, videoOutput, hardDriveSize, RAMSize, displayMonitorSize);

        //SPECIFIC TO LAPTOP
        //no case
        this.hasTrackPad = hasTrackPad;
        this.hasDvdDrive = hasDvdDrive;
    }

    public void printAttributes(){
        System.out.println("Brand: "+this.processorBrand);
        System.out.println("Processor Speed: " + this.processorSpeed);
        System.out.println("Output: " + this.videoOutput);
        System.out.println("HDD: "+ this.hardDriveSize);
        System.out.println("RAM: " + this.RAMSize);
        System.out.println("Monitor: " + this.displayMonitorSize);
        System.out.println("TrackPad Present?: "+ this.hasTrackPad);
        System.out.println("Dvd Drive Present? " + this.hasDvdDrive);
    }


}
