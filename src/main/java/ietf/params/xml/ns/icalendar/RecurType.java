package ietf.params.xml.ns.icalendar;

import java.io.Serializable;
import java.util.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Recurrence Rule (RFC5545 section 3.3.10)
 * <p>
 * Value Name: RECUR
 * <p>
 * This value type is used to identify properties that contain a recurrence rule
 * specification.
 * <p>
 * <p>
 * This value type is a structured value consisting of a list of one or more
 * recurrence grammar parts. Each rule part is defined by a NAME=VALUE pair. The
 * rule parts are separated from each other by the SEMICOLON character. The rule
 * parts are not ordered in any particular sequence. Individual rule parts MUST
 * only be specified once. Compliant applications MUST accept rule parts ordered
 * in any sequence, but to ensure backward compatibility with applications that
 * pre-date this revision of iCalendar the FREQ rule part MUST be the first rule
 * part specified in a RECUR value.
 * <p>
 * This value type is a structured value consisting of a list of one or more
 * recurrence grammar parts. Each rule part is defined by a NAME=VALUE pair. The
 * rule parts are separated from each other by the SEMICOLON character. The rule
 * parts are not ordered in any particular sequence. Individual rule parts MUST
 * only be specified once. Compliant applications MUST accept rule parts ordered
 * in any sequence, but to ensure backward compatibility with applications that
 * pre-date this revision of iCalendar the FREQ rule part MUST be the first rule
 * part specified in a RECUR value.
 * <p>
 * Recurrence rules may generate recurrence instances with an invalid date
 * (e.g., February 30) or nonexistent local time (e.g., 1:30 AM on a day where
 * the local time is moved forward by an hour at 1:00 AM). Such recurrence
 * instances MUST be ignored and MUST NOT be counted as part of the recurrence
 * set.
 * <p>
 * Information, not contained in the rule, necessary to determine the various
 * recurrence instance start time and dates are derived from the Start Time
 * ("DTSTART") component attribute. For example, "FREQ=YEARLY;BYMONTH=1" doesn't
 * specify a specific day within the month or a time. This information would be
 * the same as what is specified for "DTSTART".
 * <p>
 * BYxxx rule parts modify the recurrence in some manner. BYxxx rule parts for a
 * period of time that is the same or greater than the frequency generally
 * reduce or limit the number of occurrences of the recurrence generated. For
 * example, "FREQ=DAILY;BYMONTH=1" reduces the number of recurrence instances
 * from all days (if BYMONTH rule part is not present) to all days in January.
 * BYxxx rule parts for a period of time less than the frequency generally
 * increase or expand the number of occurrences of the recurrence. For example,
 * "FREQ=YEARLY;BYMONTH=1,2" increases the number of days within the yearly
 * recurrence set from 1 (if BYMONTH rule part is not present) to 2.
 * <p>
 * This value type is used to identify properties that contain a recurrence rule
 * specification.
 * <p>
 * The FREQ rule part is REQUIRED, but MUST NOT occur more than once.
 * <p/>
 * The UNTIL or COUNT rule parts are OPTIONAL, but they MUST NOT occur in the
 * same 'recur'.
 * <p/>
 * The other rule parts are OPTIONAL, but MUST NOT occur more than once.
 * <p>
 * If observance is known to have an effective end date, the "UNTIL" recurrence
 * rule parameter MUST be used to specify the last valid onset of this
 * observance (i.e., the UNTIL DATE-TIME will be equal to the last instance
 * generated by the recurrence pattern). It MUST be specified in UTC time.
 * <p>
 * The "DTSTART" and the "TZOFFSETFROM" properties MUST be used when generating
 * the onset DATE-TIME values (instances) from the "RRULE".
 * <p>
 * @see <a href="http://tools.ietf.org/html/rfc5545#section-3.3.10">Recurrence
 * Rule</a>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecurType", propOrder = {
  "freq",
  "until",
  "count",
  "interval",
  "bysecond",
  "byminute",
  "byhour",
  "byday",
  "byyearday",
  "bymonthday",
  "byweekno",
  "bymonth",
  "bysetpos",
  "wkst"
})
@SuppressWarnings("ProtectedField")
public class RecurType implements Serializable {

  private static final long serialVersionUID = 1L;

  private static final String FREQ = "FREQ";
  private static final String UNTIL = "UNTIL";
  private static final String COUNT = "COUNT";
  private static final String INTERVAL = "INTERVAL";
  private static final String BYSECOND = "BYSECOND";
  private static final String BYMINUTE = "BYMINUTE";
  private static final String BYHOUR = "BYHOUR";
  private static final String BYDAY = "BYDAY";
  private static final String BYMONTHDAY = "BYMONTHDAY";
  private static final String BYYEARDAY = "BYYEARDAY";
  private static final String BYWEEKNO = "BYWEEKNO";
  private static final String BYMONTH = "BYMONTH";
  private static final String BYSETPOS = "BYSETPOS";
  private static final String WKST = "WKST";
  /**
   * The FREQ rule part is REQUIRED, but MUST NOT occur more than once.
   * <p>
   * The FREQ rule part identifies the type of recurrence rule. This rule part
   * MUST be specified in the recurrence rule. Valid values include SECONDLY, to
   * specify repeating events based on an interval of a second or more;
   * MINUTELY, to specify repeating events based on an interval of a minute or
   * more; HOURLY, to specify repeating events based on an interval of an hour
   * or more; DAILY, to specify repeating events based on an interval of a day
   * or more; WEEKLY, to specify repeating events based on an interval of a week
   * or more; MONTHLY, to specify repeating events based on an interval of a
   * month or more; and YEARLY, to specify repeating events based on an interval
   * of a year or more.
   * <p/>
   * type-freq = element freq { "SECONDLY" | "MINUTELY" | "HOURLY" | "DAILY" |
   * "WEEKLY" | "MONTHLY" | "YEARLY" }
   */
  @XmlElement(required = true)
  protected EFreqRecurType freq;
  /**
   * The UNTIL or COUNT rule parts are OPTIONAL, but they MUST NOT occur in the
   * same 'recur'.
   * <p>
   * The UNTIL rule part defines a DATE or DATE-TIME value that bounds the
   * recurrence rule in an inclusive manner. If the value specified by UNTIL is
   * synchronized with the specified recurrence, this DATE or DATE-TIME becomes
   * the last instance of the recurrence. The value of the UNTIL rule part MUST
   * have the same value type as the "DTSTART" property. Furthermore, if the
   * "DTSTART" property is specified as a date with local time, then the UNTIL
   * rule part MUST also be specified as a date with local time. If the
   * "DTSTART" property is specified as a date with UTC time or a date with
   * local time and time zone reference, then the UNTIL rule part MUST be
   * specified as a date with UTC time. In the case of the "STANDARD" and
   * "DAYLIGHT" sub-components the UNTIL rule part MUST always be specified as a
   * date with UTC time. If specified as a DATE-TIME value, then it MUST be
   * specified in a UTC time format. If not present, and the COUNT rule part is
   * also not present, the "RRULE" is considered to repeat forever.
   * <p/>
   * type-until = element until { type-date | type-date-time }
   */
  protected UntilRecurType until;
  /**
   * The UNTIL or COUNT rule parts are OPTIONAL, but they MUST NOT occur in the
   * same 'recur'.
   * <p>
   * The COUNT rule part defines the number of occurrences at which to
   * range-bound the recurrence. The "DTSTART" property value always counts as
   * the first occurrence.
   * <p/>
   * type-count = element count { xsd:positiveInteger }
   */
  protected Integer count;
  /**
   * The INTERVAL rule part contains a positive integer representing at which
   * intervals the recurrence rule repeats. The default value is "1", meaning
   * every second for a SECONDLY rule, every minute for a MINUTELY rule, every
   * hour for an HOURLY rule, every day for a DAILY rule, every week for a
   * WEEKLY rule, every month for a MONTHLY rule, and every year for a YEARLY
   * rule. For example, within a DAILY rule, a value of "8" means every eight
   * days.
   * <p>
   * element interval { xsd:positiveInteger }
   */
  protected Integer interval;
  /**
   * The BYSECOND rule part specifies a COMMA-separated list of seconds within a
   * minute. Valid values are 0 to 60.
   * <p>
   * The BYSECOND, BYMINUTE and BYHOUR rule parts MUST NOT be specified when the
   * associated "DTSTART" property has a DATE value type. These rule parts MUST
   * be ignored in RECUR value that violate the above requirement
   * <p>
   * type-bysecond = element bysecond { xsd:positiveInteger }
   */
  protected List<Integer> bysecond;
  /**
   * The BYMINUTE rule part specifies a COMMA-separated list of minutes within
   * an hour. Valid values are 0 to 59.
   * <p>
   * The BYSECOND, BYMINUTE and BYHOUR rule parts MUST NOT be specified when the
   * associated "DTSTART" property has a DATE value type. These rule parts MUST
   * be ignored in RECUR value that violate the above requirement
   * <p>
   * type-byminute = element byminute { xsd:positiveInteger }
   */
  protected List<Integer> byminute;
  /**
   * The BYHOUR rule part specifies a COMMA- separated list of hours of the day.
   * Valid values are 0 to 23.
   * <p>
   * The BYSECOND, BYMINUTE and BYHOUR rule parts MUST NOT be specified when the
   * associated "DTSTART" property has a DATE value type. These rule parts MUST
   * be ignored in RECUR value that violate the above requirement
   * <p>
   * type-byhour = element byhour { xsd:positiveInteger }
   */
  protected List<Integer> byhour;
  /**
   * The BYDAY rule part specifies a COMMA-separated list of days of the week;
   * SU indicates Sunday; MO indicates Monday; TU indicates Tuesday; WE
   * indicates Wednesday; TH indicates Thursday; FR indicates Friday; and SA
   * indicates Saturday.
   * <p>
   * Each BYDAY value can also be preceded by a positive (+n) or negative (-n)
   * integer. If present, this indicates the nth occurrence of a specific day
   * within the MONTHLY or YEARLY "RRULE".
   * <p>
   * For example, within a MONTHLY rule, +1MO (or simply 1MO) represents the
   * first Monday within the month, whereas -1MO represents the last Monday of
   * the month. The numeric value in a BYDAY rule part with the FREQ rule part
   * set to YEARLY corresponds to an offset within the month when the BYMONTH
   * rule part is present, and corresponds to an offset within the year when the
   * BYWEEKNO or BYMONTH rule parts are present. If an integer modifier is not
   * present, it means all days of this type within the specified frequency. For
   * example, within a MONTHLY rule, MO represents all Mondays within the month.
   * The BYDAY rule part MUST NOT be specified with a numeric value when the
   * FREQ rule part is not set to MONTHLY or YEARLY. Furthermore, the BYDAY rule
   * part MUST NOT be specified with a numeric value with the FREQ rule part set
   * to YEARLY when the BYWEEKNO rule part is specified.
   * <p>
   * type-byday = element byday { xsd:integer?, type-weekday }
   */
  protected List<EWeekdayRecurType> byday;
  /**
   * The BYMONTHDAY rule part specifies a COMMA-separated list of days of the
   * month. Valid values are 1 to 31 or -31 to -1. For example, -10 represents
   * the tenth to the last day of the month. The BYMONTHDAY rule part MUST NOT
   * be specified when the FREQ rule part is set to WEEKLY.
   * <p>
   * type-bymonthday = element bymonthday { xsd:integer } [-31,31]
   */
  @XmlElement(type = Integer.class)
  protected List<Integer> bymonthday;
  /**
   * The BYYEARDAY rule part specifies a COMMA-separated list of days of the
   * year. Valid values are 1 to 366 or -366 to -1. For example, -1 represents
   * the last day of the year (December 31st) and -306 represents the 306th to
   * the last day of the year (March 1st). The BYYEARDAY rule part MUST NOT be
   * specified when the FREQ rule part is set to DAILY, WEEKLY, or MONTHLY.
   * type-byyearday = element byyearday { xsd:integer }
   */
  protected List<Integer> byyearday;
  /**
   * The BYWEEKNO rule part specifies a COMMA-separated list of ordinals
   * specifying weeks of the year. Valid values are 1 to 53 or -53 to -1. This
   * corresponds to weeks according to week numbering as defined in
   * [ISO.8601.2004]. A week is defined as a seven day period, starting on the
   * day of the week defined to be the week start (see WKST). Week number one of
   * the calendar year is the first week that contains at least four (4) days in
   * that calendar year. This rule part MUST NOT be used when the FREQ rule part
   * is set to anything other than YEARLY. For example, 3 represents the third
   * week of the year.
   * <p>
   * Note: Assuming a Monday week start, week 53 can only occur when Thursday is
   * January 1 or if it is a leap year and Wednesday is January 1.
   * <p>
   * type-byweekno = element byweekno { xsd:integer }
   */
  protected List<Integer> byweekno;
  /**
   * The BYMONTH rule part specifies a COMMA-separated list of months of the
   * year. Valid values are 1 to 12.
   * <p>
   * type-bymonth = element bymonth { xsd:positiveInteger } [1,12]
   */
  @XmlElement(type = Integer.class)
  protected List<Integer> bymonth;
  /**
   * The BYSETPOS rule part specifies a COMMA-separated list of values that
   * corresponds to the nth occurrence within the set of recurrence instances
   * specified by the rule. BYSETPOS operates on a set of recurrence instances
   * in one interval of the recurrence rule. For example, in a WEEKLY rule, the
   * interval would be one week A set of recurrence instances starts at the
   * beginning of the interval defined by the FREQ rule part. Valid values are 1
   * to 366 or -366 to -1. It MUST only be used in conjunction with another
   * BYxxx rule part. For example "the last work day of the month" could be
   * represented as:
   * <p>
   * FREQ=MONTHLY;BYDAY=MO,TU,WE,TH,FR;BYSETPOS=-1
   * <p>
   * Each BYSETPOS value can include a positive (+n) or negative (-n) integer.
   * If present, this indicates the nth occurrence of the specific occurrence
   * within the set of occurrences specified by the rule.
   * <p>
   * type-bysetpos = element bysetpos { xsd:integer }
   */
  protected List<Integer> bysetpos;
  /**
   * The WKST rule part specifies the day on which the workweek starts. Valid
   * values are MO, TU, WE, TH, FR, SA, and SU. This is significant when a
   * WEEKLY "RRULE" has an interval greater than 1, and a BYDAY rule part is
   * specified. This is also significant when in a YEARLY "RRULE" when a
   * BYWEEKNO rule part is specified. The default value is MO.
   * <p>
   * type-weekday = ( "SU" | "MO" | "TU" | "WE" | "TH" | "FR" | "SA" )
   */
  protected EWeekdayRecurType wkst;

  public RecurType() {
  }

  /**
   * Construct a new RecurType instance from an iCalendar-compliant RECUR
   * String.
   * <p/>
   * This method is forked from the iCal4j Recur class.
   * <p/>
   * @param aValue an iCalendar RECUR String representation of a recurrence.
   * @throws Exception if the specified string contains an invalid
   *                   representation of an UNTIL date value or otherwise cannot
   *                   be parsed
   */
  public RecurType(final String aValue) throws Exception {
    final StringTokenizer tokenizer = new StringTokenizer(aValue, ";=");
    while (tokenizer.hasMoreTokens()) {
      final String token = tokenizer.nextToken();
      switch (token) {
        case FREQ:
          freq = EFreqRecurType.fromValue(nextToken(tokenizer, token));
          break;
        case UNTIL:
          until = new UntilRecurType(nextToken(tokenizer, token));
          break;
        case COUNT:
          count = Integer.parseInt(nextToken(tokenizer, token));
          break;
        case INTERVAL:
          interval = Integer.parseInt(nextToken(tokenizer, token));
          break;
        case BYSECOND:
          bysecond = listParseInteger(nextToken(tokenizer, token));
          break;
        case BYMINUTE:
          byminute = listParseInteger(nextToken(tokenizer, token));
          break;
        case BYHOUR:
          byhour = listParseInteger(nextToken(tokenizer, token));
          break;
        case BYDAY:
          byday = listParseWeekday(nextToken(tokenizer, token));
          break;
        case BYMONTHDAY:
          bymonthday = listParseInteger(nextToken(tokenizer, token));
          break;
        case BYYEARDAY:
          byyearday = listParseInteger(nextToken(tokenizer, token));
          break;
        case BYWEEKNO:
          byweekno = listParseInteger(nextToken(tokenizer, token));
          break;
        case BYMONTH:
          bymonth = listParseInteger(nextToken(tokenizer, token));
          break;
        case BYSETPOS:
          bysetpos = listParseInteger(nextToken(tokenizer, token));
          break;
        case WKST:
          wkst = EWeekdayRecurType.valueOf(nextToken(tokenizer, token));
          break;
      }
    }
    /**
     * Validate the Frequency.
     */
    if (freq == null) {
      throw new IllegalArgumentException("A recurrence rule MUST contain a FREQ rule part.");
    }
  }

  /**
   * Internal tokenizer method supporting the String constructor.
   * <p/>
   * @param t         a StringTokenizer instance
   * @param lastToken the last token
   * @return the next token
   */
  private String nextToken(StringTokenizer t, String lastToken) {
    try {
      return t.nextToken();
    } catch (NoSuchElementException e) {
      throw new IllegalArgumentException("Missing expected token, last token: " + lastToken);
    }
  }

  /**
   * Gets the value of the freq property.
   * <p/>
   * @return possible object is {@link EFreqRecurType }
   *
   */
  public EFreqRecurType getFreq() {
    return freq;
  }

  /**
   * Sets the value of the freq property.
   * <p/>
   * @param value allowed object is {@link EFreqRecurType }
   *
   */
  public void setFreq(EFreqRecurType value) {
    this.freq = value;
  }

  public boolean isSetFreq() {
    return (this.freq != null);
  }

  /**
   * Gets the value of the until property.
   * <p>
   * This getter ALWAYS returns a non-null instance. Call isSetUntil first to
   * determine if this field is set.
   * <p/>
   * @return a non-null instance of {@link UntilRecurType }.
   */
  public UntilRecurType getUntil() {
    if (until == null) {
      until = new UntilRecurType();
    }
    return until;
  }

  /**
   * Sets the value of the until property.
   * <p/>
   * The UNTIL or COUNT rule parts are OPTIONAL, but they MUST NOT occur in the
   * same 'recur'. Therefore, if the input value is not null the COUNT field is
   * set to null.
   * <p/>
   * @param value allowed object is {@link UntilRecurType }
   */
  public void setUntil(UntilRecurType value) {
    this.until = value;
    if (value != null) {
      this.count = null;
    }
  }

  /**
   * Convenience indicator that the internal UNTIL parameter is not null;
   * <p>
   * @return TRUE if the UNTIL field is not null.
   */
  public boolean isSetUntil() {
    return (this.until != null);
  }

  /**
   * Helper method to get the UNTIL value as a DATE.
   * <p>
   * @return the UNTIL date value.
   */
  public Date getUntilDate() {
    return getUntil().getDate();
  }

  /**
   * Helper method to set the UNTIL value as a DATE.
   * <p>
   * The UNTIL or COUNT rule parts are OPTIONAL, but they MUST NOT occur in the
   * same 'recur'.
   * <p>
   * Input values less than 1 are silently ignored.
   * <p>
   * Therefore, on success (if the input value is not null) the COUNT field is
   * set to null.
   * <p>
   * @param until the UNTIL date value.
   */
  public void setUntilDate(Date until) {
    getUntil().setDate(until);
    this.count = null;
  }

  /**
   * Gets the value of the count property.
   * <p/>
   * @return possible object is {@link Integer }
   *
   */
  public Integer getCount() {
    return count;
  }

  /**
   * Sets the value of the count property.
   * <p/>
   * The UNTIL or COUNT rule parts are OPTIONAL, but they MUST NOT occur in the
   * same 'recur'.
   * <p>
   * Input values less than 1 are silently ignored.
   * <p>
   * Therefore, on success (if the input value is not null and greater than
   * zero) the UNTIL field is set to null.
   * <p>
   * @param value allowed object is {@link Integer }
   *
   */
  public void setCount(Integer value) {
    if (value > 0) {
      this.count = value;
      if (count != null) {
        this.until = null;
      }
    }
  }

  /**
   * Convenience indicator that the internal COUNT parameter is not null;
   * <p>
   * @return TRUE if the count is not null.
   */
  public boolean isSetCount() {
    return (this.count != null);
  }

  /**
   * Gets the value of the interval property.
   * <p/>
   * @return possible object is {@link String }
   *
   */
  public Integer getInterval() {
    return interval;
  }

  /**
   * Sets the value of the interval property.
   * <p/>
   * @param value allowed object is {@link String }
   *
   */
  public void setInterval(Integer value) {
    this.interval = value;
  }

  public boolean isSetInterval() {
    return (this.interval != null);
  }

  /**
   * Gets the value of the bysecond property.
   * <p/>
   * @return a non-null ArrayList
   */
  public List<Integer> getBysecond() {
    if (bysecond == null) {
      bysecond = new ArrayList<>();
    }
    return this.bysecond;
  }

  public void setBysecond(List<Integer> bysecond) {
    this.bysecond = bysecond;
  }

  public boolean isSetBysecond() {
    return ((this.bysecond != null) && (!this.bysecond.isEmpty()));
  }

  public void unsetBysecond() {
    this.bysecond = null;
  }

  /**
   * Gets the value of the byminute property.
   * <p/>
   * @return a non-null ArrayList
   */
  public List<Integer> getByminute() {
    if (byminute == null) {
      byminute = new ArrayList<>();
    }
    return this.byminute;
  }

  public void setByminute(List<Integer> byminute) {
    this.byminute = byminute;
  }

  public boolean isSetByminute() {
    return ((this.byminute != null) && (!this.byminute.isEmpty()));
  }

  public void unsetByminute() {
    this.byminute = null;
  }

  /**
   * Gets the value of the byhour property.
   * <p/>
   * @return a non-null ArrayList
   */
  public List<Integer> getByhour() {
    if (byhour == null) {
      byhour = new ArrayList<>();
    }
    return this.byhour;
  }

  public void setByhour(List<Integer> byhour) {
    this.byhour = byhour;
  }

  public boolean isSetByhour() {
    return ((this.byhour != null) && (!this.byhour.isEmpty()));
  }

  public void unsetByhour() {
    this.byhour = null;
  }

  /**
   * Gets the value of the byday property: a list of days.
   * <p/>
   * Recommend using the methods addByDay and removeByDay to manipulate this
   * list.
   * <p>
   * @return a non-null ArrayList
   */
  public List<EWeekdayRecurType> getByday() {
    if (byday == null) {
      byday = new ArrayList<>();
    }
    return this.byday;
  }

  public void setByday(List<EWeekdayRecurType> byday) {
    this.byday = byday;
  }

  public boolean isSetByday() {
    return ((this.byday != null) && (!this.byday.isEmpty()));
  }

  public void unsetByday() {
    this.byday = null;
  }

  public void addByDay(EWeekdayRecurType weekday) {
    if (!getByday().contains(weekday)) {
      getByday().add(weekday);
    }
  }

  public void removeByDay(EWeekdayRecurType weekday) {
    getByday().remove(weekday);
  }

  /**
   * Gets the value of the byyearday property.
   * <p/>
   * @return a non-null ArrayList
   */
  public List<Integer> getByyearday() {
    if (byyearday == null) {
      byyearday = new ArrayList<>();
    }
    return this.byyearday;
  }

  public void setByyearday(List<Integer> byyearday) {
    this.byyearday = byyearday;
  }

  public boolean isSetByyearday() {
    return ((this.byyearday != null) && (!this.byyearday.isEmpty()));
  }

  public void unsetByyearday() {
    this.byyearday = null;
  }

  /**
   * Gets the value of the bymonthday property.
   * <p/>
   * @return a non-null ArrayList
   */
  public List<Integer> getBymonthday() {
    if (bymonthday == null) {
      bymonthday = new ArrayList<>();
    }
    return this.bymonthday;
  }

  public void setBymonthday(List<Integer> bymonthday) {
    this.bymonthday = bymonthday;
  }

  public boolean isSetBymonthday() {
    return ((this.bymonthday != null) && (!this.bymonthday.isEmpty()));
  }

  public void unsetBymonthday() {
    this.bymonthday = null;
  }

  /**
   * Gets the value of the byweekno property.
   * <p/>
   * @return a non-null ArrayList
   */
  public List<Integer> getByweekno() {
    if (byweekno == null) {
      byweekno = new ArrayList<>();
    }
    return this.byweekno;
  }

  public void setByweekno(List<Integer> byweekno) {
    this.byweekno = byweekno;
  }

  public boolean isSetByweekno() {
    return ((this.byweekno != null) && (!this.byweekno.isEmpty()));
  }

  public void unsetByweekno() {
    this.byweekno = null;
  }

  /**
   * Gets the value of the bymonth property.
   * <p/>
   * @return a non-null ArrayList
   */
  public List<Integer> getBymonth() {
    if (bymonth == null) {
      bymonth = new ArrayList<>();
    }
    return this.bymonth;
  }

  public void setBymonth(List<Integer> bymonth) {
    this.bymonth = bymonth;
  }

  public boolean isSetBymonth() {
    return ((this.bymonth != null) && (!this.bymonth.isEmpty()));
  }

  public void unsetBymonth() {
    this.bymonth = null;
  }

  /**
   * Gets the value of the bysetpos property.
   * <p/>
   * @return a non-null ArrayList
   */
  public List<Integer> getBysetpos() {
    if (bysetpos == null) {
      bysetpos = new ArrayList<>();
    }
    return this.bysetpos;
  }

  public void setBysetpos(List<Integer> bysetpos) {
    this.bysetpos = bysetpos;
  }

  /**
   * Inspect the bysetpos list and determine if it is null or empty.
   * <p>
   * @return TRUE if bysetpos is not null and not empty
   */
  public boolean isSetBysetpos() {
    return ((this.bysetpos != null) && (!this.bysetpos.isEmpty()));
  }

  public void unsetBysetpos() {
    this.bysetpos = null;
  }

  /**
   * Gets the value of the wkst property.
   * <p/>
   * @return possible object is {@link EWeekdayRecurType }
   *
   */
  public EWeekdayRecurType getWkst() {
    return wkst;
  }

  /**
   * Sets the value of the wkst property.
   * <p/>
   * @param value allowed object is {@link EWeekdayRecurType }
   *
   */
  public void setWkst(EWeekdayRecurType value) {
    this.wkst = value;
  }

  public boolean isSetWkst() {
    return (this.wkst != null);
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 31 * hash + (this.freq != null ? this.freq.hashCode() : 0);
    hash = 31 * hash + Objects.hashCode(this.until);
    hash = 31 * hash + Objects.hashCode(this.count);
    hash = 31 * hash + Objects.hashCode(this.interval);
    hash = 31 * hash + Objects.hashCode(this.bysecond);
    hash = 31 * hash + Objects.hashCode(this.byminute);
    hash = 31 * hash + Objects.hashCode(this.byhour);
    hash = 31 * hash + Objects.hashCode(this.byday);
    hash = 31 * hash + Objects.hashCode(this.byyearday);
    hash = 31 * hash + Objects.hashCode(this.bymonthday);
    hash = 31 * hash + Objects.hashCode(this.byweekno);
    hash = 31 * hash + Objects.hashCode(this.bymonth);
    hash = 31 * hash + Objects.hashCode(this.bysetpos);
    hash = 31 * hash + (this.wkst != null ? this.wkst.hashCode() : 0);
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
    final RecurType other = (RecurType) obj;
    return this.hashCode() == obj.hashCode();
  }

  /**
   * Print all of this RecurType configuration fields.
   * <p/>
   * @return
   */
  public String toStringFull() {
    return "RecurType"
      + " freq [" + freq
      + "] until [" + until
      + "] count [" + count
      + "] interval [" + interval
      + "] bysecond [" + bysecond
      + "] byminute [" + byminute
      + "] byhour [" + byhour
      + "] byday [" + byday
      + "] byyearday [" + byyearday
      + "] bymonthday [" + bymonthday
      + "] byweekno [" + byweekno
      + "] bymonth [" + bymonth
      + "] bysetpos [" + bysetpos
      + "] wkst [" + wkst
      + ']';
  }

  /**
   * Print this RecurType object instance as a properly formatted RECUR string.
   * <p/>
   * This method is forked from the iCal4j Recur class.
   * <p/>
   * @return an iCalendar-compliant RECUR string.
   */
  @Override
  public final String toString() {
    final StringBuffer b = new StringBuffer();
    b.append(FREQ);
    b.append('=');
    b.append(freq);
    if (wkst != null) {
      b.append(';');
      b.append(WKST);
      b.append('=');
      b.append(wkst);
    }
    if (until != null) {
      b.append(';');
      b.append(UNTIL);
      b.append('=');
      b.append(until);
    }
    if (count != null && count >= 1) {
      b.append(';');
      b.append(COUNT);
      b.append('=');
      b.append(count);
    }
    if (interval != null && interval >= 1) {
      b.append(';');
      b.append(INTERVAL);
      b.append('=');
      b.append(interval);
    }
    if (isSetBymonth()) {
      b.append(';');
      b.append(BYMONTH);
      b.append('=');
      b.append(listFormat(bymonth));
    }
    if (isSetByweekno()) {
      b.append(';');
      b.append(BYWEEKNO);
      b.append('=');
      b.append(listFormat(byweekno));
    }
    if (isSetByyearday()) {
      b.append(';');
      b.append(BYYEARDAY);
      b.append('=');
      b.append(listFormat(byyearday));
    }
    if (isSetBymonthday()) {
      b.append(';');
      b.append(BYMONTHDAY);
      b.append('=');
      b.append(listFormat(bymonthday));
    }
    if (isSetByday()) {
      b.append(';');
      b.append(BYDAY);
      b.append('=');
      b.append(listFormat(byday));
    }
    if (isSetByhour()) {
      b.append(';');
      b.append(BYHOUR);
      b.append('=');
      b.append(listFormat(byhour));
    }
    if (isSetByminute()) {
      b.append(';');
      b.append(BYMINUTE);
      b.append('=');
      b.append(listFormat(byminute));
    }
    if (isSetBysecond()) {
      b.append(';');
      b.append(BYSECOND);
      b.append('=');
      b.append(listFormat(bysecond));
    }
    if (isSetBysetpos()) {
      b.append(';');
      b.append(BYSETPOS);
      b.append('=');
      b.append(listFormat(bysetpos));
    }
    return b.toString();
  }

  //<editor-fold defaultstate="collapsed" desc="List Tokenizer Support Methods">
  /**
   * Format a list of objects (expect Integer and String) into a concatenated
   * comma-delimited String. {@inheritDoc}
   */
  private String listFormat(List<?> aList) {
    final StringBuffer b = new StringBuffer();
    for (final Iterator i = aList.iterator(); i.hasNext();) {
      b.append(i.next());
      if (i.hasNext()) {
        b.append(',');
      }
    }
    return b.toString();
  }

  /**
   * Parse a comma-delimited String into a list of Integers.
   * <p/>
   * @param aString              a string representation of a number list
   * @param minValue             the minimum allowable value
   * @param maxValue             the maximum allowable value
   * @param allowsNegativeValues indicates whether negative values are allowed
   */
  private List<Integer> listParseInteger(String aString) {
    List<Integer> list = new ArrayList<>();
    final StringTokenizer t = new StringTokenizer(aString, ",");
    while (t.hasMoreTokens()) {
      list.add(Integer.valueOf(t.nextToken()));
    }
    return list;
  }

  /**
   * Parse a comma-delimited String into a list of Strings.
   * <p/>
   * @param aString              a string representation of a number list
   * @param minValue             the minimum allowable value
   * @param maxValue             the maximum allowable value
   * @param allowsNegativeValues indicates whether negative values are allowed
   */
  private List<String> listParseString(String aString) {
    List<String> list = new ArrayList<>();
    final StringTokenizer t = new StringTokenizer(aString, ",");
    while (t.hasMoreTokens()) {
      list.add(t.nextToken());
    }
    return list;
  }

  /**
   * Parse a comma-delimited String into a list of enumerated Weekday types.
   * <p/>
   * @param aString a string representation of a number list
   */
  private List<EWeekdayRecurType> listParseWeekday(String aString) {
    List<EWeekdayRecurType> list = new ArrayList<>();
    final StringTokenizer t = new StringTokenizer(aString, ",");
    while (t.hasMoreTokens()) {
      try {
        list.add(EWeekdayRecurType.valueOf(t.nextToken()));
      } catch (Exception e) {
      }
    }
    return list;
  }

//</editor-fold>
}