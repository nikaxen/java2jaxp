package advs;

import java.util.List;

public class ExclusiveCarAdv extends CarAdv {
   private String id;
   private String carAdvName;
   private CarAdvStatus carAdvStatus;
   private OwnersDocuments ownersDocumentsList;

   @Override
   public String getId() {
      return id;
   }

   @Override
   public void setId(String id) {
      this.id = id;
   }

   @Override
   public String getCarAdvName() {
      return carAdvName;
   }

   @Override
   public void setCarAdvName(String carAdvName) {
      this.carAdvName = carAdvName;
   }

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
