// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.util;

import com.student.restaurant.App;
import com.student.restaurant.Constants;
import java.util.*;
import java.util.function.Predicate;

public final class Console {

  public static final Scanner scanner;

  static {
    scanner = new Scanner(System.in);
  }

  public static void close() {
    try {
      scanner.close();
    } catch (Exception e) {
    }
  }

  public static void pause() {
    try {
      var line = nextLine("Press Enter to continue or ( press :x to exit )");
      if (line.toLowerCase().startsWith(":x")) {
        App.exit();
      }
    } catch (Exception e) {
    }
  }

  public static boolean yesNoQuestion(String message, boolean defaultYes) throws Exception {
    var choice = defaultYes ? "[Y/n]" : "[y/N]";
    String question = String.format("%s %s: ", message, choice);

    while (true) {
      String line = nextLine(question).toLowerCase();
      if (Constants.QUIT_CMD.equalsIgnoreCase(line)) {
        throw new Exception("Quit Error");
      }

      line = line.charAt(0) + "";
      if (line.isBlank()) {
        line = defaultYes ? "y" : "n";
      } else {
        line = line.charAt(0) + "";
      }

      if ("y".equals(line)) {
        return true;
      } else if ("n".equals(line)) {
        return false;
      }
    }
  }

  // ###################################################
  public static Integer selectInteger(String message, List<Integer> values) throws Exception {
    return selectInteger(message, values.toArray(Integer[]::new));
  }

  public static Integer selectInteger(String message, Integer[] values) throws Exception {
    while (true) {
      var line = nextLine(message);
      try {
        var n = Integer.parseInt(line);
        for (var value : values) {
          if (n == value) {
            return n;
          }
        }
      } catch (NumberFormatException e) {
      }
    }
  }

  // ###################################################
  public static String selectString(String message, String[] values) throws Exception {
    while (true) {
      var line = nextLine(message);
      for (var value : values) {
        if (line.equalsIgnoreCase(value)) {
          return value;
        }
      }
    }
  }

  public static String selectString(String message, List<String> values) throws Exception {
    var arr = values.toArray(String[]::new);
    return selectString(message, arr);
  }

  // ###################################################
  public static double enterDouble(String message, Predicate<Double> validator) throws Exception {
    while (true) {
      var line = nextLine(message);
      try {
        var n = Double.valueOf(line);
        if (validator == null || validator.test(n)) {
          return (double) n;
        }
      } catch (NumberFormatException e) {
      }
    }
  }

  public static int enterInteger(String message, Predicate<Integer> validator) throws Exception {
    while (true) {
      var line = nextLine(message);
      try {
        var n = Integer.valueOf(line);
        if (validator == null || validator.test(n)) {
          return (int) n;
        }
      } catch (NumberFormatException e) {
      }
    }
  }

  // ###################################################
  public static String enterString(String message, Integer maxLength, Predicate<String> validator) throws Exception {
    while (true) {
      var line = nextLine(message);
      if (maxLength == null) {
        if (validator == null || validator.test(line)) {
          return line;
        }
      } else {
        if (validator == null || validator.test(line)) {
          if (line.length() > maxLength) {
            return line.substring(0, maxLength);
          }
          return line;
        }
      }
    }
  }

  public static String enterString(String message, Integer maxLength) throws Exception {
    return enterString(message, maxLength, null);
  }

  public static String enterString(String message) throws Exception {
    return enterString(message, null, null);
  }

  /*
   public static String enterString(String message, Integer min, Integer max) throws Exception {
    while (true) {
      var line = nextLine(message);
      var n = line.length();
      var length = Utils.clamp(n, min, max);
      if (n >= length) {
        return line.substring(0, length);
      }
    }
  }

  public static String enterString(String message, Integer min) throws Exception {
    return enterString(message, min, null);
  }
  public static String enterString(String message) throws Exception {
    return enterString(message, null);
  }
   */
  // ###################################################
  private static String nextLine(String message) throws Exception {
    System.out.print(message);
    //while (!scanner.hasNextLine()) {scanner.next();}
    var line = scanner.nextLine().trim();

    if (line.toLowerCase().startsWith(":x")) {
      App.exit();
    }
    if (line.toLowerCase().startsWith(":q")) {
      //throw SpecialCmd.QuitException(); */
      throw new Exception("QUIT");
    }

    return line;
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
