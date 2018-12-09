package advs;


import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class CarAdv {
   @XmlElement(name = "id", required = true)
   private String id;
   @XmlElement(name = "carAdvName")
   private String carAdvName;
   @XmlElement(name = "carAdvDate")
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
