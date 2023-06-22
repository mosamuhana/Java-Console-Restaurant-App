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

    var name = Console.enterString("  Manager Name [3-40]: ", 40, x -> x.length() > 3);
    var phone = Console.enterString("  Manager Phone [0-12]: ", 12);
    var address = Console.enterString("  Manager Address [0-100]: ", 100);
    var basicSalary = Console.enterDouble("  Manager Basic Salary [>0]: ", x -> x > 0);
    var bonus = Console.enterInteger("  Manager Bonus [0-500]: ", x -> x >= 0 && x <= 500);
    var gender = Console.selectInteger("  Gender [1. Male | 2. Female]: ", new Integer[]{1, 2});

    phone = phone.isEmpty() ? null : phone;
    address = address.isEmpty() ? null : address;

    ManagerService.add(name, phone, gender, address, basicSalary, bonus);

    back();
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
