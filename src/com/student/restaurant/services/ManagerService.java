// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.services;

import com.student.restaurant.models.*;
import com.student.restaurant.util.TableBuilder;
import com.student.restaurant.util.Utils;

public final class ManagerService {

  private ManagerService() {
  }

  //****************************************************************************
  // Data Helper
  //****************************************************************************
  public static Manager get() {
    var managers = DataService.managers;
    if (managers.isEmpty()) {
      return null;
    }
    return managers.get(0);
  }

  public static Manager add(String name, String phone, int gender, String address, double basicSalary, double bonus) {
    var manager = new Manager(0, name, phone, gender, address, basicSalary, bonus);
    DataService.managers.clear();
    DataService.managers.add(manager);
    DataService.save();
    return manager;
  }

  public static boolean delete() {
    DataService.managers.clear();
    DataService.save();
    return true;
  }

  //****************************************************************************
  // Console Helper
  //****************************************************************************
  private final static String[] header = new String[]{"Name", "Gender", "Phone", "Basic Salary", "Salary"};

  public static void print() {
    var manager = get();

    if (manager == null) {
      TableBuilder.printRectText("No Manager exists");
    } else {
      TableBuilder.create()
        .data(Utils.createRowDetails(getRow(manager), header))
        .caption("Manager Details")
        .emptyText("")
        .print();
    }
  }

  public static void printList() {
    var list = DataService.managers;

    var rows = list.stream()
      .map((x) -> getRow(x))
      .toArray(Object[][]::new);

    var tb = TableBuilder.create()
      .data(rows)
      .header(header)
      .emptyText("No Records");

    tb.caption("Manager");

    //tb.summary("Rows: " + rows.length);
    tb.print();
  }

  private static Object[] getRow(Manager x) {
    return new Object[]{x.getName(), x.getGender(), x.getPhone(), x.getBasicSalary(), x.getSalary()};
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
