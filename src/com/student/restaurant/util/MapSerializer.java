// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.util;

import com.student.restaurant.models.DateTime;
import java.util.HashMap;
import java.util.Map;

public class MapSerializer {

  private Map<String, Object> map = new HashMap<>();

  public MapSerializer() {
  }

  public MapSerializer(Map<String, Object> map) {
    this.map = map;
  }

  public Integer getInteger(String key) {
    var value = map.get(key);
    if (value == null) {
      return null;
    }

    if (value.getClass() == Double.class) {
      return ((Double) value).intValue();
    }

    return (int) value;
  }

  public void setInteger(String key, Integer value) {
    if (value == null) {
      map.put(key, null);
    } else {
      map.put(key, (int) value);
    }
  }

  public Long getLong(String key) {
    var value = map.get(key);
    if (value == null) {
      return null;
    }
    return (long) value;
  }

  public void setLong(String key, Long value) {
    if (value == null) {
      map.put(key, null);
    } else {
      map.put(key, (long) value);
    }
  }

  public Double getDouble(String key) {
    var value = map.get(key);
    if (value == null) {
      return null;
    }
    return (double) value;
  }

  public void setDouble(String key, Double value) {
    if (value == null) {
      map.put(key, null);
    } else {
      map.put(key, (double) value);
    }
  }

  public String getString(String key) {
    var value = map.get(key);
    if (value == null) {
      return null;
    }
    return (String) value;
  }

  public void setString(String key, String value) {
    if (value == null) {
      map.put(key, null);
    } else {
      map.put(key, value);
    }
  }

  public DateTime getDateTime(String key) {
    var value = getString(key);
    if (value != null) {
      return DateTime.parse(key);
    }
    return null;
  }

  public void setDateTime(String key, DateTime v) {
    setString(key, v == null ? null : v.toString());
  }

  public void clear() {
    map.clear();
  }

  public Map<String, Object> getMap() {
    return map;
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
