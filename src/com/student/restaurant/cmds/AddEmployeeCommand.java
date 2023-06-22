// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.cmds;

import com.student.restaurant.util.TableBuilder;
import com.student.restaurant.Constants;
import com.student.restaurant.services.EmployeeService;
import com.student.restaurant.util.Console;
import com.student.restaurant.util.Utils;

public class AddEmployeeCommand extends Command {

  public AddEmployeeCommand(Command parent) {
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
    while (true) {
      create();

      if (!Console.yesNoQuestion("Do you want to add another employee ?", false)) {
        break;
      }
    }
  }

  private void create() throws Exception {
    TableBuilder.printRectText("New Employee " + Constants.QUIT_HINT);

    var name = Console.enterString("  Employee Name [3-40]: ", 40, x -> x.length() > 3);
    var phone = Console.enterString("  Employee Phone [0-12]: ", 12);
    var address = Console.enterString("  Employee Address [0-100]: ", 100);
    var gender = Console.selectInteger("  Gender [1. Male | 2. Female]: ", new Integer[]{1, 2});
    var basicSalary = Console.enterDouble("  Employee Basic Salary [>0]: ", x -> x > 0);
    var numWorkYears = Console.enterInteger("  Employee Work Years [0-50]: ", x -> x >= 0 && x <= 50);
    var shift = Console.selectInteger("  Shift [1. Day | 2. Night]: ", new Integer[]{1, 2});

    phone = phone == null || phone.isEmpty() ? null : phone;
    address = address == null || address.isEmpty() ? null : address;

    EmployeeService.add(name, phone, gender, address, basicSalary, numWorkYears, shift);
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
