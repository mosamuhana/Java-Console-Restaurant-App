// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.models;

import com.student.restaurant.services.OrderService;
import com.student.restaurant.util.MapSerializer;
import java.util.*;

public class Customer extends Person {

  private int _numOrders;

  public Customer() {
    super();
  }

  public Customer(int id, String name, String phone, int numOrders) {
    super(id, name, phone);
    _numOrders = numOrders;
  }

  public Customer(Customer o) {
    setId(o.getId());
    setName(o.getName());
    setPhone(o.getPhone());
    _numOrders = o._numOrders;
  }

  public Customer copy() {
    return new Customer(this);
  }

  public int getNumOrders() {
    return _numOrders;
  }

  public void increaseNumOrders() {
    _numOrders++;
  }

  public void decreaseNumOrders() {
    _numOrders--;
  }

  public List<Order> getOrders() {
    return OrderService.getAll().stream()
      .filter((x) -> x.getCustomerId() == getId())
      .toList();
  }

  public Map<String, Object> toMap() {
    /*
    var map = new HashMap<String, Object>();

    map.put("id", getId());
    map.put("name", getName());
    map.put("phone", getPhone());
    map.put("numOrders", getNumOrders());

    return map;
     */

    var s = new MapSerializer();
    s.setInteger("id", getId());
    s.setString("name", getName());
    s.setString("phone", getPhone());
    s.setInteger("numOrders", _numOrders);
    return s.getMap();
  }

  public static Customer fromMap(Map<String, Object> map) {
    /*
    var id = (int) map.get("id");
    var name = (String) map.get("name");
    var phone = (String) map.get("phone");
    var numOrders = (int) map.get("numOrders");

    return new Customer(id, name, phone, numOrders);
     */

    var s = new MapSerializer(map);
    return new Customer(
      s.getInteger("id"),
      s.getString("name"),
      s.getString("phone"),
      s.getInteger("numOrders")
    );

  }

  @Override
  public String toString() {
    return String.format("Customer { id: %d, name: %s, phone: %s, numOrders: %d }", getId(), getName(), getPhone(), _numOrders);
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
