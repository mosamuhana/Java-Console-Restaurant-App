// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.cmds;

import com.student.restaurant.util.TableBuilder;
import com.student.restaurant.Constants;
import com.student.restaurant.services.ManagerService;
import com.student.restaurant.util.Console;

public class AddManagerCommand extends Command {

  public AddManagerCommand(Command parent) {
    super(parent);
  }

  @Override
  public void run() {
    try {
      create();
    } catch (Exception e) {
    }

    back();
  }

  public void create() throws Exception {
    TableBuilder.printRectText("Create Manager " + Constants.QUIT_HINT);

    var name = Console.enterString("Enter Manager Name: ", 3);
    var phone = Console.enterString("Enter Manager Phone: ", 0);
    var address = Console.enterString("Enter Manager Address: ", 0);
    var basicSalary = Console.enterDouble("Enter Manager Basic Salary: ", 1.0, null);
    var bonus = Console.enterInteger("Enter Manager Bonus: ", 0, 500);
    var gender = Console.selectInteger("Enter Gender [1. Male | 2. Female]: ", new Integer[]{1, 2});

    phone = phone.isEmpty() ? null : phone;
    address = address.isEmpty() ? null : address;

    ManagerService.add(name, phone, gender, address, basicSalary, bonus);

    back();
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
