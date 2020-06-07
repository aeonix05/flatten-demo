package com.test.demo.dto;

import com.test.demo.domain.UserAccess;

public class UserAccessDto {

  private String id;

  private String empid;

  private String accessKey;

  private String country;

  private String subuser;

  private String subuserAccessKey;

  private String subuserCountry;

  public UserAccessDto() {
  }

  public UserAccessDto(UserAccess userAccess) {
    this.id = userAccess.getId();
    this.empid = userAccess.getEmpid();
    this.accessKey = userAccess.getAccessKey();
    this.country = userAccess.getCountry();
    this.subuser = userAccess.getSubuser();
    this.subuserAccessKey = userAccess.getSubuserAccessKey();
    this.subuserCountry = userAccess.getSubuserCountry();
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
