package advs;

import java.util.Date;

public class CarAdv {
   private String id;
   private String carAdvName;
   private Date carAdvDate;

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getCarAdvName() {
      return carAdvName;
   }

   public void setCarAdvName(String carAdvName) {
      this.carAdvName = carAdvName;
   }

   public Date getCarAdvDate() {
      return carAdvDate;
   }

   public void setCarAdvDate(Date carAdvDate) {
      this.carAdvDate = carAdvDate;
   }
}
