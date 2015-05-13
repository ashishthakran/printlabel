/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.camp.web.model;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author nsf
 */
public class PrinterData {
    
    @Getter @Setter
    private String ipAddress;
    
    @Getter @Setter
    private boolean checkInFlag;
    
    @Getter @Setter
    private String firstName;
    
    @Getter @Setter
    private String position;
    
    @Getter @Setter
    private String inOutFlag;
    
    @Getter @Setter
    private String fullName;
    
    @Getter @Setter
    private String printDate;
    
    @Getter @Setter
    private String printTime;
    
    @Getter @Setter
    private String weekDay;    
    
    @Getter @Setter
    private String phone = "";
    
    @Getter @Setter
    private String age = "";
    
    @Getter @Setter
    private String food = "";
    
    @Getter @Setter
    private String drink = "";
    
    @Getter @Setter
    private int port;
    
    public PrinterData() {}

    public PrinterData(String ipAddress, boolean checkInFlag, String firstName, String position, String inOutFlag, String fullName, String printDate, String printTime, String weekDay) {
        this.ipAddress = ipAddress;
        this.checkInFlag = checkInFlag;
        this.firstName = firstName;
        this.position = position;
        this.inOutFlag = inOutFlag;
        this.fullName = fullName;
        this.printDate = printDate;
        this.printTime = printTime;
        this.weekDay = weekDay;
    }
    
    public PrinterData(String ipAddress, boolean checkInFlag, String firstName, String position, String inOutFlag, String fullName, 
            String printDate, String printTime, String weekDay, String phone, String age, String food, String drink) {
        this.ipAddress = ipAddress;
        this.checkInFlag = checkInFlag;
        this.firstName = firstName;
        this.position = position;
        this.inOutFlag = inOutFlag;
        this.fullName = fullName;
        this.printDate = printDate;
        this.printTime = printTime;
        this.weekDay = weekDay;
        this.phone = phone;
        this.age = age;
        this.food = food;
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "PrinterData{" + "ipAddress=" + ipAddress + ", checkInFlag=" + checkInFlag + ", firstName=" + firstName + ", position=" + position + ", inOutFlag=" + inOutFlag + ", fullName=" + fullName + ", printDate=" + printDate + ", printTime=" + printTime + ", weekDay=" + weekDay + ", phone=" + phone + ", age=" + age + ", food=" + food + ", drink=" + drink + ", port=" + port + '}';
    }
           
}
