// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.cmds;

import com.student.restaurant.util.TableBuilder;
import com.student.restaurant.services.CustomerService;
import com.student.restaurant.services.OrderService;
import com.student.restaurant.util.Console;

public class AddOrderCommand extends Command {

  public AddOrderCommand(Command parent) {
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
    var customer = CustomerService.select();
    if (customer != null) {
      while (true) {
        create(customer.getId());
        if (!Console.yesNoQuestion("Do you want to add another order ?", false)) {
          return;
        }
      }
    }
  }

  private void create(int customerId) throws Exception {
    TableBuilder.printRectText("New Order");

    var type = Console.selectInteger("Enter Order Type [1. Local | 2. Delivery]: ", new Integer[]{1, 2});
    var price = Console.enterDouble("Enter price: ", 0d, null);

    OrderService.add(customerId, type, price);
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
