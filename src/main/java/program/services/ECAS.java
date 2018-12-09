package program.services;

import advs.CarAdvStatus;
import advs.ExclusiveCarAdv;

public class ECAS {

   public ExclusiveCarAdv synchronizeWithFNS(ExclusiveCarAdv exclusiveCarAdv) {
      if (exclusiveCarAdv.getCarAdvStatus().equals(CarAdvStatus.CLOSED)) {
         exclusiveCarAdv.setCarAdvName("ADV CLOSED");
      }
      return exclusiveCarAdv;
   }
}
