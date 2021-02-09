package com.fanlu.staffmanage.entity;


public class StaffJob {

  private long id;
  private long staffId;
  private String staffJobDuration;
  private String staffJobCorp;
  private String staffJobJob;
  private String staffJobWage;
  private String staffJobReason;
  private java.sql.Timestamp staffInfoUpdateTime;


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


  public String getStaffJobDuration() {
    return staffJobDuration;
  }

  public void setStaffJobDuration(String staffJobDuration) {
    this.staffJobDuration = staffJobDuration;
  }


  public String getStaffJobCorp() {
    return staffJobCorp;
  }

  public void setStaffJobCorp(String staffJobCorp) {
    this.staffJobCorp = staffJobCorp;
  }


  public String getStaffJobJob() {
    return staffJobJob;
  }

  public void setStaffJobJob(String staffJobJob) {
    this.staffJobJob = staffJobJob;
  }


  public String getStaffJobWage() {
    return staffJobWage;
  }

  public void setStaffJobWage(String staffJobWage) {
    this.staffJobWage = staffJobWage;
  }


  public String getStaffJobReason() {
    return staffJobReason;
  }

  public void setStaffJobReason(String staffJobReason) {
    this.staffJobReason = staffJobReason;
  }


  public java.sql.Timestamp getStaffInfoUpdateTime() {
    return staffInfoUpdateTime;
  }

  public void setStaffInfoUpdateTime(java.sql.Timestamp staffInfoUpdateTime) {
    this.staffInfoUpdateTime = staffInfoUpdateTime;
  }

}
