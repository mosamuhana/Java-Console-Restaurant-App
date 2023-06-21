// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.models;

import com.student.restaurant.services.CustomerService;
import com.student.restaurant.util.MapSerializer;
import java.util.Map;

public class Order {

  private int _id;
  private int _type;
  private int _customerId;
  private DateTime _dateTime;
  private double _price;

  public Order() {
  }

  public Order(int id, int type, int customerId, DateTime dateTime, double price) {
    _id = id;
    _type = type;
    _customerId = customerId;
    _dateTime = dateTime;
    setPrice(price);
  }

  public Order(Order o) {
    _id = o._id;
    _type = o._type;
    _customerId = o._customerId;
    _dateTime = o._dateTime;
    _price = o._price;
  }

  public Order copy() {
    return new Order(this);
  }

  public void update(Order o) {
    setId(o.getId());
    _type = o._type;
    _customerId = o._customerId;
    _dateTime = o._dateTime;
    _price = o._price;
  }

  public int getId() {
    return _id;
  }

  public void setId(int v) {
    _id = v;
  }

  public int getType() {
    return _type;
  }

  public void setType(int v) {
    if (v == 1 || v == 2) {
      _type = v;
    }
  }

  public int getCustomerId() {
    return _customerId;
  }

  public void setCustomerId(int v) {
    _customerId = v;
  }

  public DateTime getDateTime() {
    return _dateTime;
  }

  public void setDateTime(DateTime v) {
    _dateTime = v;
  }

  public double getPrice() {
    return _price;
  }

  public final void setPrice(double v) {
    if (v <= 0) {
      throw new Error("price must be positive");
    }
    _price = v;
  }

  public Customer getCustomer() {
    return CustomerService.get(_customerId);
  }

  public Map<String, Object> toMap() {
    var s = new MapSerializer();
    s.setInteger("id", getId());
    s.setInteger("type", _type);
    s.setInteger("customerId", _customerId);
    s.setDateTime("dateTime", _dateTime);
    s.setDouble("price", _price);
    return s.getMap();
  }

  public static Order fromMap(Map<String, Object> map) {
    var s = new MapSerializer(map);
    return new Order(
      (int) s.getInteger("id"),
      s.getInteger("type"),
      (int) s.getInteger("customerId"),
      s.getDateTime("dateTime"),
      (double) s.getDouble("price")
    );
  }

  @Override
  public String toString() {
    return String.format(
      "Order { id: %d, type: %s, dateTime: %s, price: %f, customerId: %d }",
      getId(),
      _type,
      _dateTime,
      _price,
      _customerId
    );
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
