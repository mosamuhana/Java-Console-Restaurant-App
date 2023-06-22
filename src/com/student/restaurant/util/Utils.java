// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Utils {

  public static Object[][] createRowDetails(Object[] row, String[] header) {
    List<Object[]> list = new ArrayList<>();
    for (int i = 0; i < header.length; i++) {
      list.add(new Object[]{header[i], row[i]});
    }
    return list.toArray(Object[][]::new);
  }

  public static <T> int getListMax(List<T> list, Function<T, Integer> selector) {
    int max = 0;
    if (list != null) {
      for (var item : list) {
        max = Math.max(max, selector.apply(item));
      }
    }
    return max;
  }

  public static int clamp(int value, Integer min, Integer max) {
    if (min == null && max == null) {
      return value;
    } else if (min != null && max == null) {
      return Math.max(min, value);
    } else if (min == null && max != null) {
      return Math.min(max, value);
    } else {
      // 5 <= v <= 10
      return Math.max(min, Math.min(max, value));
    }
  }

  public static double clamp(double value, Double min, Double max) {
    if (min == null && max == null) {
      return value;
    } else if (min != null && max == null) {
      return Math.max(min, value);
    } else if (min == null && max != null) {
      return Math.min(max, value);
    } else {
      return Math.max(min, Math.min(max, value));
    }
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
