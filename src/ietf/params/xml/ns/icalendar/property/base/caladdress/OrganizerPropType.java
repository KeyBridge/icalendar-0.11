package ietf.params.xml.ns.icalendar.property.base.caladdress;

import ietf.params.xml.ns.icalendar.property.base.CalAddressPropertyType;
import java.net.URI;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for OrganizerPropType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="OrganizerPropType"> &lt;complexContent>
 * &lt;extension
 * base="{urn:ietf:params:xml:ns:icalendar-2.0}CalAddressPropertyType">
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganizerPropType")
public class OrganizerPropType extends CalAddressPropertyType {

  public OrganizerPropType() {
  }

  public OrganizerPropType(String calAddress) {
    super(calAddress);
  }

  public OrganizerPropType(URI calAddress) {
    super(calAddress.toString());
  }

}
