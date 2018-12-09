package advs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class ExclusiveCarAdv extends CarAdv {
   @XmlElement(name = "carAdvStatus")
   private CarAdvStatus carAdvStatus;

   @XmlElement(name = "ownersDocumentsList")
   private OwnersDocuments ownersDocumentsList;

   public CarAdvStatus getCarAdvStatus() {
      return carAdvStatus;
   }

   public void setCarAdvStatus(CarAdvStatus carAdvStatus) {
      this.carAdvStatus = carAdvStatus;
   }

   public OwnersDocuments getOwnersDocumentsList() {
      return ownersDocumentsList;
   }

   public void setOwnersDocumentsList(OwnersDocuments ownersDocumentsList) {
      this.ownersDocumentsList = ownersDocumentsList;
   }
}
