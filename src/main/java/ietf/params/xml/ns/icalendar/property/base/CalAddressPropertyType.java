package ietf.params.xml.ns.icalendar.property.base;

import ietf.params.xml.ns.icalendar.property.BasePropertyType;
import ietf.params.xml.ns.icalendar.property.base.caladdress.AttendeePropType;
import ietf.params.xml.ns.icalendar.property.base.caladdress.OrganizerPropType;
import java.util.Objects;
import javax.xml.bind.annotation.*;

/**
 * Java class for CalAddressPropertyType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="CalAddressPropertyType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType">
 * &lt;sequence> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}cal-address"/> &lt;/sequence>
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalAddressPropertyType", propOrder = {
  "calAddress"
})
@XmlSeeAlso({
  AttendeePropType.class,
  OrganizerPropType.class
})
public class CalAddressPropertyType extends BasePropertyType {

  @XmlElement(name = "cal-address", required = true)
  protected String calAddress;

  public CalAddressPropertyType() {
  }

  public CalAddressPropertyType(String calAddress) {
    this.calAddress = calAddress;
  }

  /**
   * Gets the value of the calAddress property.
   * <p/>
   * @return possible object is {@link String }
   *
   */
  public String getCalAddress() {
    return calAddress;
  }

  /**
   * Sets the value of the calAddress property.
   * <p/>
   * @param value allowed object is {@link String }
   *
   */
  public void setCalAddress(String value) {
    this.calAddress = value;
  }

  public boolean isSetCalAddress() {
    return (this.calAddress != null);
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 89 * hash + Objects.hashCode(this.calAddress);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final CalAddressPropertyType other = (CalAddressPropertyType) obj;
    if (!Objects.equals(this.calAddress, other.calAddress)) {
      return false;
    }
    return true;
  }
}