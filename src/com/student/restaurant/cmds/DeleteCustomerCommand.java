package com.student.restaurant.cmds;

import com.student.restaurant.services.CustomerService;
import com.student.restaurant.util.Console;

public class DeleteCustomerCommand extends Command {

  public DeleteCustomerCommand(Command prevCmd) {
    super(prevCmd);
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
      var ok = Console.yesNoQuestion("Do you want to delete Customer #" + customer.getId(), false);

      if (ok) {
        CustomerService.delete(customer.getId());
      }
    }
  }
}
