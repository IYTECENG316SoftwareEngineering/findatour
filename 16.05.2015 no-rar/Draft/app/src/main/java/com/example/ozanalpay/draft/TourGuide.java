package com.example.ozanalpay.draft;

import java.util.ArrayList;

/**
 * Created by OzanAlpay on 11.5.2015.
 */
public class TourGuide extends User {

    private int rating;
    ArrayList<Badge> badges;


    public TourGuide(int user_id, String username, String password, String e_mail, USER_TYPE user_type) {
        super(user_id, username, password, e_mail, user_type);
        this.rating=0;
        this.badges=new ArrayList<>();
    }
}
