package com.fanlu.staffmanage.entity;

import com.fanlu.staffmanage.dto.Inc;

import java.io.Serializable;

/**
 * user_coop
 * @author 
 */
public class UserCoop implements Serializable {
    private Integer id;

    private String userCoopName;

    private String userCoopIcp;

    private String userCoopAddr;

    private String userCoopRage;

    private String userCoopKind;

    private String userCoopNum;

    private String userPerName;

    private String userPerJob;

    private String userPerIdkind;

    private String userPerId;

    private String userPerPhone;

    private String userPerIdurl;

    private String userCoopJpgurl;

    private String userCoopLogourl;

    private Byte userCoopIscheck;

    private static final long serialVersionUID = 1L;

    /**
     * 将 Inc 类转换成 UserCoop 类
     * @param inc
     */
    public UserCoop(Inc inc) {
        this.userCoopName = inc.getInc_name();
        this.userCoopIcp = inc.getInc_icp();
        this.userCoopAddr = inc.getInc_place();
        this.userCoopRage = inc.getInc_rage();
        this.userCoopKind = inc.getKind();
        this.userCoopNum = inc.getInc_count();
        this.userPerName = inc.getLegal_name();
        this.userPerJob = inc.getLegal_job();
        this.userPerIdkind = inc.getLegal_idkind();
        this.userPerId = inc.getLegal_id();
        this.userPerPhone = inc.getLegal_phone();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCoopName() {
        return userCoopName;
    }

    public void setUserCoopName(String userCoopName) {
        this.userCoopName = userCoopName;
    }

    public String getUserCoopIcp() {
        return userCoopIcp;
    }

    public void setUserCoopIcp(String userCoopIcp) {
        this.userCoopIcp = userCoopIcp;
    }

    public String getUserCoopAddr() {
        return userCoopAddr;
    }

    public void setUserCoopAddr(String userCoopAddr) {
        this.userCoopAddr = userCoopAddr;
    }

    public String getUserCoopRage() {
        return userCoopRage;
    }

    public void setUserCoopRage(String userCoopRage) {
        this.userCoopRage = userCoopRage;
    }

    public String getUserCoopKind() {
        return userCoopKind;
    }

    public void setUserCoopKind(String userCoopKind) {
        this.userCoopKind = userCoopKind;
    }

    public String getUserCoopNum() {
        return userCoopNum;
    }

    public void setUserCoopNum(String userCoopNum) {
        this.userCoopNum = userCoopNum;
    }

    public String getUserPerName() {
        return userPerName;
    }

    public void setUserPerName(String userPerName) {
        this.userPerName = userPerName;
    }

    public String getUserPerJob() {
        return userPerJob;
    }

    public void setUserPerJob(String userPerJob) {
        this.userPerJob = userPerJob;
    }

    public String getUserPerIdkind() {
        return userPerIdkind;
    }

    public void setUserPerIdkind(String userPerIdkind) {
        this.userPerIdkind = userPerIdkind;
    }

    public String getUserPerId() {
        return userPerId;
    }

    public void setUserPerId(String userPerId) {
        this.userPerId = userPerId;
    }

    public String getUserPerPhone() {
        return userPerPhone;
    }

    public void setUserPerPhone(String userPerPhone) {
        this.userPerPhone = userPerPhone;
    }

    public String getUserPerIdurl() {
        return userPerIdurl;
    }

    public void setUserPerIdurl(String userPerIdurl) {
        this.userPerIdurl = userPerIdurl;
    }

    public String getUserCoopJpgurl() {
        return userCoopJpgurl;
    }

    public void setUserCoopJpgurl(String userCoopJpgurl) {
        this.userCoopJpgurl = userCoopJpgurl;
    }

    public String getUserCoopLogourl() {
        return userCoopLogourl;
    }

    public void setUserCoopLogourl(String userCoopLogourl) {
        this.userCoopLogourl = userCoopLogourl;
    }

    public Byte getUserCoopIscheck() {
        return userCoopIscheck;
    }

    public void setUserCoopIscheck(Byte userCoopIscheck) {
        this.userCoopIscheck = userCoopIscheck;
    }
}