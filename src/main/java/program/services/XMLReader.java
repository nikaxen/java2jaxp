package program.services;

import advs.CarAdvStatus;
import advs.ExclusiveCarAdv;
import advs.OwnersDocuments;

import javax.xml.bind.util.JAXBSource;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;

public class XMLReader {
   public void transformXmlToHtml(JAXBSource source, String xslFileName) {
      try {
         TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer(new StreamSource(xslFileName));
         transformer.transform(source, new StreamResult(new File("default.html")));
      } catch (Exception e) {
         System.err.println("ERROR WHILE PROCESSING XML");
         e.printStackTrace();
      }
   }
}