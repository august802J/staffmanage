package com.fanlu.staffmanage.entity;

import java.io.Serializable;

/**
 * feedback
 * @author 
 */
public class Feedback implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer feedId;

    private Integer groupId;

    private String message;

    private Byte status;

    private static final long serialVersionUID = 1L;

    public Feedback() {
    }

    public Feedback(Integer userId, Integer feedId, Integer groupId, String message) {
        this.userId = userId;
        this.feedId = feedId;
        this.groupId = groupId;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFeedId() {
        return feedId;
    }

    public void setFeedId(Integer feedId) {
        this.feedId = feedId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
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