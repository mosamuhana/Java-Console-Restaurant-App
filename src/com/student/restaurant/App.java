// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant;

import com.student.restaurant.cmds.MainMenuCommand;
import com.student.restaurant.services.DataService;
import com.student.restaurant.util.Console;

public class App {

  public static void main(String[] args) {
    (new MainMenuCommand()).run();
  }

  public static void exit() {
    DataService.save();
    Console.close();
    System.exit(0);
  }
}

// Name: Malak Mosa Muhana  |  University ID: 2320223469
