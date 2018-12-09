package program;

import advs.exclusiveCarAdvList;
import program.services.ECAS;
import program.services.FileResolver;
import program.services.JAXBWorker;
import program.services.XMLReader;

public class Main {
   public static void main(String[] args) {
      ECAS ecas = new ECAS();
      FileResolver fileResolver = new FileResolver();
      JAXBWorker jaxbWorker = new JAXBWorker();
      XMLReader xmlReader = new XMLReader();

      exclusiveCarAdvList exclusiveCarAdvList = jaxbWorker.unmarshalling(fileResolver.getXmlFileAbsolutePath("ExclusiveCarAdvList.xml"));
      if (!exclusiveCarAdvList.getExclusiveCarAdv().isEmpty()) {
         exclusiveCarAdvList.getExclusiveCarAdv().forEach(ecas::synchronizeWithFNS);
         xmlReader.transformXmlToHtml(jaxbWorker.marshalling(exclusiveCarAdvList), fileResolver.getXmlFileAbsolutePath("template.xsl"));
      }
   }
}