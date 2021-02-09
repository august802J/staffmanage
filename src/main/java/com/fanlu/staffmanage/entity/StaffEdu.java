package com.fanlu.staffmanage.entity;


public class StaffEdu {

  private long id;
  private long staffId;
  private String staffEduDuration;
  private String staffEduExp;
  private java.sql.Timestamp staffEduUpdateTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getStaffId() {
    return staffId;
  }

  public void setStaffId(long staffId) {
    this.staffId = staffId;
  }


  public String getStaffEduDuration() {
    return staffEduDuration;
  }

  public void setStaffEduDuration(String staffEduDuration) {
    this.staffEduDuration = staffEduDuration;
  }


  public String getStaffEduExp() {
    return staffEduExp;
  }

  public void setStaffEduExp(String staffEduExp) {
    this.staffEduExp = staffEduExp;
  }


  public java.sql.Timestamp getStaffEduUpdateTime() {
    return staffEduUpdateTime;
  }

  public void setStaffEduUpdateTime(java.sql.Timestamp staffEduUpdateTime) {
    this.staffEduUpdateTime = staffEduUpdateTime;
  }

}
