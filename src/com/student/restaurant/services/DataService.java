// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.services;

import com.student.restaurant.models.*;
import java.util.*;
import java.io.*;

public final class DataService {

  private static final String FILE_NAME = "data.dat";

  private static int _nextEmployeeId = 0;
  private static int _nextCustomerId = 0;
  private static int _nextOrderId = 0;

  public static final List<Manager> managers = new ArrayList<>();
  public static final List<Employee> employees = new ArrayList<>();
  public static final List<Customer> customers = new ArrayList<>();
  public static final List<Order> orders = new ArrayList<>();

  static {
    load();
  }

  private DataService() {
  }

  public static int getNextEmployeeId() {
    return ++_nextEmployeeId;
  }

  public static int getNextCustomerId() {
    return ++_nextCustomerId;
  }

  public static int getNextOrderId() {
    return ++_nextOrderId;
  }

  public static void load() {
    managers.clear();
    managers.clear();
    managers.clear();
    managers.clear();
    _nextEmployeeId = 0;
    _nextCustomerId = 0;
    _nextOrderId = 0;

    Map<String, Object> data;
    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
      data = (Map<String, Object>) inputStream.readObject();
    } catch (Exception e) {
      return;
    }

    getListValue(data, "managers").forEach((x) -> managers.add(Manager.fromMap(x)));

    getListValue(data, "employees").forEach(map -> {
      var item = Employee.fromMap(map);
      employees.add(item);
      _nextEmployeeId = Math.max(_nextEmployeeId, item.getId());
    });
    getListValue(data, "customers").forEach(map -> {
      var item = Customer.fromMap(map);
      customers.add(item);
      _nextCustomerId = Math.max(_nextCustomerId, item.getId());
    });
    getListValue(data, "orders").forEach(map -> {
      var item = Order.fromMap(map);
      orders.add(item);
      _nextOrderId = Math.max(_nextOrderId, item.getId());
    });
  }

  public static boolean save() {
    var data = new HashMap<String, Object>();

    data.put("managers", managers.stream().map((e) -> e.toMap()).toList());
    data.put("employees", employees.stream().map((e) -> e.toMap()).toList());
    data.put("customers", customers.stream().map((e) -> e.toMap()).toList());
    data.put("orders", orders.stream().map((e) -> e.toMap()).toList());

    try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
      outputStream.writeObject(data);
      //System.out.println("Records saved successfully.");
      return true;
    } catch (IOException e) {
    }
    return false;
  }

  private static List<Map<String, Object>> getListValue(Map<String, Object> data, String key) {
    if (data == null || !data.containsKey(key)) {
      return new ArrayList<>();
    }

    return (List<Map<String, Object>>) data.get(key);
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
