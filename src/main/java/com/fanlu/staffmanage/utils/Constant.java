package com.fanlu.staffmanage.utils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by YGwhere on 2021/2/19 15:32
 * Description: staffmanage
 *
 * @Author 15011_
 */
public class Constant {
    /**
     * 账号长度
     */
    public static final int ACCOUNT_LENGTH = 11;
    /**
     * 密码最小长度
     */
    public static final int PASSWORD_MIN_LENGTH = 8;
    /**
     * 密码最大长度
     */
    public static final int PASSWORD_MAX_LENGTH = 16;

    /**
     * 公司管理员权限
     */
    public static final int AUTH_INC = 1;
    public static final String STRING_INC = "inc";

    /**
     * 公司普通账户权限
     */
    public static final int AUTH_PERSON = 2;
    public static final String STRING_PERSON = "person";

    /**
     * 后台管理员权限
     */
    public static final int AUTH_MANAGER = 3;
    public static final String STRING_MANAGER = "manager";


//    public static final String IMAGES_PATH = "E:\\study\\IdeaProjects\\staffmanage\\src\\main\\resources\\static\\images\\";
    public static final String IMAGES_PATH = "/home/jar/images/";
    public static final String IMAGES_LOGO_PATH = IMAGES_PATH + "logo/";
    public static final String IMAGES_IDCARD_PATH = IMAGES_PATH + "idCard/";
    public static final String IMAGES_PERMISSION_PATH = IMAGES_PATH + "permission/";
    public static final int LOGIN_IMAGES = 3;
    public static final int IMAGE_SIZE = 1024 * 1024 * 2;
    public static final List<String> IMAGE_SUFFIX = Arrays.asList("image/jpg", "image/jpeg", "image/png");
}
