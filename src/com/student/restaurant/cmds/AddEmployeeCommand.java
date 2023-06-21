// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.cmds;

import com.student.restaurant.util.TableBuilder;
import com.student.restaurant.Constants;
import com.student.restaurant.services.EmployeeService;
import com.student.restaurant.util.Console;

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

    var name = Console.enterString("Enter Employee Name: ", 3);
    var phone = Console.enterString("Enter Employee Phone: ", 0);
    var address = Console.enterString("Enter Employee Address: ", 0);
    var gender = Console.selectInteger("Enter Gender [1. Male | 2. Female]: ", new Integer[]{1, 2});
    var basicSalary = Console.enterDouble("Enter Employee basicSalary: ", 1.0, null);
    var numWorkYears = Console.enterInteger("Enter Employee numWorkYears: ", 0, 40);
    var shift = Console.selectInteger("Enter Shift [1. Day | 2. Night]: ", new Integer[]{1, 2});

    phone = phone == null || phone.isEmpty() ? null : phone;
    address = address == null || address.isEmpty() ? null : address;

    EmployeeService.add(name, phone, gender, address, basicSalary, numWorkYears, shift);
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
