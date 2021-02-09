package com.fanlu.staffmanage.entity;


public class User {

  private long id;
  private long groupId;
  private String account;
  private String password;
  private long auth;
  private String name;
  private String job;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getGroupId() {
    return groupId;
  }

  public void setGroupId(long groupId) {
    this.groupId = groupId;
  }


  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public long getAuth() {
    return auth;
  }

  public void setAuth(long auth) {
    this.auth = auth;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

}
