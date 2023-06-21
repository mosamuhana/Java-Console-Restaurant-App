// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.cmds;

import com.student.restaurant.Constants;
import com.student.restaurant.util.Console;
import com.student.restaurant.util.TableBuilder;
import java.util.Arrays;

public class DisplaySalariesCommand extends Command {

  public DisplaySalariesCommand(Command parent) {
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
    var rows = new String[][]{
      {"1", "Manager Salary"},
      {"2", "Specific Employee Salary"},
      {"3", "All Employees Salaries"}};

    TableBuilder.create()
      .data(rows)
      .caption("SALARIES")
      .summary(Constants.QUIT_HINT)
      .print();

    var keys = Arrays.stream(rows).map((row) -> row[0]).toList();
    var result = Console.selectString("Enter Your Choice: ", keys);

    switch (result) {
      case "1" -> {
        (new ManagerSalaryCommand(this)).run();
        break;
      }
      case "2" -> {
        (new SpecificEmployeeSalaryCommand(this)).run();
        break;
      }
      case "3" -> {
        (new AllEmployeesSalariesCommand(this)).run();
        break;
      }
      case "Q" -> {
        break;
      }
      case "X" -> {
        (new ExitCommand()).run();
        break;
      }
    }
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
