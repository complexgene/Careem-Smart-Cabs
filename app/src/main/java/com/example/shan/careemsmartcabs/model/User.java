package com.example.shan.careemsmartcabs.model;

/**
 * Created by Shan on 2/25/2017.
 */

public class User {
    private String userMobileNumer;
    private String userName;

    private static User singleTonUser;

    private User(){}

    public String getUserMobileNumer() {
        return userMobileNumer;
    }

    public static User getInstance(){
        if(singleTonUser == null){
            singleTonUser = new User();
        }
        return singleTonUser;
    }
    public void setUserMobileNumer(String userMobileNumer) {
        this.userMobileNumer = userMobileNumer;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
