package com.codecool.shop.model;

import java.util.Currency;

public class Users extends BaseModel {

    private String userName;
    private String userEmail;
    private String userAddress;
    private String userCity;
    private String userState;
    private int userZip;


    public Users(String userName, String userEmail, String userAddress, String userCity, String userState, int userZip) {
        super(userName);
        this.userEmail = userEmail;
        this.userAddress = userAddress;
        this.userCity = userCity;
        this.userState = userState;
        this.userZip = userZip;
    }


    @Override
    public String toString() {
        return String.format("id: %1$d, " +
                        "userName: %2$s, " +
                        "userEmail: %3$s, " +
                        "userAddress: %4$s, " +
                        "userCity: %5$s, " +
                        "userState: %6$s" +
                        "userZip: %7$d",
                this.id,
                this.userName,
                this.userEmail,
                this.userAddress,
                this.userCity,
                this.userState,
                this.userZip);
    }
}
