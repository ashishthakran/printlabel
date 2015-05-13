/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.camp.web.converter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

/**
 *
 * @author nsf
 */
public class XMLConverter {

    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    public Marshaller getMarshaller() {
        return marshaller;
    }

    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public Unmarshaller getUnmarshaller() {
        return unmarshaller;
    }

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    public void convertFromObjectToXML(Object object, Resource resource)
            throws IOException {

        FileOutputStream os = null;
        try {
            File file = resource.getFile();
            os = new FileOutputStream(file);
            getMarshaller().marshal(object, new StreamResult(os));
        } finally {
            if (null != os) {
                os.close();
            }
        }
    }
 
    public Object convertFromXMLToObject(Resource resource) throws IOException {

        FileInputStream fileStream = null;
        try {
            File file = resource.getFile();
            fileStream = new FileInputStream(file);            
            return getUnmarshaller().unmarshal(new StreamSource(fileStream));
        } finally {
            if (null != fileStream) {
                fileStream.close();
            }
        }
    }

}
