package program.services;

import advs.exclusiveCarAdvList;
import jdk.internal.org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileInputStream;

public class JAXBWorker {

    public exclusiveCarAdvList unmarshalling(String xmlFileAbsolutePath) {
        exclusiveCarAdvList exclusiveCarAdvList = new exclusiveCarAdvList();
        try (FileInputStream fileInputStream = new FileInputStream(xmlFileAbsolutePath)) {
            JAXBContext jaxbContext = JAXBContext.newInstance(exclusiveCarAdvList.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            exclusiveCarAdvList = (exclusiveCarAdvList) unmarshaller.unmarshal(fileInputStream);
        } catch (Exception exception) {
            System.err.println("ERROR WHILE DESERIALIZING XML");
            exception.printStackTrace();
        }
        return exclusiveCarAdvList;
    }

    public JAXBSource marshalling(exclusiveCarAdvList businessEntityList) {
        JAXBSource source = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(exclusiveCarAdvList.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            source = new JAXBSource(jaxbContext, businessEntityList);
        } catch (Exception exception) {
            System.err.println("ERROR WHILE SERIALIZING XML");
            exception.printStackTrace();
        }
        return source;
    }

}
