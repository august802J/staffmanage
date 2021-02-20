package com.fanlu.staffmanage.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * staff_edu
 * @author 
 */
public class StaffEdu implements Serializable {
    private Integer id;

    private Integer staffId;

    private String staffEduDuration;

    private String staffEduExp;

    private Date staffEduUpdatetime;

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

    public Date getStaffEduUpdatetime() {
        return staffEduUpdatetime;
    }

    public void setStaffEduUpdatetime(Date staffEduUpdatetime) {
        this.staffEduUpdatetime = staffEduUpdatetime;
    }
}