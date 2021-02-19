package com.fanlu.staffmanage.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * staff_ability
 * @author 
 */
public class StaffAbility implements Serializable {
    private Integer id;

    private Integer staffId;

    private String staffAbiTime;

    private String staffAbiAbi;

    private Date staffAbiUpdatetime;

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

    public Date getStaffAbiUpdatetime() {
        return staffAbiUpdatetime;
    }

    public void setStaffAbiUpdatetime(Date staffAbiUpdatetime) {
        this.staffAbiUpdatetime = staffAbiUpdatetime;
    }
}