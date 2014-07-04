package ietf.params.xml.ns.icalendar.component.base;

import ietf.params.xml.ns.icalendar.component.BaseComponentType;
import ietf.params.xml.ns.icalendar.component.EComponentName;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for ValarmType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="ValarmType"> &lt;complexContent> &lt;extension
 * base="{urn:ietf:params:xml:ns:icalendar-2.0}BaseComponentType">
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValarmType")
public class ValarmType extends BaseComponentType {

  public ValarmType() {
    super(EComponentName.VALARM);
  }

}
