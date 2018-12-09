package advs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
public class OwnersDocuments  {
   @XmlElement(name = "inn")
   private String inn;
   @XmlElement(name = "passport")
   private String passport;

   public String getInn() {
      return inn;
   }

   public void setInn(String inn) {
      this.inn = inn;
   }

   public String getPassport() {
      return passport;
   }

   public void setPassport(String passport) {
      this.passport = passport;
   }
}
