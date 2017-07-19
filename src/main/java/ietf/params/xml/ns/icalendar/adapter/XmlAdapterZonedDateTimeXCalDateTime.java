/*
 * Copyright 2016 Key Bridge LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ietf.params.xml.ns.icalendar.adapter;

import java.time.DateTimeException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Java XML adapter to translate between the W3C xsd:date-time format and the
 * RelaxNG date-time format specified within the RFC 6321 (xCal) specification.
 * <p>
 * Patterns for date/time, duration, and UTC offset values are given because
 * those differ from the values used in iCalendar. More restrictive schema with
 * patterns and numerical limits could be derived from the example schema here
 * if more comprehensive schema validation is required.
 * <p>
 * RELAX NG Schema for iCalendar in XML
 * <p>
 * default namespace = "urn:ietf:params:xml:ns:icalendar-2.0"
 * <p>
 * 3.3.5 DATE-TIME pattern-date-time = xsd:string { pattern =
 * "\d\d\d\d-\d\d-\d\dT\d\d:\d\d:\d\dZ?" }
 *
 * @author Jesse Caulfield
 */
public class XmlAdapterZonedDateTimeXCalDateTime extends XmlAdapter<String, ZonedDateTime> {

  /**
   * Unmarshal a string representing date-time with a time-zone in the ISO-8601
   * calendar system into a java.time.ZonedDateTime instance, such as
   * 2007-12-03T10:15:30+01:00[Europe/Paris]
   * <p>
   * This method is extremely forgiving of the input pattern and accepts any
   * xsd:date-time — Instant of time (Gregorian calendar) formatted input string
   * representation.
   * <p>
   * This datatype describes instances identified by the combination of a date
   * and a time. Its value space is described as a combination of date and time
   * of day in Chapter 5.4 of ISO 8601. Its lexical space is the extended
   * format: <code>[-]CCYY-MM-DDThh:mm:ss[Z|(+|-)hh:mm]</code> The time zone may
   * be specified as Z (UTC) or (+|-)hh:mm. Time zones that aren't specified are
   * considered undetermined.
   * <p>
   * Restrictions
   * <p>
   * The basic format of ISO 8601 calendar datetimes, CCYYMMDDThhmmss, isn't
   * supported.
   * <p>
   * The other forms of date-times available in ISO 8601—ordinal dates defined
   * by the year, the number of the day in the year, dates identified by
   * calendar week, and day numbers—aren't supported.
   * <p>
   * As the value space is defined by reference to ISO 8601, there is no support
   * for any calendar system other than Gregorian. As the lexical space is also
   * defined in reference to ISO 8601, there is no support for any localization
   * such as different orders for date parts or named months.
   * <p>
   * The order relation between date-times with and without time zone is
   * partial: they can be compared only outside of a +/- 14 hours interval.
   * Example
   * <p>
   * Valid values for xsd:dateTime include: 2001-10-26T21:32:52,
   * 2001-10-26T21:32:52+02:00, 2001-10-26T19:32:52Z, 2001-10-26T19:32:52+00:00,
   * -2001-10-26T21:32:52, or 2001-10-26T21:32:52.12679.
   * <p>
   * The following values are invalid: 2001-10-26 (all the parts must be
   * specified), 2001-10-26T21:32 (all the parts must be specified),
   * 2001-10-26T25:32:52+02:00 (the hours part—25—is out of range), or
   * 01-10-26T21:32 (all the parts must be specified).
   * <p>
   * From RFC 5545 3.3.12: Fractions of a second are not supported by this
   * format.
   *
   * @see <a
   * href="http://books.xmlschemata.org/relaxng/ch19-77049.html">xsd:date-time</a>
   *
   * @param v The ISO-8601 dateTime string
   * @return a ZonedDateTime instance
   * @throws DateTimeParseException if the text cannot be parsed
   */
  @Override
  public ZonedDateTime unmarshal(String v) throws DateTimeParseException {
    if (v == null || v.isEmpty()) {
      return null;
    }
    return ZonedDateTime.parse(v);
  }

  /**
   * Marshal a ZonedDateTime instance into the xCal DATE format. This differs
   * from the xsd:date implementation with a more restrictive output pattern:
   * <p>
   * <code>pattern = "\d\d\d\d-\d\d-\d\dT\d\d:\d\d:\d\d([+-]\d\d:\d\d)?(\[[A-Za-z/]\])?"</code>
   * <p>
   * An example output value is: 2007-12-03T10:15:30+01:00[Europe/Paris]
   *
   * @param v the ZonedDateTime instance
   * @return a patterned date string, null if the input dateTime is null
   * @throws DateTimeException if an error occurs during printing
   */
  @Override
  public String marshal(ZonedDateTime v) throws DateTimeException {
    if (v == null) {
      return null;
    }
    return v.toString();
  }
}