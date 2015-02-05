package ietf.params.xml.ns.icalendar.parameter.base;

import ietf.params.xml.ns.icalendar.parameter.base.caladdress.SentByParamType;
import ietf.params.xml.ns.icalendar.parameter.BaseParameterType;
import java.util.Objects;
import javax.xml.bind.annotation.*;

/**
 * Java class for CalAddressParamType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="CalAddressParamType"> &lt;complexContent>
 * &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BaseParameterType">
 * &lt;sequence> &lt;element
 * ref="{urn:ietf:params:xml:ns:icalendar-2.0}cal-address"/> &lt;/sequence>
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalAddressParamType", propOrder = {
  "calAddress"
})
@XmlSeeAlso({
  SentByParamType.class
})
public class CalAddressParamType
  extends BaseParameterType {

  @XmlElement(name = "cal-address", required = true)
  protected String calAddress;

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
    int hash = 3;
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
    final CalAddressParamType other = (CalAddressParamType) obj;
    if (!Objects.equals(this.calAddress, other.calAddress)) {
      return false;
    }
    return true;
  }
}