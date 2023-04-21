package com.Geekster.UserManagement.Service.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private String UserId;
    @JsonProperty("username")
    private String UserName;
    private  String Address;
    private String PhoneNumber;

    public User(String UserId, String UserName,String Address, String PhoneNumber ) {
        this.UserId = UserId;
        this.UserName = UserName;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
