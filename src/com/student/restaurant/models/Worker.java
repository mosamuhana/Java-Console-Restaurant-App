// Name: Malak Mosa Muhana  |  University ID: 2320223469
package com.student.restaurant.models;

public abstract class Worker extends Person {

  private int _gender;
  private String _address;
  private double _basicSalary;

  public Worker() {
    super();
  }

  public Worker(int id, String name, String phone, int gender, String address, double basicSalary) {
    super(id, name, phone);
    _gender = gender;
    _address = address;
    setBasicSalary(basicSalary);
  }

  public int getGender() {
    return _gender;
  }

  public void setGender(int v) {
    if (v == 1 || v == 2) {
      _gender = v;
    }
  }

  public String getAddress() {
    return _address;
  }

  public void setAddress(String v) {
    _address = v;
  }

  public double getBasicSalary() {
    return _basicSalary;
  }

  public void setBasicSalary(double v) {
    if (v < 0) {
      throw new Error("basicSalary must be positive or zero");
    }
    _basicSalary = v;
  }

  public abstract double getSalary();

  @Override
  public String toString() {
    return String.format(
      "Customer { id: %d, name: %s, phone: %s, gender: %s, address: %s, basicSalary: %f }",
      getId(),
      getName(),
      getPhone(),
      _gender,
      _address,
      _basicSalary
    );
  }
}
// Name: Malak Mosa Muhana  |  University ID: 2320223469
