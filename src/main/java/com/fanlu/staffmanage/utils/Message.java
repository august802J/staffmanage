package com.fanlu.staffmanage.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YGwhere on 2021/2/11 13:29
 * Description: staffmanage
 *
 * @Author 15011_
 */
public class Message {
    /**
     * 将服务端返回的数据以 Map 的形式返回
     */
    private Map<String, Object> data = new HashMap<>();
    /**
     * 返回的状态码，各取值与代表意思如下：
     * 200 - 请求成功
     * 404 - 请求的资源（网页等）不存在
     * 500 - 内部服务器错误
     * 301 - 资源被永久转移到其他 url
     */
    private int status = 0;
    /**
     * 提示信息
     * message - 处理失败的提示
     * detail - 处理失败的详细错误信息
     */
    private Map<String, String> statusInfo = new HashMap<>();

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String, String> getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String message) {
        this.statusInfo.put("message", message);
    }

    public void setStatusInfo(String message, String detail) {
        this.statusInfo.put("message", message);
        this.statusInfo.put("detail", detail);
    }

    public Message add(String key, Object value) {
        this.getData().put(key, value);
        return this;
    }

    /**
     * 请求成功，默认状态码为 200
     * @return
     */
    public static Message success() {
        Message message = new Message();
        message.setStatus(200);
        return message;
    }

    /**
     * 请求成功，设置状态码为 status
     * @param status
     * @return
     */
    public static Message success(int status) {
        Message message = new Message();
        message.setStatus(status);
        return message;
    }

    /**
     * 请求失败，默认状态码为 404
     * @return
     */
    public static Message fail() {
        Message message = new Message();
        message.setStatus(404);
        message.setStatusInfo("请求资源不存在");
        return message;
    }

    /**
     * 请求失败，设置状态码为 status，并返回提示信息 statusInfo
     * @param status
     * @param statusInfo
     * @return
     */
    public static Message fail(int status, String statusInfo) {
        Message message = new Message();
        message.setStatus(status);
        message.setStatusInfo(statusInfo);
        return message;
    }

    /**
     * 服务器内部发生错误
     * @return
     */
    public static Message haveException() {
        Message message = new Message();
        message.setStatus(500);
        message.setStatusInfo("服务器内部错误");
        return message;
    }

    /**
     * 服务器系统错误，并返回错误信息
     * @param status
     * @param error
     * @return
     */
    public static Message haveException(int status, String error, Exception exception) {
        Message message = new Message();
        message.setStatus(status);
        message.setStatusInfo(error, exception.toString());
        return message;
    }
}
