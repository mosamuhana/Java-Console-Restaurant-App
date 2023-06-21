// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.services;

import com.student.restaurant.models.*;
import com.student.restaurant.util.Console;
import com.student.restaurant.util.TableBuilder;
import com.student.restaurant.util.Utils;
import java.util.*;

public final class EmployeeService {

  private EmployeeService() {
  }

  //****************************************************************************
  // Data Helper
  //****************************************************************************
  public static List<Employee> getAll() {
    return DataService.employees;
  }

  public static Employee get(int id) {
    return Person.find(DataService.employees, id);
  }

  public static boolean delete(int id) {
    var employee = get(id);
    if (employee == null) {
      return false;
    }

    DataService.employees.remove(employee);
    DataService.save();

    return true;
  }

  public static Employee add(String name, String phone, int gender, String address, double basicSalary, int numWorkYears, int shift) {
    var employee = new Employee(DataService.getNextEmployeeId(), name, phone, gender, address, basicSalary, numWorkYears, shift);
    DataService.employees.add(employee);

    DataService.save();

    return employee;
  }

  //****************************************************************************
  // Console Helper
  //****************************************************************************
  private final static String[] header = new String[]{"Id", "Name", "Gender", "Phone", "Shift", "Basic Salary", "Salary", "Work Years"};

  public static void print(Employee x) {
    TableBuilder.create()
      .data(Utils.createRowDetails(getRow(x), header))
      .caption("Employee Details")
      .emptyText("")
      .print();
  }

  public static void printList(List<Employee> list, String caption) {
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

  public static Employee select() throws Exception {
    var list = getAll();

    printList(list, "Employees");

    var keys = list.stream().map((x) -> x.getId()).toArray(Integer[]::new);

    var id = Console.selectInteger("Select Employee: ", keys);
    if (id == null) {
      return null;
    }

    return get(id);
  }

  private static Object[] getRow(Employee x) {
    return new Object[]{
      x.getId(),
      x.getName(),
      x.getGender() == 1 ? "Male" : "Female",
      x.getPhone(),
      x.getShift() == 1 ? "Day" : "Night",
      x.getBasicSalary(),
      x.getSalary(),
      x.getNumWorkYears()
    };
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
