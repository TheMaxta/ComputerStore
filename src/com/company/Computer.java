package com.company;
import java.io.Serializable;
//Child elements are desktop and laptop
//Parent object should set both child classes to Serializable for file i/o
public class Computer implements Serializable {


    String processorBrand;
    String processorSpeed;
    String videoOutput; //VGA or HDMI
    int hardDriveSize;   //Standard sizes are 2.5 and 3.5inches
    int RAMSize;     //how many GB / MB (gigabytes)
    int displayMonitorSize;

    //huge constructor
    public Computer(
            String processorBrand, String processorSpeed, String videoOutput,
            int hardDriveSize,
            int RAMSize, int displayMonitorSize
    ){
        this.processorBrand = processorBrand;
        this.processorSpeed = processorSpeed;
        this.videoOutput = videoOutput;
        this.hardDriveSize = hardDriveSize;
        this.RAMSize = RAMSize;
        this.displayMonitorSize = displayMonitorSize;
    }


}
