// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.cmds;

import com.student.restaurant.services.DataService;
import com.student.restaurant.util.Console;
import com.student.restaurant.util.TableBuilder;

public class SaveDataCommand extends Command {

  public SaveDataCommand(Command parent) {
    super(parent);
  }

  @Override
  public void run() {
    DataService.save();
    TableBuilder.printRectText("Data saved successfully.");
    Console.pause();

    back();
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
