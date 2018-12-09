package program;

import program.services.FileResolver;
import program.services.XMLReader;
import program.services.XMLValidator;

public class Main {
   public static void main(String[] args) {
      XMLValidator xmlValidator = new XMLValidator();
      FileResolver fileResolver = new FileResolver();
      XMLReader xmlReader = new XMLReader();

      xmlValidator.validateXMLSchema(fileResolver.getXmlFileAbsolutePath("ExclusiveCarAdvList.xml"),
              fileResolver.getXmlFileAbsolutePath("XMLSchema.xsd"));
      xmlReader.transformXmlToHtml(fileResolver.getXmlFileAbsolutePath("ExclusiveCarAdvList.xml"),
              fileResolver.getXmlFileAbsolutePath("template.xsl"));
   }
}