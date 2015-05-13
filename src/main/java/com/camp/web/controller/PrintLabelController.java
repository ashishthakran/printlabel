/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camp.web.controller;

import com.camp.service.print.PrintService;
import com.camp.web.converter.XMLConverter;
import com.camp.web.model.PrinterData;
import com.camp.web.model.PrinterDetail;
import com.camp.web.model.PrinterProperties;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nsf
 */
@RestController
public class PrintLabelController {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private XMLConverter xmlConverter;

    @Autowired
    @Qualifier(value = "printService")
    private PrintService printService;
            
    @RequestMapping(value = "/printlabel/{ipAddress}/{port}/{checkInFlag}/{firstName}/{position}/{inOutFlag}/{fullName}/{printDate}/{printTime}/{weekDay}", method = RequestMethod.GET)
    public String doPrintCheckOutLabelByGet(@ModelAttribute(value = "printerData") PrinterData printerData) {
        
        printLabel(printerData);

        return "hello by doPrintCheckOutLabelByGet";
    }
    
    @RequestMapping(value = "/printlabel/{ipAddress}/{port}/{checkInFlag}/{firstName}/{position}/{inOutFlag}/{fullName}/{printDate}/{printTime}/{weekDay}", method = RequestMethod.POST)
    public String doPrintCheckOutLabelByPost(@ModelAttribute(value = "printerData") PrinterData printerData) {

        printLabel(printerData);

        return "hello by doPrintCheckOutLabelByPost";
    }    

    @RequestMapping(value = "/printlabel", method = RequestMethod.GET)
    public String doPrintCheckOutLabelByGetRequest(HttpServletRequest request, HttpServletResponse response, @ModelAttribute(value = "printerData") PrinterData printerData) {
        printLabel(printerData);

        return "hello by doPrintCheckOutLabelByGetRequest";
    }
    
    @RequestMapping(value = "/printlabel", method = RequestMethod.POST)
    public String doPrintCheckOutLabelByPostRequest(HttpServletRequest request, HttpServletResponse response, @ModelAttribute(value = "printerData") PrinterData printerData) {
        printLabel(printerData);

        return "hello by doPrintCheckOutLabelByPostRequest";
    }
    
    @RequestMapping(value = "/printlabel/{ipAddress}/{port}/{checkInFlag}/{firstName}/{position}/{inOutFlag}/{fullName}/{printDate}/{printTime}/{weekDay}/{phone}/{age}/{food}/{drink}", method = RequestMethod.GET)
    public String doPrintCheckInLabelByGet(@ModelAttribute(value = "printerData") PrinterData printerData) {
        printLabel(printerData);

        return "hello by doPrintCheckInLabelByGet";
    }
    
    @RequestMapping(value = "/printlabel/{ipAddress}/{port}/{checkInFlag}/{firstName}/{position}/{inOutFlag}/{fullName}/{printDate}/{printTime}/{weekDay}/{phone}/{age}/{food}/{drink}", method = RequestMethod.POST)
    public String doPrintCheckInLabelByPost(@ModelAttribute(value = "printerData") PrinterData printerData) {
        printLabel(printerData);

        return "hello by doPrintCheckInLabelByPost";
    }    
    
    private void printLabel(PrinterData printerData) {
        try {
            Resource resource = context.getResource("classpath:printerproperties.xml");
            PrinterProperties printerProperties = (PrinterProperties) xmlConverter.convertFromXMLToObject(resource);
            
            for(PrinterDetail detail : printerProperties.getPrinterDetail()) {
                System.out.println("IP Address ==> " + detail.getIpAddress());
                System.out.println("Location ==> " + detail.getLocation());
                System.out.println("Model ==> " + detail.getModel());
                System.out.println("Port ==> " + detail.getPort());
            }
            
            System.out.println("Printer Data " + printerData);
            
//            printService.printLabel(printerData);
            
        } catch (Exception ex) {
            System.out.println("Exception ==> " + ex);
        }
    }
}
