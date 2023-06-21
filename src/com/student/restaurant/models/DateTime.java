// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.models;

import java.time.LocalDateTime;
import java.time.Month;

public class DateTime {

  private int _year;
  private int _month;
  private int _day;
  private int _hour;
  private int _minute;
  private int _second;

  public DateTime(LocalDateTime d) {
    _year = d.getYear();
    _month = d.getMonthValue();
    _day = d.getDayOfMonth();
    _hour = d.getHour();
    _minute = d.getMinute();
    _second = d.getSecond();
  }

  public DateTime() {
    this(LocalDateTime.now());
  }

  public DateTime(int year, int month, int day, int hour, int minute, int second) {
    setYear(year);
    setMonth(month);
    setDay(day);
    setHour(hour);
    setMinute(minute);
    setSecond(second);
  }

  public DateTime(DateTime o) {
    this(o.getYear(), o.getMonth(), o.getDay(), o.getHour(), o.getMinute(), o.getSecond());
  }

  public DateTime copy() {
    return new DateTime(this);
  }

  public int getYear() {
    return _year;
  }

  public final void setYear(int v) {
    if (v < 0) {
      throw new Error("year must be positive or zero");
    }
    _year = v;
  }

  public int getMonth() {
    return _month;
  }

  public final void setMonth(int v) {
    if (v < 1 || v > 12) {
      throw new Error("month must be between 1 and 12");
    }
    _month = v;
  }

  public int getDay() {
    return _day;
  }

  public final void setDay(int v) {
    if (v < 1 || v > 31) {
      throw new Error("day must be between 1 and 31");
    }
    _day = v;
  }

  public int getHour() {
    return _hour;
  }

  public final void setHour(int v) {
    if (v < 0 || v > 23) {
      throw new Error("hour must be between 0 and 23");
    }
    _hour = v;
  }

  public int getMinute() {
    return _minute;
  }

  public final void setMinute(int v) {
    if (v < 0 || v > 59) {
      throw new Error("minute must be between 0 and 59");
    }
    _minute = v;
  }

  public int getSecond() {
    return _second;
  }

  public final void setSecond(int v) {
    if (v < 0 || v > 59) {
      throw new Error("second must be between 0 and 59");
    }
    _second = v;
  }

  public static DateTime parse(String str) {
    if (str != null) {
      try {
        var d = LocalDateTime.parse(str);
        if (d != null) {
          return new DateTime(d);
        }
      } catch (Exception e) {
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return LocalDateTime.of(_year, _month, _day, _hour, _minute, _second).toString();
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
