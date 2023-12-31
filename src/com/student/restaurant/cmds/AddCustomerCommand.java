// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.cmds;

import com.student.restaurant.util.TableBuilder;
import com.student.restaurant.Constants;
import com.student.restaurant.services.CustomerService;
import com.student.restaurant.util.Console;

public class AddCustomerCommand extends Command {

  public AddCustomerCommand(Command parent) {
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

      if (!Console.yesNoQuestion("Do you want to add another customer ?", false)) {
        return;
      }
    }
  }

  private void create() throws Exception {
    TableBuilder.printRectText("New Customer " + Constants.QUIT_HINT);

    var name = Console.enterString("  Customer Name [3-40]: ", 40, x -> x.length() > 3);
    var phone = Console.enterString("  Customer Phone [0-12]: ", 12);

    CustomerService.add(name, phone);
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
