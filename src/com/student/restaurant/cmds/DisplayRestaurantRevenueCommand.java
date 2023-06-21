// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.cmds;

import com.student.restaurant.services.OrderService;
import com.student.restaurant.util.Console;
import com.student.restaurant.util.TableBuilder;

public class DisplayRestaurantRevenueCommand extends Command {

  public DisplayRestaurantRevenueCommand(Command parent) {
    super(parent);
  }

  @Override
  public void run() {
    var orders = OrderService.getAll();

    double sum = 0.0;
    for (var order : orders) {
      sum += order.getPrice();
    }

    TableBuilder.printRectText("SUMMATION OF ORDERS PRICE: " + sum);
    Console.pause();

    back();
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
