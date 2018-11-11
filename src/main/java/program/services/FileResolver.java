package program.services;

import advs.ExclusiveCarAdv;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class FileResolver {

   public String getXmlFileAbsolutePath(String xmlFileName) {
      return getClass().getClassLoader().getResource(xmlFileName).getPath();
   }

   public void writeResultHtmlFile(List<ExclusiveCarAdv> exclusiveCarAdvs) {
      try {
         File htmlFile = new File("default.html");
         if (!htmlFile.createNewFile()) {
            System.err.println("Error in creation an .html file");
         } else {
            Document document = GenerateHTMLPage();
            Element table = appendTableToHtmlPage(document);
            appendInfoToTable(exclusiveCarAdvs, table);
            appendFooterToTable(exclusiveCarAdvs, table);
            FileUtils.writeStringToFile(htmlFile, document.outerHtml(), "UTF-8");
         }
      } catch (IOException exception) {
         System.err.println(exception.getMessage());
      }
   }

   private Document GenerateHTMLPage() {
      Document document = Jsoup.parse("<html></html>");
      document.head().appendElement("meta").attr("charset", "UTF-8");
      document.head().appendElement("link").attr("rel", "stylesheet").attr("href", "main.css");
      return document;
   }

   private Element appendTableToHtmlPage(Document defaultPage) {
      Element table = defaultPage.body().appendElement("table");
      Element tableTitles = table.appendElement("thead").appendElement("tr");
      tableTitles.appendElement("td").appendText("ID");
      tableTitles.appendElement("td").appendText("carAdvName");
      tableTitles.appendElement("td").appendText("carAdvDate");
      tableTitles.appendElement("td").appendText("Статус");
      tableTitles.appendElement("td").appendText("inn");
      tableTitles.appendElement("td").appendText("passport");
      return table;
   }

   private void appendInfoToTable(List<ExclusiveCarAdv> exclusiveCarAdvs, Element table) {
      Element tableBody = table.appendElement("tbody");
      exclusiveCarAdvs.forEach(exclusiveCarAdv -> {
         Element tableRow = tableBody.appendElement("tr");
         tableRow.appendElement("td").appendText(exclusiveCarAdv.getId());
         tableRow.appendElement("td").appendText(String.valueOf(exclusiveCarAdv.getCarAdvName()));
         tableRow.appendElement("td").appendText(new SimpleDateFormat("yyyy-M-d H:m").format(exclusiveCarAdv.getCarAdvDate()));
         tableRow.appendElement("td").appendText(translateStatus(exclusiveCarAdv));
         tableRow.appendElement("td").appendText(String.valueOf(exclusiveCarAdv.getOwnersDocumentsList().getInn()));
         tableRow.appendElement("td").appendText(String.valueOf(exclusiveCarAdv.getOwnersDocumentsList().getPassport()));
      });
   }

   private String translateStatus(ExclusiveCarAdv exclusiveCarAdv){
      String carAdvStatusRus = "undefined";
      switch(exclusiveCarAdv.getCarAdvStatus()){
         case MODERATING: carAdvStatusRus = "На модерации";break;
         case FAILED_MODERATING: carAdvStatusRus = "Не прошло модерацию";break;
         case ACTIVE: carAdvStatusRus = "Активно";break;
         case CLOSED: carAdvStatusRus = "Закрыто";break;
         default: carAdvStatusRus = "undefined";break;
      }
      return carAdvStatusRus;
   }

   private void appendFooterToTable(List<ExclusiveCarAdv> exclusiveCarAdvs, Element table) {
      Element tableFooter = table.appendElement("tfoot");
      Element tableTrFooter = tableFooter.appendElement("tr");
      tableTrFooter.appendElement("td").appendText("Всего объявлений:");
      tableTrFooter.appendElement("td").appendText(String.valueOf(exclusiveCarAdvs.size())).attr("colspan", "6");
   }
}