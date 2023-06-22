// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.services;

import com.student.restaurant.models.*;
import com.student.restaurant.util.Console;
import com.student.restaurant.util.TableBuilder;
import com.student.restaurant.util.Utils;
import java.util.*;

public final class OrderService {

  //****************************************************************************
  // Data Helper
  //****************************************************************************
  public static List<Order> getAll() {
    return DataService.orders;
  }

  public static Order get(int id) {
    for (var order : DataService.orders) {
      if (order.getId() == id) {
        return order;
      }
    }
    return null;
  }

  public static boolean delete(int id) {
    var order = get(id);
    if (order == null) {
      return false;
    }

    DataService.orders.remove(order);
    DataService.save();

    return true;
  }

  public static Order add(int customerId, int type, double price) {
    var customer = CustomerService.get(customerId);
    if (customer == null) {
      return null;
    }

    var order = new Order(DataService.getNextOrderId(), type, customerId, new DateTime(), price);
    DataService.orders.add(order);
    customer.increaseNumOrders();

    DataService.save();

    return order;
  }

  //****************************************************************************
  // Console Helper
  //****************************************************************************
  private final static String[] header = new String[]{"Id", "Order Type", "Customer Name", "Price"};

  public static void print(Order x) {
    TableBuilder.create()
      .data(Utils.createRowDetails(getRow(x), header))
      .caption("Order Details")
      .emptyText("")
      .print();
  }

  public static void printList(List<Order> list, String caption) {
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

  public static Order select() throws Exception {
    var list = getAll();
    printList(list, "Orders");
    var keys = list.stream().map((x) -> x.getId()).toArray(Integer[]::new);
    var id = Console.selectInteger("Select Order: ", keys);
    if (id == null) {
      return null;
    }
    return get(id);
  }

  private static Object[] getRow(Order x) {
    return new Object[]{x.getId(), x.getType() == 1 ? "Local" : "Delivery", x.getCustomer().getName(), x.getPrice()};
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
