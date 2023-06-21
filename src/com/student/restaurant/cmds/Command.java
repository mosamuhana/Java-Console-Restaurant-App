// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.cmds;

public class Command {

  public final Command parent;

  public Command() {
    this.parent = null;
  }

  public Command(Command parent) {
    this.parent = parent;
  }

  public void run() {

  }

  public void back() {
    if (parent != null) {
      parent.run();
    }
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
