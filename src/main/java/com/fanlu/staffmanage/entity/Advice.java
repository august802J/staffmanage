package com.fanlu.staffmanage.entity;

import java.io.Serializable;

/**
 * advice
 * @author 
 */
public class Advice implements Serializable {
    private Integer id;

    private Integer recvId;

    private Integer userId;

    private String message;

    private Byte status;

    private static final long serialVersionUID = 1L;

    public Advice() {
    }

    public Advice(Integer recvId, Integer userId, String message) {
        this.recvId = recvId;
        this.userId = userId;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecvId() {
        return recvId;
    }

    public void setRecvId(Integer recvId) {
        this.recvId = recvId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}