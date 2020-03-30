package com.company;

public class Desktop extends Computer {
    int caseSize;   //14inch being small low end 27inch being tall high end

    public Desktop(String processorBrand, String processorSpeed, String videoOutput, int hardDriveSize,
                   int RAMSize, int displayMonitorSize, int caseSize) {

        super(processorBrand, processorSpeed, videoOutput, hardDriveSize, RAMSize, displayMonitorSize);
        this.caseSize = caseSize;
    }


    public void printAttributes(){
        System.out.println("Brand: "+this.processorBrand);
        System.out.println("Processor Speed: " + this.processorSpeed);
        System.out.println("Output: " + this.videoOutput);
        System.out.println("HDD: "+ this.hardDriveSize);
        System.out.println("RAM: " + this.RAMSize);
        System.out.println("Monitor: " + this.displayMonitorSize);
        System.out.println(this.caseSize);
    }
}
