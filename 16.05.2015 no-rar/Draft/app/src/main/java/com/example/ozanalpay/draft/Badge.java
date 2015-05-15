package com.example.ozanalpay.draft;

/**
 * Created by OzanAlpay on 14.5.2015.
 */
public class Badge {

    public int badgeId;
    public String name;
    public String description;

    public Badge(int badgeId, String description, String name) {
        this.badgeId = badgeId;
        this.description = description;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Badge{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
