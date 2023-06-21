// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.cmds;

import com.student.restaurant.Constants;
import com.student.restaurant.util.Console;
import com.student.restaurant.util.TableBuilder;
import java.util.Arrays;

public class AddWorkerCommand extends Command {

  public AddWorkerCommand(Command parent) {
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
      {"1", "Add Manager"},
      {"2", "Add Employee"},};

    TableBuilder.create()
      .data(rows)
      .caption("ADD WORKER")
      .summary(Constants.QUIT_HINT)
      .print();

    var keys = Arrays.stream(rows).map((row) -> row[0]).toList();
    var result = Console.selectString("Enter Your Choice: ", keys);

    switch (result) {
      case "1" -> {
        (new AddManagerCommand(this)).run();
        break;
      }
      case "2" -> {
        (new AddEmployeeCommand(this)).run();
        break;
      }
    }
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
