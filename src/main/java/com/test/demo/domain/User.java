package com.test.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user")
public class User {

//  @GeneratedValue(generator = "UUID")
//  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
//  private String id;

  @Id
  @Column(name = "empid", nullable = false)
  private String empId;

  @Column(name = "accesskey", nullable = false)
  private String accessKey;

  @Column(name = "country")
  private String country;

//  public User() {
//
//  }
//
//  public User(String empId, String accessKey, String country) {
//    this.empId = empId;
//    this.accessKey = accessKey;
//    this.country = country;
//  }

//  public String getId() {
//    return id;
//  }
//
//  public void setId(String id) {
//    this.id = id;
//  }

  public String getEmpId() {
    return empId;
  }

  public void setEmpId(String empId) {
    this.empId = empId;
  }

  public String getAccessKey() {
    return accessKey;
  }

  public void setAccessKey(String accessKey) {
    this.accessKey = accessKey;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}
