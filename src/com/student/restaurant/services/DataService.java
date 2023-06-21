// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.services;

import java.util.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.google.gson.GsonBuilder;
import com.student.restaurant.models.*;
import com.student.restaurant.util.Utils;

public final class DataService {

  private static final String FILE_NAME = "data.json";
  private static int _nextEmployeeId = 0;
  private static int _nextCustomerId = 0;
  private static int _nextOrderId = 0;

  public static final List<Manager> managers = new ArrayList<>();
  public static final List<Employee> employees = new ArrayList<>();
  public static final List<Customer> customers = new ArrayList<>();
  public static final List<Order> orders = new ArrayList<>();

  static {
    var data = _load();

    if (data != null) {
      if (data.managers != null) {
        managers.clear();
        for (var item : data.managers) {
          managers.add(Manager.fromMap(item));
        }
      }

      if (data.employees != null) {
        employees.clear();
        for (var item : data.employees) {
          employees.add(Employee.fromMap(item));
        }
      }

      if (data.customers != null) {
        customers.clear();
        for (var item : data.customers) {
          customers.add(Customer.fromMap(item));
        }
      }

      if (data.orders != null) {
        orders.clear();
        for (var item : data.orders) {
          orders.add(Order.fromMap(item));
        }
      }
    }

    _nextEmployeeId = Utils.getListMax(DataService.employees, x -> x.getId());
    _nextCustomerId = Utils.getListMax(DataService.customers, x -> x.getId());
    _nextOrderId = Utils.getListMax(DataService.orders, x -> x.getId());
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

  public static boolean save() {
    var data = new Data();
    data.managers = managers.stream().map((e) -> e.toMap()).toList();
    data.employees = employees.stream().map((e) -> e.toMap()).toList();
    data.customers = customers.stream().map((e) -> e.toMap()).toList();
    data.orders = orders.stream().map((e) -> e.toMap()).toList();

    try {
      var gson = new GsonBuilder().serializeNulls().create();
      var json = gson.toJson(data);
      Files.writeString(Paths.get(FILE_NAME), json, StandardCharsets.UTF_8);
      return true;
    } catch (IOException e) {
    }
    return false;
  }

  private static Data _load() {
    try {
      var json = Files.readString(Paths.get(FILE_NAME), StandardCharsets.UTF_8);
      if (json != null) {
        var gson = new GsonBuilder().serializeNulls().create();
        return gson.fromJson(json, Data.class);
      }
    } catch (IOException e) {
    }
    return null;
  }

  private static class Data {

    public List<Map<String, Object>> managers;
    public List<Map<String, Object>> employees;
    public List<Map<String, Object>> customers;
    public List<Map<String, Object>> orders;
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
