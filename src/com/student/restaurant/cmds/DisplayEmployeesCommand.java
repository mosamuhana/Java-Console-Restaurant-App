// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.cmds;

import com.student.restaurant.Constants;
import com.student.restaurant.util.Console;
import com.student.restaurant.util.TableBuilder;
import java.util.Arrays;

public class DisplayEmployeesCommand extends Command {

  public DisplayEmployeesCommand(Command parent) {
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
      {"1", "Day Shift Employees"},
      {"2", "Night Shift Employees"},
      {"3", "All Employees"}
    };

    TableBuilder.create()
      .data(rows)
      .caption("MANAGE EMPLOYEES")
      .summary(Constants.QUIT_HINT)
      .print();

    var keys = Arrays.stream(rows).map((row) -> row[0]).toList();
    var result = Console.selectString("Enter Your Choice: ", keys);

    switch (result) {
      case "1" -> {
        (new DayShiftEmployeesCommand(this)).run();
        break;
      }
      case "2" -> {
        (new NightShiftEmployeesCommand(this)).run();
        break;
      }
      // Back to the main menu
      case "3" -> {
        (new AllEmployeesCommand(this)).run();
        break;
      }
      case "Q" -> {
        break;
      }
      // Exit
      case "X" -> {
        (new ExitCommand()).run();
        break;
      }
    }
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
