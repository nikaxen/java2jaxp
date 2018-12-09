package advs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "exclusiveCarAdvList")
@XmlAccessorType(XmlAccessType.FIELD)
public class exclusiveCarAdvList {

    @XmlElement(name = "exclusiveCarAdv")
    private List<ExclusiveCarAdv> exclusiveCarAdv;

    public List<ExclusiveCarAdv> getExclusiveCarAdv() {
        return exclusiveCarAdv;
    }

    public void setExclusiveCarAdv(List<ExclusiveCarAdv> exclusiveCarAdv) {
        this.exclusiveCarAdv = exclusiveCarAdv;
    }

}
