// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.cmds;

import com.student.restaurant.services.OrderService;
import com.student.restaurant.util.Console;

public class DeleteOrderCommand extends Command {

  public DeleteOrderCommand(Command parent) {
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
    var order = OrderService.select();

    if (order != null) {
      var ok = Console.yesNoQuestion("Do you want to delete order #" + order.getId(), false);

      if (ok) {
        order.getCustomer().decreaseNumOrders();
        OrderService.delete(order.getId());
      }
    }
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
