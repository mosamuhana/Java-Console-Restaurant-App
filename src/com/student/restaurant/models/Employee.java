// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.models;

import com.student.restaurant.util.MapSerializer;
import java.util.Map;

public class Employee extends Worker {

  private int _numWorkYears;
  private int _shift;

  public Employee() {
  }

  public Employee(int id, String name, String phone, int gender, String address, double basicSalary, int numWorkYears, int shift) {
    super(id, name, phone, gender, address, basicSalary);
    setNumWorkYears(numWorkYears);
    _shift = shift;
  }

  public Employee(Employee o) {
    this(o.getId(), o.getName(), o.getPhone(), o.getGender(), o.getAddress(), o.getBasicSalary(), o.getNumWorkYears(), o.getShift());
  }

  public int getNumWorkYears() {
    return _numWorkYears;
  }

  public final void setNumWorkYears(int v) {
    if (v < 0) {
      throw new Error("numWorkYears must be positive or zero");
    }
    _numWorkYears = v;
  }

  public int getShift() {
    return _shift;
  }

  public void setShift(int v) {
    if (v == 1 || v == 2) {
      _shift = v;
    }
  }

  @Override
  public double getSalary() {
    return getBasicSalary() * (1 + (_numWorkYears * 5) / 100.0);
  }

  public Employee copy() {
    return new Employee(this);
  }

  public Employee copy(Employee e) {
    return new Employee(this);
  }

  public Map<String, Object> toMap() {
    var s = new MapSerializer();
    s.setInteger("id", getId());
    s.setString("name", getName());
    s.setString("phone", getPhone());
    s.setInteger("gender", getGender());
    s.setString("address", getAddress());
    s.setDouble("basicSalary", getBasicSalary());
    s.setInteger("numWorkYears", getNumWorkYears());
    s.setInteger("shift", getShift());
    return s.getMap();
  }

  public static Employee fromMap(Map<String, Object> map) {
    // int id, String name, String phone, Gender gender, String address, double basicSalary, int numWorkYears, Shift shift
    var s = new MapSerializer(map);
    return new Employee(
      (int) s.getInteger("id"),
      s.getString("name"),
      s.getString("phone"),
      s.getInteger("gender"),
      s.getString("address"),
      (double) s.getDouble("basicSalary"),
      (int) s.getInteger("numWorkYears"),
      s.getInteger("shift")
    );
  }

  @Override
  public String toString() {
    return String.format(
      "Employee { id: %d, name: %s, phone: %s, gender: %s, address: %s, basicSalary: %f, numWorkYears: %d, shift: %s }",
      getId(), getName(), getPhone(),
      getGender(),
      getAddress(),
      getBasicSalary(),
      _numWorkYears,
      _shift
    );
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
