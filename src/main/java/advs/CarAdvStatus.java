package advs;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum CarAdvStatus {
   MODERATING(),FAILED_MODERATING(),ACTIVE(),CLOSED()
}
