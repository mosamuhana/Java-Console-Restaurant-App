// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.models;

import java.util.List;

public class Person extends Object {

  private int _id;
  private String _name;
  private String _phone;

  public Person() {
  }

  public Person(int id, String name, String phone) {
    _id = id;
    _name = name;
    _phone = phone;
  }

  public int getId() {
    return _id;
  }

  public void setId(int v) {
    _id = v;
  }

  public String getName() {
    return _name;
  }

  public void setName(String v) {
    this._name = v;
  }

  public String getPhone() {
    return _phone;
  }

  public void setPhone(String v) {
    this._phone = v;
  }

  @Override
  public String toString() {
    return String.format("Person { id: %d, name: %s, phone: %s }", getId(), _name, _phone);
  }

  public static <T extends Person> T find(List<T> list, int id) {
    for (var item : list) {
      if (item.getId() == id) {
        return item;
      }
    }
    return null;
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
