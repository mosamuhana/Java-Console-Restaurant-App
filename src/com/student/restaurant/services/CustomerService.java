// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.services;

import com.student.restaurant.models.*;
import com.student.restaurant.util.Console;
import com.student.restaurant.util.TableBuilder;
import com.student.restaurant.util.Utils;
import java.util.List;

public final class CustomerService {

  private CustomerService() {
  }

  //****************************************************************************
  // Data Helper
  //****************************************************************************
  public static List<Customer> getAll() {
    return DataService.customers;
  }

  public static Customer get(int id) {
    return Person.find(DataService.customers, id);
  }

  public static boolean delete(int id) {
    var customer = get(id);
    if (customer == null) {
      return false;
    }

    DataService.customers.remove(customer);

    DataService.save();

    return true;
  }

  public static Customer add(String name, String phone) {
    var customer = new Customer(DataService.getNextCustomerId(), name, phone, 0);
    DataService.customers.add(customer);
    DataService.save();
    return customer;
  }

  //****************************************************************************
  // Console Helper
  //****************************************************************************
  private final static String[] header = new String[]{"Id", "Name", "Phone", "Orders"};

  public static void print(Customer x) {
    TableBuilder.create()
      .data(Utils.createRowDetails(getRow(x), header))
      .caption("Customer Details")
      .emptyText("")
      .print();
  }

  public static void printList(List<Customer> list, String caption) {
    var rows = list.stream()
      .map((x) -> getRow(x))
      .toArray(Object[][]::new);

    var tb = TableBuilder.create()
      .data(rows)
      .header(header)
      .emptyText("No Records");

    if (caption != null) {
      tb.caption(caption);
    }

    //tb.summary("Rows: " + rows.length);
    tb.print();
  }

  public static Customer select() throws Exception {
    var list = getAll();
    printList(list, "Customers");
    var keys = list.stream().map((x) -> x.getId()).toArray(Integer[]::new);
    var id = Console.selectInteger("Select Customer: ", keys);
    if (id == null) {
      return null;
    }
    return get(id);
  }

  private static Object[] getRow(Customer x) {
    return new Object[]{x.getId(), x.getName(), x.getPhone(), x.getNumOrders()};
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
