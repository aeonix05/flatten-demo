package com.test.demo.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "teamhierarchy")
public class TeamHierarchy {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private String id;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "empid")
  private User employee;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "managerid")
  private User manager;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public User getEmployee() {
    return employee;
  }

  public void setEmployee(User employee) {
    this.employee = employee;
  }

  public User getManager() {
    return manager;
  }

  public void setManager(User manager) {
    this.manager = manager;
  }
}
