// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.util;

import com.student.restaurant.App;
import com.student.restaurant.Constants;
import java.util.*;

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
    System.out.println(Constants.PRESS_ANY_KEY);
    scanner.nextLine();
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
  public static double enterDouble(String message, Double min, Double max) throws Exception {
    while (true) {
      var line = nextLine(message);
      try {
        var n = Double.parseDouble(line);
        var m = Utils.clamp(n, min, max);
        if (m != n) {
          return n;
        }
      } catch (NumberFormatException e) {
      }
    }
  }

  public static double enterDouble(String message) throws Exception {
    return enterDouble(message, null, null);
  }

  // ###################################################
  public static int enterInteger(String message, Integer min, Integer max) throws Exception {
    while (true) {
      var line = nextLine(message);
      try {
        var n = Integer.parseInt(line);
        var m = Utils.clamp(n, min, max);
        if (m != n) {
          return n;
        }
      } catch (NumberFormatException e) {
      }
    }
  }

  public static int enterInteger(String message) throws Exception {
    return enterInteger(message, null, null);
  }

  // ###################################################
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

  public static String enterPhone(String message, boolean nullable) throws Exception {
    if (nullable) {
      return enterString(message, 0);
    } else {
      return enterString(message, 7);
    }
    /*
    while (true) {
      var line = nextLine(message);
      if (line.matches("\\d{10}")) {
        return line;
      }
    }
     */
  }

  // ###################################################
  private static String nextLine(String message) throws Exception {
    return nextLine(message, true);
  }

  private static String nextLine(String message, boolean allowQuit) throws Exception {
    System.out.print(message);
    //while (!scanner.hasNextLine()) {scanner.next();}
    var line = scanner.nextLine().trim();

    if (allowQuit) {
      if (Utils.isExitCmd(line)) {
        App.exit();
      }
      if (Utils.isQuitCmd(line)) {
        //throw SpecialCmd.QuitException();
        throw new Exception("QUIT");
      }
    }

    return line;
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
