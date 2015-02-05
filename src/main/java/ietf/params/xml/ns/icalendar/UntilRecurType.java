package ietf.params.xml.ns.icalendar;

import ietf.params.xml.ns.icalendar.adapter.XmlAdapterXCalDate;
import ietf.params.xml.ns.icalendar.adapter.XmlAdapterXCalDateTime;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Java class for UntilRecurType complex type.
 * <p>
 * The UNTIL rule part defines a DATE or DATE-TIME value that bounds the
 * recurrence rule in an inclusive manner.
 * <p>
 * If the value specified by UNTIL is synchronized with the specified
 * recurrence, this DATE or DATE-TIME becomes the last instance of the
 * recurrence.
 * <p>
 * <strong>The value of the UNTIL rule part MUST have the same value type as the
 * "DTSTART" property.</strong>
 * <p>
 * Furthermore, if the "DTSTART" property is specified as a date with local
 * time, then the UNTIL rule part MUST also be specified as a date with local
 * time. If the "DTSTART" property is specified as a date with UTC time or a
 * date with local time and time zone reference, then the UNTIL rule part MUST
 * be specified as a date with UTC time.
 * <p>
 * In the case of the "STANDARD" and "DAYLIGHT" sub-components the UNTIL rule
 * part MUST always be specified as a date with UTC time. If specified as a
 * DATE-TIME value, then it MUST be specified in a UTC time format.
 * <p>
 * Developer note: In this implementation all values are recorded as DATE-TIME.
 * This implementation has therefore been modified to only support DATE-TIME.
 * The DATE getter and setter methods read and write java.util.Date values, but
 * the internal storage is always DATE-TIME.
 * <p>
 * The internal DATE field getter and setter methods have been renamed with a
 * 'Xml' suffix.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UntilRecurType", propOrder = {
  "date",
  "dateTime"
})
@XmlRootElement
public class UntilRecurType implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * RFC5545 3.3.4. DATE
   * <p/>
   * Purpose: This value type is used to identify values that contain a calendar
   * date.
   * <p/>
   * Format Definition: This value type is defined by the following notation:
   * <pre>
   * date               = date-value
   * date-value         = date-fullyear date-month date-mday
   * date-fullyear      = 4DIGIT
   * date-month         = 2DIGIT        ;01-12
   * date-mday          = 2DIGIT        ;01-28, 01-29, 01-30, 01-31
   *                                    ;based on month/year
   * </pre> Description: If the property permits, multiple "date" values are
   * specified as a COMMA-separated list of values. The format for the value
   * type is based on the [ISO.8601.2004] complete representation, basic format
   * for a calendar date. The textual format specifies a four-digit year,
   * two-digit month, and two-digit day of the month. There are no separator
   * characters between the year, month, and day component text.
   * <p/>
   * No additional content value encoding (i.e., BACKSLASH character encoding,
   * see Section 3.3.11) is defined for this value type.
   * <p>
   * RFC 6321: 3.3.4 DATE: The date encoding pattern is:
   * <code>pattern-date = xsd:string { pattern = "\d\d\d\d-\d\d-\d\d" }</code>
   * XML Definition: Appendix A # 3.3.4 Example:
   * <date>2011-05-17</date>
   * <p/>
   * @see <a href="http://tools.ietf.org/html/rfc5545#section-3.3.4">Date</a>
   * @see <a href="http://tools.ietf.org/html/rfc6321#section-3.6.4">RELAX NG
   * Schema 3.6.4 DATE</a>
   */
  private static final String PATTERN_DATE = "yyyyMMdd";
  /**
   * RFC 5545 3.3.5. DATE-TIME
   * <p/>
   * Purpose: This value type is used to identify values that specify a precise
   * calendar date and time of day.
   * <p/>
   * Format Definition: This value type is defined by the following notation:
   * <pre>
   * date-time  = date "T" time ;As specified in the DATE and TIME
   *                            ;value definitions
   * </pre> Description: If the property permits, multiple "DATE-TIME" values
   * are specified as a COMMA-separated list of values. No additional content
   * value encoding (i.e., BACKSLASH character encoding, see Section 3.3.11) is
   * defined for this value type.
   * <p/>
   * The "DATE-TIME" value type is used to identify values that contain a
   * precise calendar date and time of day. The format is based on the
   * [ISO.8601.2004] complete representation, basic format for a calendar date
   * and time of day. The text format is a concatenation of the "date", followed
   * by the LATIN CAPITAL LETTER T character, the time designator, followed by
   * the "time" format.
   * <p/>
   * The "DATE-TIME" value type expresses time values in three forms:
   * <p/>
   * The form of date and time with UTC offset MUST NOT be used. For example,
   * the following is not valid for a DATE-TIME value:
   * <p/>
   * 19980119T230000-0800 ;Invalid time format
   * <p/>
   * FORM #1: DATE WITH LOCAL TIME <em>NOT SUPPORTED</em>
   * <p/>
   * FORM #2: DATE WITH UTC TIME
   * <p/>
   * The date with UTC time, or absolute time, is identified by a LATIN CAPITAL
   * LETTER Z suffix character, the UTC designator, appended to the time value.
   * <p>
   * RFC 6321: 3.3.5 DATE-TIME: The date-time encoding pattern is:
   * <code>pattern-date-time = xsd:string { pattern = "\d\d\d\d-\d\d-\d\dT\d\d:\d\d:\d\dZ?" }</code>
   * XML Definition: Appendix A # 3.3.5 Example:
   * <date-time>2011-05-17T12:00:00</date-time>
   * <p/>
   * The "TZID" property parameter MUST NOT be applied to DATE-TIME properties
   * whose time values are specified in UTC.
   * <p/>
   * FORM #3: DATE WITH LOCAL TIME AND TIME ZONE REFERENCE <em>NOT
   * SUPPORTED</em>
   * <p/>
   * @see <a
   * href="http://tools.ietf.org/html/rfc5545#section-3.3.5">Date-Time</a>
   * @see <a href="http://tools.ietf.org/html/rfc6321#section-3.6.5">RELAX NG
   * Schema 3.6.5 DATE-TIME</a>
   */
  private static final String PATTERN_DATE_TIME = "yyyy-MM-dd'T'HH:mm:ss'Z'";
  /**
   * RFC 2445 UTC date time pattern.
   * <p>
   * This pattern is to be used only when printing to String. The PATTERN_DATE
   * and PATTERN_DATE_TIME are to be used when marshaling to XML.
   * <p>
   * @see RFC 6321
   */
  public static final String PATTERN_UTC = "yyyyMMdd'T'HHmmss'Z'";
  /**
   * Coordinated Universal Time.
   * <p>
   * Used to normalize all calendar instances to UTC. e.g.
   * 2000-03-04T23:00:00+03:00 normalizes to 2000-03-04T20:00:00Z. Implements
   * W3C XML Schema Part 2, Section 3.2.7.3 (A)
   */
  public static final java.util.TimeZone TIMEZONE_UTC = java.util.TimeZone.getTimeZone("UTC");

  /**
   * xsd:date — Gregorian calendar date
   * <p/>
   * This datatype is modeled after the calendar dates defined in Chapter 5.2.1
   * of ISO (International Organization for Standardization) 8601. Its value
   * space is the set of Gregorian calendar dates as defined by this standard;
   * i.e., a one-day-long period of time. Its lexical space is the ISO 8601
   * extended format: <code>[-]CCYY-MM-DD[Z|(+|-)hh:mm]</code> with an optional
   * time zone. Time zones that aren't specified are considered undetermined.
   * <p/>
   * Restrictions
   * <p/>
   * The basic format of ISO 8601 calendar dates, CCYYMMDD, isn't supported.
   * <p/>
   * The other forms of dates available in ISO 8601 aren't supported: ordinal
   * dates defined by the year, the number of the day in the year, dates
   * identified by calendar week, and day numbers.
   * <p/>
   * As the value space is defined by reference to ISO 8601, there is no support
   * for any calendar system other than Gregorian. Because the lexical space is
   * also defined using a reference to ISO 8601, there is no support for any
   * localization such as different orders for date parts or named months.
   * <p/>
   * The order relation between dates with and without time zone is partial:
   * they can be compared beyond a +/- 14 hour interval.
   * <p/>
   * There is a difference between ISO 8601, which defines a day as a 24-hour
   * period of time, and the W3C XML Schema, which indicates that a date is a
   * "one-day-long, non-periodic instance ... independent of how many hours this
   * day has." Even though technically correct, some days don't last exactly 24
   * hours because of leap seconds; this definition doesn't concur with the
   * definition of xsd:duration that states that a day is always exactly 24
   * hours long. Example
   * <p/>
   * Valid values include: 2001-10-26, 2001-10-26+02:00, 2001-10-26Z,
   * 2001-10-26+00:00, -2001-10-26, or -20000-04-01.
   * <p/>
   * The following values would be invalid: 2001-10 (all the parts must be
   * specified), 2001-10-32 (the days part—32—is out of range), 2001-13-26+02:00
   * (the month part—13—is out of range), or 01-10-26 (the century part is
   * missing).
   * <p/>
   * @see <a
   * href="http://books.xmlschemata.org/relaxng/ch19-77041.html">xsd:date</a>
   */
  @XmlElement
  @XmlJavaTypeAdapter(type = XMLGregorianCalendar.class, value = XmlAdapterXCalDate.class)
  protected XMLGregorianCalendar date;
  /**
   * xsd:dateTime — Instant of time (Gregorian calendar)
   * <p/>
   * This datatype describes instances identified by the combination of a date
   * and a time. Its value space is described as a combination of date and time
   * of day in Chapter 5.4 of ISO 8601. Its lexical space is the extended
   * format: <code>[-]CCYY-MM-DDThh:mm:ss[Z|(+|-)hh:mm]</code> The time zone may
   * be specified as Z (UTC) or (+|-)hh:mm. Time zones that aren't specified are
   * considered undetermined.
   * <p/>
   * Restrictions
   * <p/>
   * The basic format of ISO 8601 calendar datetimes, CCYYMMDDThhmmss, isn't
   * supported.
   * <p/>
   * The other forms of date-times available in ISO 8601—ordinal dates defined
   * by the year, the number of the day in the year, dates identified by
   * calendar week, and day numbers—aren't supported.
   * <p/>
   * As the value space is defined by reference to ISO 8601, there is no support
   * for any calendar system other than Gregorian. As the lexical space is also
   * defined in reference to ISO 8601, there is no support for any localization
   * such as different orders for date parts or named months.
   * <p/>
   * The order relation between date-times with and without time zone is
   * partial: they can be compared only outside of a +/- 14 hours interval.
   * Example
   * <p/>
   * Valid values for xsd:dateTime include: 2001-10-26T21:32:52,
   * 2001-10-26T21:32:52+02:00, 2001-10-26T19:32:52Z, 2001-10-26T19:32:52+00:00,
   * -2001-10-26T21:32:52, or 2001-10-26T21:32:52.12679.
   * <p/>
   * The following values are invalid: 2001-10-26 (all the parts must be
   * specified), 2001-10-26T21:32 (all the parts must be specified),
   * 2001-10-26T25:32:52+02:00 (the hours part—25—is out of range), or
   * 01-10-26T21:32 (all the parts must be specified).
   * <p/>
   * @see <a
   * href="http://books.xmlschemata.org/relaxng/ch19-77049.html">xsd:dateTime</a>
   * <p/>
   */
  @XmlElement(name = "date-time")
  @XmlJavaTypeAdapter(type = XMLGregorianCalendar.class, value = XmlAdapterXCalDateTime.class)
  protected XMLGregorianCalendar dateTime;

  public UntilRecurType() {
  }

  public UntilRecurType(GregorianCalendar dateTime) throws DatatypeConfigurationException {
    this.dateTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTime).normalize();
  }

  public UntilRecurType(Calendar dateTime) throws DatatypeConfigurationException {
    setDateTime((GregorianCalendar) dateTime);
  }

  public UntilRecurType(java.util.Date dateTime) throws DatatypeConfigurationException {
    dateTime(dateTime);
  }

  /**
   * Construct an UntilRecurType from a string. Three formats are supported: RFC
   * 2445 UTC standard "yyyyMMdd'T'HHmmss'Z'", RFC 5545 DATE-TIME
   * "yyyy-MM-dd'T'HH:mm:ss'Z'" or RFC 5545 DATE "yyyyMMdd"
   * <p/>
   * @param untilString an encoded date time string
   * @throws DatatypeConfigurationException if the parsed date is not valid.
   * @throws ParseException                 if the string cannot be parsed into
   *                                        a Date
   */
  public UntilRecurType(String untilString) throws DatatypeConfigurationException, ParseException {
    if (untilString == null || untilString.isEmpty()) {
      throw new IllegalArgumentException("Cannot parse a null or empty string.");
    }
    if (PATTERN_UTC.length() - 4 == untilString.length()) {
      dateTime(new SimpleDateFormat(PATTERN_UTC).parse(untilString));
    } else if (PATTERN_DATE.length() == untilString.length()) {
      /**
       * Telcordia and Google cannot read DATE patterned UNTIL fields.
       * Accommodate this by always using the date-time field instead. Also, in
       * most all implementations the DTSTART field is always a DATE-TIME.
       */
//      setDate(new SimpleDateFormat(PATTERN_DATE).parse(untilString));
      dateTime(new SimpleDateFormat(PATTERN_DATE).parse(untilString));
    } else if (PATTERN_DATE_TIME.length() - 4 == untilString.length()) {
      dateTime(new SimpleDateFormat(PATTERN_DATE_TIME).parse(untilString));
    } else {
      throw new ParseException("Failed to parse UNTIL date string: " + untilString, 0);
    }
  }

  /**
   * Gets the value of the date property. If the date field is null a new
   * Calendar instance is created and returned, but the internal field will
   * remain unset.
   * <p/>
   * @return a non-null Calendar instance.
   */
  public Calendar getDateXml() {
    return date != null
      ? date.toGregorianCalendar(TIMEZONE_UTC, Locale.ENGLISH, null)
      : Calendar.getInstance(TIMEZONE_UTC);
  }

  /**
   * Sets the value of the date property.
   * <p/>
   * @param calendar the calendar value
   * @throws DatatypeConfigurationException if the calendar cannot be converted
   *                                        to a XMLGregorianCalendar
   */
  public void setDateXml(Calendar calendar) throws DatatypeConfigurationException {
    this.date = DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) calendar).normalize();
  }

  public boolean isSetDateXml() {
    return (this.date != null);
  }

  /**
   * Gets the value of the dateTime property. If the dateTime field is null a
   * new Calendar instance is created and returned, but the internal field will
   * remain unset.
   * <p/>
   * @return a non-null Calendar instance.
   */
  public Calendar getDateTime() {
    return dateTime != null
      ? dateTime.toGregorianCalendar(TIMEZONE_UTC, Locale.ENGLISH, null)
      : Calendar.getInstance(TIMEZONE_UTC);
  }

  /**
   * Sets the value of the dateTime property.
   * <p/>
   * @param calendar the calendar value
   * @throws DatatypeConfigurationException if the calendar cannot be converted
   *                                        to a XMLGregorianCalendar
   */
  public void setDateTime(Calendar calendar) throws DatatypeConfigurationException {
    this.dateTime = DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) calendar).normalize();
  }

  /**
   * Internal helper method to set the UNTIL DateTime using a conventional Date
   * instance.
   * <p/>
   * @param dateTime
   * @throws DatatypeConfigurationException
   */
  private void dateTime(java.util.Date dateTime) throws DatatypeConfigurationException {
    if (dateTime != null) {
      Calendar calendar = Calendar.getInstance(TIMEZONE_UTC);
      calendar.setTime(dateTime);
      setDateTime(calendar);
    }
  }

  public boolean isSetDateTime() {
    return (this.dateTime != null);
  }

  /**
   * Get the DATE-TIME field as a java.util.Date instance.
   * <p>
   * @return a DATE-TIME value
   */
  public Date getDate() {
    return getDateTime().getTime();
  }

  /**
   * Set the DATE-TIME field with a java.util.Date instance.
   * <p>
   * @param date a DATE-TIME value
   */
  public void setDate(Date date) {
    try {
      dateTime(date);
    } catch (DatatypeConfigurationException ex) {
      Logger.getLogger(UntilRecurType.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  /**
   * A convenience method to get either the dateTime or date fields converted to
   * a java.util.Calendar. This method does not care which internal field is
   * populated - it will grab the first available non-null value.
   * <p>
   * Developer note: This method should be used only for GETTING and not for
   * inspection.
   * <p/>
   * @return a Calendar instance populated by EITHER the date or dateTime field.
   */
  public Calendar getCalendar() {
    if (dateTime != null) {
      return dateTime.toGregorianCalendar(TIMEZONE_UTC, Locale.ENGLISH, null);
    } else if (date != null) {
      return date.toGregorianCalendar(TIMEZONE_UTC, Locale.ENGLISH, null);
    }
    return null;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 67 * hash + Objects.hashCode(this.date);
    hash = 67 * hash + Objects.hashCode(this.dateTime);
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
    final UntilRecurType other = (UntilRecurType) obj;
    if (!Objects.equals(this.date, other.date)) {
      return false;
    }
    return Objects.equals(this.dateTime, other.dateTime);
  }

  /**
   * Returns whether this Calendar represents a time before the time represented
   * by the specified Object. This method is equivalent to:
   * <p>
   * @param when the Object to be compared
   * @return true if the time of this Calendar is before the time represented by
   *         when; false otherwise.
   */
  public boolean before(Calendar when) {
    return date != null ? getDateXml().before(when) : getDateTime().before(when);
  }

  /**
   * Returns whether this Calendar represents a time after the time represented
   * by the specified Object.
   * <p>
   * @param when the Object to be compared
   * @return true if the time of this Calendar is after the time represented by
   *         when; false otherwise.
   */
  public boolean after(Calendar when) {
    return date != null ? getDateXml().after(when) : getDateTime().after(when);
  }

  /**
   * Print both the dateTime and date fields.
   * <p/>
   * @return
   */
  public String toStringFull() {
    return "UntilRecurType"
      + " dateTime [" + dateTime
      + "] date [" + date
      + ']';
  }

  /**
   * @return an encoded date time string of the format 'yyyyMMdd'T'HHmmss'Z''
   */
  @Override
  public String toString() {
    DateFormat sdf;
    if (dateTime != null) {
      sdf = new SimpleDateFormat(PATTERN_DATE_TIME);
      return getCalendar() != null ? sdf.format(getCalendar().getTime()) : null;
    } else if (date != null) {
      sdf = new SimpleDateFormat(PATTERN_DATE);
      return getCalendar() != null ? sdf.format(getCalendar().getTime()) : null;
    } else {
      return null;
    }
  }
}