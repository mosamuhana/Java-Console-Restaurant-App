// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.cmds;

import com.student.restaurant.services.ManagerService;
import com.student.restaurant.util.Console;

public class ManagerSalaryCommand extends Command {

  public ManagerSalaryCommand(Command parent) {
    super(parent);
  }

  @Override
  public void run() {
    ManagerService.print();

    Console.pause();

    back();
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
