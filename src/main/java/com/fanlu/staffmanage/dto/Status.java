package com.fanlu.staffmanage.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName StatusService
 * @Author 15011
 */
public class Status {

    private static Integer registerInc = 0;
    private static Integer registerIncBak = 0;
    private static Integer users = -1;
    private static Integer look = 0;
    private static Date date = new Date();
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyyMMdd");

    public static Integer getRegisterInc() {
        Date now = new Date();
        if(!FORMAT.format(now).equals(FORMAT.format(date))) {
            registerIncBak = registerInc;
            registerInc = 0;
        }
        return registerIncBak;
    }

    public static void setUsers(Integer users) {
        Status.users = users;
    }

    public static Integer getUsers() {
        return users;
    }

    public static Integer getLook() {
        return look;
    }

    public static void plusInc() {
        registerInc++;
    }

    public static void plusUsers() {
        users++;
    }

    public static void plusLook() {
        look++;
    }
}
