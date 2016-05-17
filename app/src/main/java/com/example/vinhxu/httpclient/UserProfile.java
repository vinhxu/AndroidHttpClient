package com.example.vinhxu.httpclient;

/**
 * Created by vinhxu on 5/16/2016.
 */
public class UserProfile {

    String userName;
    Double startWeight;
    Double targetWeight;
    Integer daysToTarget;
    Double height;
    String startDate;

    public UserProfile() {
    }

    public UserProfile(String userName, Double startWeight, Double targetWeight, Integer daysToTarget, Double height, String startDate) {
        this.userName = userName;
        this.startWeight = startWeight;
        this.targetWeight = targetWeight;
        this.daysToTarget = daysToTarget;
        this.height = height;
        this.startDate = startDate;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setStartWeight(Double startWeight) {
        this.startWeight = startWeight;
    }

    public void setTargetWeight(Double targetWeight) {
        this.targetWeight = targetWeight;
    }

    public void setDaysToTarget(Integer daysToTarget) {
        this.daysToTarget = daysToTarget;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getUserName() {
        return userName;
    }

    public Double getStartWeight() {
        return startWeight;
    }

    public Double getTargetWeight() {
        return targetWeight;
    }

    public Integer getDaysToTarget() {
        return daysToTarget;
    }

    public Double getHeight() {
        return height;
    }

    public String getStartDate() {
        return startDate;
    }
}
