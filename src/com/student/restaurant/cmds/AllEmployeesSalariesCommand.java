// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.cmds;

import com.student.restaurant.services.EmployeeService;
import com.student.restaurant.util.Console;

public class AllEmployeesSalariesCommand extends Command {

  public AllEmployeesSalariesCommand(Command parent) {
    super(parent);
  }

  @Override
  public void run() {
    EmployeeService.printList(EmployeeService.getAll(), "Employee Salaries");
    Console.pause();

    back();
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
