package com.fanlu.staffmanage.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * staff_job
 * @author 
 */
public class StaffJob implements Serializable {
    private Integer id;

    private Integer staffId;

    private String staffJobDuration;

    private String staffJobCorp;

    private String staffJobJob;

    private String staffJobWage;

    private String staffJobReason;

    private Date staffInfoUpdatetime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
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

    public Date getStaffInfoUpdatetime() {
        return staffInfoUpdatetime;
    }

    public void setStaffInfoUpdatetime(Date staffInfoUpdatetime) {
        this.staffInfoUpdatetime = staffInfoUpdatetime;
    }
}