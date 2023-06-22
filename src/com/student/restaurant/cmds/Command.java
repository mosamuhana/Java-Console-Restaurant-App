// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.cmds;

public class Command {

  public final Command prevCmd;

  public Command() {
    this.prevCmd = null;
  }

  public Command(Command parent) {
    this.prevCmd = parent;
  }

  public void run() {

  }

  public void back() {
    if (prevCmd != null) {
      prevCmd.run();
    }
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
