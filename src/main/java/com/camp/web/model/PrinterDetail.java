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
public class PrinterDetail {
    
    @Getter @Setter
    private String ipAddress;
    
    @Getter @Setter
    private int port;
    
    @Getter @Setter
    private String model;
    
    @Getter @Setter
    private String location;
    
    public PrinterDetail() {}
    
    public PrinterDetail(String ipAddress, int port, String model, String location) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.model = model;
        this.location = location;
    }   
}
