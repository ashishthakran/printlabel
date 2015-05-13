/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camp.service.print;

import com.camp.web.model.PrinterData;
import fr.w3blog.zpl.constant.ZebraFont;
import fr.w3blog.zpl.model.ZebraLabel;
import fr.w3blog.zpl.model.ZebraUtils;
import fr.w3blog.zpl.model.element.ZebraBarCode39;
import fr.w3blog.zpl.model.element.ZebraText;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author nsf
 */
@Service
@Qualifier(value = "printService")
public class PrintService {

    public void printLabel(PrinterData printerData) {
        try {
            ZebraLabel zebraLabel = new ZebraLabel(912, 912);
            zebraLabel.setDefaultZebraFont(ZebraFont.ZEBRA_ZERO);

            zebraLabel.addElement(new ZebraText(10, 84, "Product:", 14));
            zebraLabel.addElement(new ZebraText(395, 85, "Camera", 14));

            zebraLabel.addElement(new ZebraText(10, 161, "CA201212AA", 14));

            zebraLabel.addElement(new ZebraBarCode39(10, 297, "CA201212AA", 118, 2, 2));

            zebraLabel.addElement(new ZebraText(10, 365, "Qté:", 11));
            zebraLabel.addElement(new ZebraText(180, 365, "3", 11));
            zebraLabel.addElement(new ZebraText(317, 365, "QA", 11));

            zebraLabel.addElement(new ZebraText(10, 520, "Ref log:", 11));
            zebraLabel.addElement(new ZebraText(180, 520, "0035", 11));
            zebraLabel.addElement(new ZebraText(10, 596, "Ref client:", 11));
            zebraLabel.addElement(new ZebraText(180, 599, "1234", 11));

            List<ZebraLabel> zebraLabels = new ArrayList<ZebraLabel>();
            zebraLabels.add(zebraLabel);
            zebraLabels.add(zebraLabel);

            ZebraUtils.printZpl(zebraLabels, printerData.getIpAddress(), printerData.getPort());
        } catch (Exception ex) {
            System.out.println("Exception in Print Service ==> " + ex);
        }
    }
}
