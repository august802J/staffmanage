package com.fanlu.staffmanage.dto;

import com.fanlu.staffmanage.entity.UserCoop;

/**
 * Created by YGwhere on 2021/2/11 14:33
 * Description: staffmanage
 *
 * @Author 15011_
 */
public class Inc {
    private int groupId;
    private String icpUrl;
    private String idUrl;
    private String inc_name;
    private String inc_icp;
    private String inc_place;
    private String inc_rage;
    private String kind;
    private String inc_count;
    private String legal_name;
    private String legal_job;
    private String legal_idkind;
    private String legal_id;
    private String legal_phone;

    public Inc() {
    }

    /**
     * 将 UserCoop 类转换成 Inc 类
     * @param userCoop
     */
    public Inc(UserCoop userCoop) {
        this.groupId = userCoop.getId();
        this.icpUrl = userCoop.getUserCoopJpgurl();
        this.idUrl = userCoop.getUserPerIdurl();
        this.inc_name = userCoop.getUserCoopName();
        this.inc_icp = userCoop.getUserCoopIcp();
        this.inc_place = userCoop.getUserCoopAddr();
        this.inc_rage = userCoop.getUserCoopRage();
        this.kind = userCoop.getUserCoopKind();
        this.inc_count = userCoop.getUserCoopNum();
        this.legal_name = userCoop.getUserPerName();
        this.legal_job = userCoop.getUserPerJob();
        this.legal_idkind = userCoop.getUserPerIdkind();
        this.legal_id = userCoop.getUserPerId();
        this.legal_phone = userCoop.getUserPerPhone();
    }

    /**
     * 判断字符串是否为 null 或 空字符串
     * @param str
     * @return
     */
    public boolean sal(String str) {
        return null != str || "".equals(str);
    }

    /**
     * 判断属性是否全部非空
     * @return
     */
    public boolean check() {
        return sal(inc_name) && sal(inc_icp) && sal(inc_place) && sal(inc_rage)
                && sal(kind) && sal(inc_count) && sal(legal_name) && sal(legal_job)
                && sal(legal_id) && sal(legal_idkind) && sal(legal_phone);
    }

    public String getInc_name() {
        return inc_name;
    }

    public void setInc_name(String inc_name) {
        this.inc_name = inc_name;
    }

    public String getInc_icp() {
        return inc_icp;
    }

    public void setInc_icp(String inc_icp) {
        this.inc_icp = inc_icp;
    }

    public String getInc_place() {
        return inc_place;
    }

    public void setInc_place(String inc_place) {
        this.inc_place = inc_place;
    }

    public String getInc_rage() {
        return inc_rage;
    }

    public void setInc_rage(String inc_rage) {
        this.inc_rage = inc_rage;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getInc_count() {
        return inc_count;
    }

    public void setInc_count(String inc_count) {
        this.inc_count = inc_count;
    }

    public String getLegal_name() {
        return legal_name;
    }

    public void setLegal_name(String legal_name) {
        this.legal_name = legal_name;
    }

    public String getLegal_job() {
        return legal_job;
    }

    public void setLegal_job(String legal_job) {
        this.legal_job = legal_job;
    }

    public String getLegal_idkind() {
        return legal_idkind;
    }

    public void setLegal_idkind(String legal_idkind) {
        this.legal_idkind = legal_idkind;
    }

    public String getLegal_id() {
        return legal_id;
    }

    public void setLegal_id(String legal_id) {
        this.legal_id = legal_id;
    }

    public String getLegal_phone() {
        return legal_phone;
    }

    public void setLegal_phone(String legal_phone) {
        this.legal_phone = legal_phone;
    }
}
