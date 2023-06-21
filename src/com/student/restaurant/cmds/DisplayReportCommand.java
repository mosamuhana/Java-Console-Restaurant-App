// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.cmds;

import com.student.restaurant.services.CustomerService;
import com.student.restaurant.services.EmployeeService;
import com.student.restaurant.services.ManagerService;
import com.student.restaurant.services.OrderService;
import com.student.restaurant.util.Console;

public class DisplayReportCommand extends Command {

  public DisplayReportCommand(Command parent) {
    super(parent);
  }

  @Override
  public void run() {
    ManagerService.printList();
    EmployeeService.printList(EmployeeService.getAll(), "Employees");
    CustomerService.printList(CustomerService.getAll(), "Customers");
    OrderService.printList(OrderService.getAll(), "Orders");

    Console.pause();

    back();
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
