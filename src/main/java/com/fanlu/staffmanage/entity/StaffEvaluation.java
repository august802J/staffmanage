package com.fanlu.staffmanage.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * staff_evaluation
 * @author 
 */
public class StaffEvaluation implements Serializable {
    private Integer id;

    private Integer staffId;

    private String staffEvaJob;

    private String staffEvaManager;

    private String staffEvaScore;

    private String staffEvaAttitude;

    private String staffEvaComplete;

    private Integer staffEvaLate;

    private Integer staffEvaLeave;

    private Integer staffEvaAbsent;

    private String staffEvaCoop;

    private String staffEvaBehavior;

    private String staffEvaRelation;

    private String staffEvaCoopbehavior;

    private String staffEvaConnection;

    private String staffEvaManagecop;

    private String staffEvaManageratt;

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

    public String getStaffEvaJob() {
        return staffEvaJob;
    }

    public void setStaffEvaJob(String staffEvaJob) {
        this.staffEvaJob = staffEvaJob;
    }

    public String getStaffEvaManager() {
        return staffEvaManager;
    }

    public void setStaffEvaManager(String staffEvaManager) {
        this.staffEvaManager = staffEvaManager;
    }

    public String getStaffEvaScore() {
        return staffEvaScore;
    }

    public void setStaffEvaScore(String staffEvaScore) {
        this.staffEvaScore = staffEvaScore;
    }

    public String getStaffEvaAttitude() {
        return staffEvaAttitude;
    }

    public void setStaffEvaAttitude(String staffEvaAttitude) {
        this.staffEvaAttitude = staffEvaAttitude;
    }

    public String getStaffEvaComplete() {
        return staffEvaComplete;
    }

    public void setStaffEvaComplete(String staffEvaComplete) {
        this.staffEvaComplete = staffEvaComplete;
    }

    public Integer getStaffEvaLate() {
        return staffEvaLate;
    }

    public void setStaffEvaLate(Integer staffEvaLate) {
        this.staffEvaLate = staffEvaLate;
    }

    public Integer getStaffEvaLeave() {
        return staffEvaLeave;
    }

    public void setStaffEvaLeave(Integer staffEvaLeave) {
        this.staffEvaLeave = staffEvaLeave;
    }

    public Integer getStaffEvaAbsent() {
        return staffEvaAbsent;
    }

    public void setStaffEvaAbsent(Integer staffEvaAbsent) {
        this.staffEvaAbsent = staffEvaAbsent;
    }

    public String getStaffEvaCoop() {
        return staffEvaCoop;
    }

    public void setStaffEvaCoop(String staffEvaCoop) {
        this.staffEvaCoop = staffEvaCoop;
    }

    public String getStaffEvaBehavior() {
        return staffEvaBehavior;
    }

    public void setStaffEvaBehavior(String staffEvaBehavior) {
        this.staffEvaBehavior = staffEvaBehavior;
    }

    public String getStaffEvaRelation() {
        return staffEvaRelation;
    }

    public void setStaffEvaRelation(String staffEvaRelation) {
        this.staffEvaRelation = staffEvaRelation;
    }

    public String getStaffEvaCoopbehavior() {
        return staffEvaCoopbehavior;
    }

    public void setStaffEvaCoopbehavior(String staffEvaCoopbehavior) {
        this.staffEvaCoopbehavior = staffEvaCoopbehavior;
    }

    public String getStaffEvaConnection() {
        return staffEvaConnection;
    }

    public void setStaffEvaConnection(String staffEvaConnection) {
        this.staffEvaConnection = staffEvaConnection;
    }

    public String getStaffEvaManagecop() {
        return staffEvaManagecop;
    }

    public void setStaffEvaManagecop(String staffEvaManagecop) {
        this.staffEvaManagecop = staffEvaManagecop;
    }

    public String getStaffEvaManageratt() {
        return staffEvaManageratt;
    }

    public void setStaffEvaManageratt(String staffEvaManageratt) {
        this.staffEvaManageratt = staffEvaManageratt;
    }

    public Date getStaffInfoUpdatetime() {
        return staffInfoUpdatetime;
    }

    public void setStaffInfoUpdatetime(Date staffInfoUpdatetime) {
        this.staffInfoUpdatetime = staffInfoUpdatetime;
    }
}