// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.cmds;

import com.student.restaurant.services.EmployeeService;
import com.student.restaurant.util.Console;

public class DayShiftEmployeesCommand extends Command {

  public DayShiftEmployeesCommand(Command parent) {
    super(parent);
  }

  @Override
  public void run() {
    var list = EmployeeService.getAll().stream().filter((x) -> x.getShift() == 1).toList();
    EmployeeService.printList(list, "Day Shift Employees");
    Console.pause();

    back();
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
