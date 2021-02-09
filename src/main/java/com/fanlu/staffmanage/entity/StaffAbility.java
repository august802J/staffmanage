package com.fanlu.staffmanage.entity;


public class StaffAbility {

    private long id;
    private long staffId;
    private String staffAbiTime;
    private String staffAbiAbi;
    private java.sql.Timestamp staffAbiUpdateTime;


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


    public String getStaffAbiTime() {
        return staffAbiTime;
    }

    public void setStaffAbiTime(String staffAbiTime) {
        this.staffAbiTime = staffAbiTime;
    }


    public String getStaffAbiAbi() {
        return staffAbiAbi;
    }

    public void setStaffAbiAbi(String staffAbiAbi) {
        this.staffAbiAbi = staffAbiAbi;
    }


    public java.sql.Timestamp getStaffAbiUpdateTime() {
        return staffAbiUpdateTime;
    }

    public void setStaffAbiUpdateTime(java.sql.Timestamp staffAbiUpdateTime) {
        this.staffAbiUpdateTime = staffAbiUpdateTime;
    }

}
