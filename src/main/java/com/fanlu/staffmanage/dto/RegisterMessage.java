package com.fanlu.staffmanage.dto;

import com.fanlu.staffmanage.utils.Constant;

/**
 * Created by YGwhere on 2021/2/21 16:02
 * Description: staffmanage
 *
 * @Author 15011_
 */
public class RegisterMessage {

    private String account;
    private String password;
    private Inc inc;

    public boolean check() {
        return null == account || account.length() != Constant.ACCOUNT_LENGTH || null == password
                || password.length() < Constant.PASSWORD_MIN_LENGTH
                || password.length() > Constant.PASSWORD_MAX_LENGTH || null == inc || !inc.check();
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

    public Inc getInc() {
        return inc;
    }

    public void setInc(Inc inc) {
        this.inc = inc;
    }

}
