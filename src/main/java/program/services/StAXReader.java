package program.services;

import advs.CarAdvStatus;
import advs.ExclusiveCarAdv;
import advs.OwnersDocuments;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.security.acl.Owner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class StAXReader {

   public List<ExclusiveCarAdv> readXMLFromFile(String xmlFileName) {
      List<ExclusiveCarAdv> exclusiveCarAdvs = new ArrayList<>();


      FileResolver fileResolver = new FileResolver();
      String xmlAbsoluteFilePath = fileResolver.getXmlFileAbsolutePath(xmlFileName);


      XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();


      try (FileInputStream fileInputStream = new FileInputStream(xmlAbsoluteFilePath)) {
         XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(fileInputStream);

         int level = 1;
         do {
            XMLEvent xmlEvent = xmlEventReader.peek();
            switch (xmlEvent.getEventType()) {
               case XMLStreamConstants.START_DOCUMENT:
                  level++;
                  break;
               case XMLStreamConstants.START_ELEMENT:
                  level++;
                  String elementName = xmlEvent.asStartElement().getName().toString();
                  elementName = elementName.substring(elementName.indexOf('}') + 1, elementName.length());
                  if (elementName.equals("exclusiveCarAdv")) {

                     ExclusiveCarAdv exclusiveCarAdv = getExclusiveCarAdvsFROMXML(xmlEventReader);
                     exclusiveCarAdvs.add(exclusiveCarAdv);
                     level--;
                  }
                  break;
               case XMLStreamConstants.END_ELEMENT:
                  level--;
                  break;
               case XMLStreamConstants.END_DOCUMENT:
                  level--;
                  break;
            }
            xmlEventReader.nextEvent();
         } while (level > 1);
      } catch (Exception exception) {
         System.err.println("Error during parse XML");
         System.err.println(exception.getMessage());
      }
      return exclusiveCarAdvs;
   }

   private ExclusiveCarAdv getExclusiveCarAdvsFROMXML(XMLEventReader xmlEventReader) throws XMLStreamException, ParseException {
      ExclusiveCarAdv exclusiveCarAdv = new ExclusiveCarAdv();

      int level = 1;
      do {
         XMLEvent xmlEvent = xmlEventReader.peek();
         switch (xmlEvent.getEventType()) {
            case XMLStreamConstants.START_ELEMENT:
               level++;
               String elementName = xmlEvent.asStartElement().getName().toString();
               elementName = elementName.substring(elementName.indexOf('}') + 1, elementName.length());
               switch (elementName) {
                  case "id":
                     xmlEventReader.nextEvent();
                     XMLEvent xmlIdEvent = xmlEventReader.nextEvent();
                     exclusiveCarAdv.setId(xmlIdEvent.asCharacters().getData());
                     level--;
                     break;
                  case "carAdvName":
                     xmlEventReader.nextEvent();
                     XMLEvent xmlcarAdvNameEvent = xmlEventReader.nextEvent();
                     exclusiveCarAdv.setCarAdvName(xmlcarAdvNameEvent.asCharacters().getData());
                     level--;
                     break;
                  case "carAdvStatus":
                     xmlEventReader.nextEvent();
                     XMLEvent xmlRegistryStatusEvent = xmlEventReader.nextEvent();
                     exclusiveCarAdv.setCarAdvStatus(CarAdvStatus.valueOf(xmlRegistryStatusEvent.asCharacters().getData()));
                     level--;
                     break;
                  case "carAdvDate":
                     xmlEventReader.nextEvent();
                     XMLEvent xmlDateEvent = xmlEventReader.nextEvent();
                     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d'T'H:m:s");
                     exclusiveCarAdv.setCarAdvDate(dateFormat.parse(xmlDateEvent.asCharacters().getData()));
                     level--;
                     break;
                  case "ownersDocumentsList":
                     xmlEventReader.nextEvent();
                     exclusiveCarAdv.setOwnersDocumentsList(parseOwnerDocumentsList(xmlEventReader));
                     level--;
                     break;
               }
               break;
            case XMLStreamConstants.END_ELEMENT:
               level--;
               break;
         }
         xmlEventReader.nextEvent();
      } while (level > 1);
      return exclusiveCarAdv;
   }

   private OwnersDocuments parseOwnerDocumentsList(XMLEventReader xmlEventReader) throws XMLStreamException, ParseException {
      OwnersDocuments ownersDocuments = new OwnersDocuments();
      String elementName;
      XMLEvent xmlOwnersDocumentsEvent;
      int level = 1;
      while (level > 0) {
         XMLEvent xmlEvent = xmlEventReader.peek();
         switch (xmlEvent.getEventType()) {
            case XMLStreamConstants.START_ELEMENT:
               level++;
               elementName = xmlEvent.asStartElement().getName().toString();
               elementName = elementName.substring(elementName.indexOf('}') + 1, elementName.length());
               xmlEventReader.nextEvent();
               xmlOwnersDocumentsEvent = xmlEventReader.nextEvent();
               switch (elementName) {
                  case "inn":
                     ownersDocuments.setInn(Integer.valueOf(xmlOwnersDocumentsEvent.asCharacters().getData()));
                     level--;
                     break;
                  case "passport":
                     ownersDocuments.setPassport(xmlOwnersDocumentsEvent.asCharacters().toString());
                     level--;
                     break;
               }
               break;
            case XMLStreamConstants.END_ELEMENT:
               level--;
               break;
         }
         xmlEventReader.nextEvent();
      }
      return ownersDocuments;
   }

}