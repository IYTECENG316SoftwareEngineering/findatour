package com.example.ozanalpay.draft;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
/**
 * Created by OzanAlpay on 11.5.2015.
 */
public class Tour {

    public Tour(int startYear, int startMonth, int startDay
            , int endYear, int endMonth, int endDay
            , int startHour, int startMin
            , int endHour, int endMin
            , int availableSlots, float price ,int participantLimit, int tourid
            , TourGuide tourGuide
            , Language lang
            , String cityName, ArrayList<String> sightSeeingPlaces
            ) {

        this.startDate.set(startYear, startMonth, startDay, startHour, startMin);
        this.endDate.set(endYear, endMonth, endDay, endHour, endMin);
        this.availableSlots = availableSlots;

        this.price = price;
        this.guide = tourGuide;
        this.cityName = cityName;
        this.sightseeingPlaces = sightSeeingPlaces;
        this.participants = new ArrayList<>();
        this.tourLanguage=lang;
        this.participantLimit = participantLimit;
        this.tourid=tourid;


    }

    public enum Language {
        ENGLISH, GERMAN, SPANISH, TURKISH
    }


    SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa");

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(int availableSlots) {
        this.availableSlots = availableSlots;
    }
    public int tourid;
    public Calendar startDate;
    private int availableSlots;
    private float price;
    public Calendar endDate;
    private TourGuide guide;
    private Language tourLanguage;
    private String cityName;
    private int participantLimit;
    public ArrayList<String> sightseeingPlaces;
    public ArrayList<Tourist> participants;

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public TourGuide getGuide() {
        return guide;
    }

    public void setGuide(TourGuide guide) {
        this.guide = guide;
    }

    public Language getTourLanguage() {
        return tourLanguage;
    }

    public void setTourLanguage(Language tourLanguage) {
        this.tourLanguage = tourLanguage;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getParticipantLimit() {
        return participantLimit;
    }

    public void setParticipantLimit(int participantLimit) {
        this.participantLimit = participantLimit;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "timeFormat=" + timeFormat +
                ", startDate=" + startDate +
                ", availableSlots=" + availableSlots +
                ", price=" + price +
                ", endDate=" + endDate +
                ", guide=" + guide +
                ", tourLanguage=" + tourLanguage +
                ", cityName='" + cityName + '\'' +
                ", participantLimit=" + participantLimit +
                ", sightseeingPlaces=" + sightseeingPlaces +
                ", participants=" + participants +
                '}';
    }
}

