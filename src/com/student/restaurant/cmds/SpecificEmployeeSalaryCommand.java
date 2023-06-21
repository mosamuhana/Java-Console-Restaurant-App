// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.cmds;

import com.student.restaurant.services.EmployeeService;
import com.student.restaurant.util.Console;

public class SpecificEmployeeSalaryCommand extends Command {

  public SpecificEmployeeSalaryCommand(Command parent) {
    super(parent);
  }

  @Override
  public void run() {
    try {
      tryRun();
    } catch (Exception e) {
    }

    back();
  }

  private void tryRun() throws Exception {
    var emp = EmployeeService.select();

    if (emp != null) {
      EmployeeService.print(emp);
      Console.pause();
    }
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
