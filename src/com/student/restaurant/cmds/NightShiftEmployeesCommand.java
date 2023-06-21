// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.cmds;

import com.student.restaurant.services.EmployeeService;
import com.student.restaurant.util.Console;

public class NightShiftEmployeesCommand extends Command {

  public NightShiftEmployeesCommand(Command parent) {
    super(parent);
  }

  @Override
  public void run() {
    var list = EmployeeService.getAll().stream().filter((x) -> x.getShift() == 2).toList();
    EmployeeService.printList(list, "Night Shift Employees");
    Console.pause();

    back();
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
