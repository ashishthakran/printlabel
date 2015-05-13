/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.camp.web.util;

import com.camp.web.model.PrinterDetail;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nsf
 */
public final class PrinterConfigurationReader {
    
    private final Map<String, PrinterDetail> printers = new HashMap<String, PrinterDetail>();
    
    public Map<String, PrinterDetail> getPrinters() {
        return printers;
    }
    
    private void readPrinterConfiguration() {
        
    }
}
