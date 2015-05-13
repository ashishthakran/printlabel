/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.camp.web.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author nsf
 */
public class PrinterProperties {
    
    @Getter @Setter
    private List<PrinterDetail> printerDetail;
    
    public PrinterProperties() {}
}
