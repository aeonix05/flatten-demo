package com.test.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "useraccess")
public class UserAccess {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private String id;

  @Column(name = "empid")
  private String empid;

  @Column(name = "accesskey")
  private String accessKey;

  @Column(name = "country")
  private String country;

  @Column(name = "subuser")
  private String subuser;

  @Column(name = "subuser_accesskey")
  private String subuserAccessKey;

  @Column(name = "subuser_country")
  private String subuserCountry;

  public UserAccess() {
  }

  public UserAccess(String empid, String accessKey, String country, String subuser,
      String subuserAccessKey, String subuserCountry) {
    this.empid = empid;
    this.accessKey = accessKey;
    this.country = country;
    this.subuser = subuser;
    this.subuserAccessKey = subuserAccessKey;
    this.subuserCountry = subuserCountry;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getEmpid() {
    return empid;
  }

  public void setEmpid(String empid) {
    this.empid = empid;
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

  public String getSubuser() {
    return subuser;
  }

  public void setSubuser(String subuser) {
    this.subuser = subuser;
  }

  public String getSubuserAccessKey() {
    return subuserAccessKey;
  }

  public void setSubuserAccessKey(String subuserAccessKey) {
    this.subuserAccessKey = subuserAccessKey;
  }

  public String getSubuserCountry() {
    return subuserCountry;
  }

  public void setSubuserCountry(String subuserCountry) {
    this.subuserCountry = subuserCountry;
  }
}
