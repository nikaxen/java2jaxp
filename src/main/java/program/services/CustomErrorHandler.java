package program.services;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class CustomErrorHandler implements ErrorHandler {
   @Override
   public void warning(SAXParseException exception) {
      System.err.println(String.format("WARNING: XML Validate warning in  Line: %d, Column: %d ", exception.getLineNumber(), exception.getColumnNumber()));
   }

   @Override
   public void error(SAXParseException exception) throws SAXException {
      System.err.println(String.format("ERROR: XML Validate error in Line: %d, Column: %d ", exception.getLineNumber(), exception.getColumnNumber()));
      throw exception;
   }

   @Override
   public void fatalError(SAXParseException exception) throws SAXException {
      System.err.println(String.format("FATAL ERROR: XML Validate error in Line: %d, Column: %d ", exception.getLineNumber(), exception.getColumnNumber()));
      throw exception;
   }
}