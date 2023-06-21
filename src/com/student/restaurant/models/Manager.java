// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.models;

import com.student.restaurant.util.MapSerializer;
import java.util.Map;

public class Manager extends Worker {

  private double _bonus; // percent of basicSalary

  public Manager() {
    super();
  }

  public Manager(int id, String name, String phone, int gender, String address, double basicSalary, double bonus) {
    super(id, name, phone, gender, address, basicSalary);
    setBonus(bonus);
  }

  public Manager(Manager o) {
    this(o.getId(), o.getName(), o.getPhone(), o.getGender(), o.getAddress(), o.getBasicSalary(), o.getBonus());
  }

  public double getBonus() {
    return _bonus;
  }

  public void setBonus(double v) {
    if (v < 0) {
      throw new Error("bonus must be positive or zero");
    }
    _bonus = v;
  }

  @Override
  public double getSalary() {
    return getBasicSalary() * (1 + _bonus / 100.0);
  }

  public Map<String, Object> toMap() {
    var s = new MapSerializer();
    s.setInteger("id", getId());
    s.setString("name", getName());
    s.setString("phone", getPhone());
    s.setInteger("gender", getGender());
    s.setString("address", getAddress());
    s.setDouble("basicSalary", getBasicSalary());
    s.setDouble("bonus", getBonus());
    return s.getMap();
  }

  public static Manager fromMap(Map<String, Object> map) {
    var s = new MapSerializer(map);
    return new Manager(
      (int) s.getInteger("id"),
      s.getString("name"),
      s.getString("phone"),
      s.getInteger("gender"),
      s.getString("address"),
      (double) s.getDouble("basicSalary"),
      (double) s.getDouble("bonus")
    );
  }

  @Override
  public String toString() {
    return String.format(
      "Manager { id: %d, name: %s, phone: %s, gender: %s, address: %s, basicSalary: %f, bonus: %f }",
      getId(), getName(), getPhone(),
      getGender(),
      getAddress(),
      getBasicSalary(),
      _bonus
    );
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
