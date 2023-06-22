// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.cmds;

import com.student.restaurant.Constants;
import com.student.restaurant.util.TableBuilder;
import com.student.restaurant.util.Console;
import java.util.Arrays;

public class MainMenuCommand extends Command {

  @Override
  public void run() {
    try {
      tryRun();
    } catch (Exception e) {
    }
  }

  private void tryRun() throws Exception {
    var rows = new String[][]{
      {"1", "Add Worker"},
      {"2", "Add Customer"},
      {"3", "Add Order"},
      {"4", "Delete Order"},
      {"5", "Display Employees"},
      {"6", "Display Restaurant Revenue"},
      {"7", "Display Customer Orders"},
      {"8", "Display Salaries"},
      {"9", "Display Report"},
      {"10", "Save data"}
    };

    var keys = Arrays.stream(rows).map((row) -> row[0]).toList();

    TableBuilder.create().data(rows)
      .caption("MAIN MENU")
      .summary(Constants.QUIT_HINT)
      .print();

    var result = Console.selectString("Enter Your Choice: ", keys);

    switch (result) {
      case "1" -> {
        (new AddWorkerCommand(this)).run();
        break;
      }
      case "2" -> {
        (new AddCustomerCommand(this)).run();
        break;
      }
      case "3" -> {
        (new AddOrderCommand(this)).run();
        break;
      }
      case "4" -> {
        (new DeleteOrderCommand(this)).run();
        break;
      }
      case "5" -> {
        (new DisplayEmployeesCommand(this)).run();
        break;
      }
      case "6" -> {
        (new DisplayRestaurantRevenueCommand(this)).run();
        break;
      }
      case "7" -> {
        (new DisplayCustomerOrdersCommand(this)).run();
        break;
      }
      case "8" -> {
        (new DisplaySalariesCommand(this)).run();
        break;
      }
      case "9" -> {
        (new DisplayReportCommand(this)).run();
        break;
      }
      case "10" -> {
        (new SaveDataCommand(this)).run();
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
