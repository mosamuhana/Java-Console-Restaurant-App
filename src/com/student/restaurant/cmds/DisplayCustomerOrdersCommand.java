// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.cmds;

import com.student.restaurant.services.CustomerService;
import com.student.restaurant.services.OrderService;
import com.student.restaurant.util.Console;

public class DisplayCustomerOrdersCommand extends Command {

  public DisplayCustomerOrdersCommand(Command parent) {
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
      var orders = OrderService.findCustomerOrders(customer.getId());
      OrderService.printList(orders, "Orders");
      Console.pause();
    }
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
