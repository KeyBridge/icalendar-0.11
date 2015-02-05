package ietf.params.xml.ns.icalendar.property.base.integer;

import ietf.params.xml.ns.icalendar.property.base.IntegerPropertyType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for SequencePropType complex type.
 * <p/>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p/>
 * <
 * pre> &lt;complexType name="SequencePropType"> &lt;complexContent>
 * &lt;extension
 * base="{urn:ietf:params:xml:ns:icalendar-2.0}IntegerPropertyType">
 * &lt;/extension> &lt;/complexContent> &lt;/complexType>
 * </pre>
 * <p/>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SequencePropType")
public class SequencePropType extends IntegerPropertyType {

  public SequencePropType() {
  }

  public SequencePropType(int sequence) {
    super();
    this.integer = sequence;
  }

}