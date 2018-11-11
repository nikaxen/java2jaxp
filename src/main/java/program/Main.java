package program;

import advs.CarAdv;
import advs.ExclusiveCarAdv;
import program.services.FileResolver;
import program.services.StAXReader;
import program.services.XMLValidator;

import java.util.List;

public class Main {
   public static void main(String[] args) {
      XMLValidator xmlValidator = new XMLValidator();
      FileResolver fileResolver = new FileResolver();
      StAXReader xmlReader = new StAXReader();

      if (xmlValidator.validateXMLSchema(fileResolver.getXmlFileAbsolutePath("ExclusiveCarAdvList.xml"),
              fileResolver.getXmlFileAbsolutePath("XMLSchema.xsd"))) {
         List<ExclusiveCarAdv> exclusiveCarAdvs = xmlReader.readXMLFromFile("ExclusiveCarAdvList.xml");
         fileResolver.writeResultHtmlFile(exclusiveCarAdvs);
      }
   }
}