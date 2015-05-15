package com.example.ozanalpay.draft.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ozanalpay.draft.data.TourContract.BadgeEntry;
import com.example.ozanalpay.draft.data.TourContract.PlaceEntry;
import com.example.ozanalpay.draft.data.TourContract.TourAdminEntry;
import com.example.ozanalpay.draft.data.TourContract.TourEntry;
import com.example.ozanalpay.draft.data.TourContract.TourGuideBadgeEntry;
import com.example.ozanalpay.draft.data.TourContract.TourGuideEntry;
import com.example.ozanalpay.draft.data.TourContract.TourPlaceEntry;
import com.example.ozanalpay.draft.data.TourContract.TouristEntry;
import com.example.ozanalpay.draft.data.TourContract.TouristTourEntry;

/**
 * Created by OzanAlpay on 14.5.2015.
 */
public class TourDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "FIND_A_TOUR.db";


    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_TOURIST_TABLE = "CREATE TABLE " + TouristEntry.TABLE_NAME + " (" +
                // Why AutoIncrement here, and not above?
                // Unique keys will be auto-generated in either case.  But for weather
                // forecasting, it's reasonable to assume the user will want information
                // for a certain date and all dates *following*, so the forecast data
                // should be sorted accordingly.
                TouristEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TouristEntry.COLUMN_TOURIST_NAME + " TEXT NOT NULL, " +
                TouristEntry.COLUMN_TOURIST_SURNAME + " TEXT NOT NULL, "+
                TouristEntry.COLUMN_TOURIST_PASSWORD + " TEXT NOT NULL, "+
                TouristEntry.COLUMN_TOURIST_E_MAIL + " TEXT NOT NULL UNIQUE );";
        db.execSQL(SQL_CREATE_TOURIST_TABLE);
        final String SQL_CREATE_PLACE_TABLE = "CREATE TABLE " + PlaceEntry.TABLE_NAME + " (" +
                PlaceEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                PlaceEntry.COLUMN_PLACE_NAME + " TEXT NOT NULL );";
        db.execSQL(SQL_CREATE_PLACE_TABLE);
        final String SQL_CREATE_TOUR_GUIDE_TABLE = "CREATE TABLE " + TourGuideEntry.TABLE_NAME + " ("+
                TourGuideEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                TourGuideEntry.COLUMN_TOUR_GUIDE_NAME + " TEXT NOT NULL , " +
                TourGuideEntry.COLUMN_TOUR_GUIDE_SURNAME + " TEXT NOT NULL , " +
                TourGuideEntry.COLUMN_TOUR_GUIDE_PASSWORD + " TEXT NOT NULL , "+
                TourGuideEntry.COLUMN_TOUR_GUIDE_E_MAIL + " TEXT NOT NULL UNIQUE , "+
                TourGuideEntry.COLUMN_TOUR_GUIDE_RATING + " INTEGER );";
        db.execSQL(SQL_CREATE_TOUR_GUIDE_TABLE);
        final String SQL_CREATE_BADGE_TABLE = "CREATE TABLE " + BadgeEntry.TABLE_NAME + " (" +
                BadgeEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                BadgeEntry.COLUMN_BADGE_DESCRIPTION + " TEXT NOT NULL );";
        db.execSQL(SQL_CREATE_BADGE_TABLE);
        final String SQL_CREATE_TOUR_TABLE = "CREATE TABLE " + TourEntry.TABLE_NAME + " (" +
                TourEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                TourEntry.COLUMN_TOUR_NAME + " TEXT NOT NULL UNIQUE , " +
                TourEntry.COLUMN_TOUR_LANGUAGE + " TEXT NOT NULL , " +
                TourEntry.COLUMN_TOUR_PRICE + " REAL NOT NULL , " +
                TourEntry.COLUMN_TOUR_LIMIT_OF_PARTICIPANTS + " INTEGER NOT NULL , " +
                TourEntry.COLUMN_TOUR_NUMBER_OF_PARTICIPANTS + " INTEGER DEFAULT 0 , " +
                TourEntry.COLUMN_TOUR_START_DATE + "DATETIME NOT NULL , " +
                TourEntry.COLUMN_TOUR_END_DATE + " DATETIME NOT NULL , " +
                TourEntry.COLUMN_TOUR_CITY + " TEXT NOT NULL , " +
                TourEntry.COLUMN_TOUR_PROMOTED + "INTEGER , " +
                TourEntry.COLUMN_TOUR_TOUR_GUIDE_KEY  + " INTEGER NOT NULL, "+
                " FOREIGN KEY (" + TourEntry.COLUMN_TOUR_TOUR_GUIDE_KEY + ") REFERENCES " +
                TourGuideEntry.TABLE_NAME + " (" + TourGuideEntry._ID + "));";
        db.execSQL(SQL_CREATE_TOUR_TABLE);



        final String SQL_CREATE_TOURIST_TOUR_TABLE = "CREATE TABLE " + TouristTourEntry.TABLE_NAME + " (" +
                TouristTourEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                TouristTourEntry.COLUMN_TOUR_KEY + " INTEGER NOT NULL, " +
                TouristTourEntry.COLUMN_TOURIST_KEY + " INTEGER NOT NULL, "+
                TouristTourEntry.COLUMN_TOUR_TOURIST_GRADE + " INTEGER, " +
                "FOREIGN KEY (" + TouristTourEntry.COLUMN_TOUR_KEY + ") REFERENCES " +
                TourEntry.TABLE_NAME + " (" + TourEntry._ID + ") ," +
                "FOREIGN KEY (" + TouristTourEntry.COLUMN_TOURIST_KEY + ") REFERENCES " +
                TouristEntry.TABLE_NAME + " (" + TourEntry._ID + "));";

        db.execSQL(SQL_CREATE_TOURIST_TOUR_TABLE);
        final String SQL_CREATE_TOUR_PLACE_TABLE = "CREATE TABLE " + TourPlaceEntry.TABLE_NAME + " (" +
                TourPlaceEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                TourPlaceEntry.COLUMN_PLACE_KEY + " INTEGER NOT NULL , " +
                TourPlaceEntry.COLUMN_TOUR_KEY + " INTEGER NOT NULL , " +
                "FOREIGN KEY (" + TourPlaceEntry.COLUMN_TOUR_KEY + ") REFERENCES " +
                TourEntry.TABLE_NAME + " ( " + TourEntry._ID + ") , " +
                "FOREIGN KEY (" + TourPlaceEntry.COLUMN_PLACE_KEY + ") REFERENCES " +
                PlaceEntry.TABLE_NAME + " (" + PlaceEntry._ID + ")); ";
        db.execSQL(SQL_CREATE_TOUR_PLACE_TABLE);
        final String SQL_CREATE_TOUR_GUIDE_BADGE_TABLE = "CREATE TABLE " + TourGuideBadgeEntry.TABLE_NAME + " ("+
                TourGuideBadgeEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                TourGuideBadgeEntry.COLUMN_BADGE_KEY + " INTEGER NOT NULL , " +
                TourGuideBadgeEntry.COLUMN_TOUR_GUIDE_KEY + " INTEGER NOT NULL ," +
                "FOREIGN KEY (" + TourGuideBadgeEntry.COLUMN_TOUR_GUIDE_KEY + ") REFERENCES " +
                TourGuideEntry.TABLE_NAME + " ( " + TourGuideEntry._ID + ") , " +
                "FOREIGN KEY (" + TourGuideBadgeEntry.COLUMN_BADGE_KEY + ") REFERENCES " +
                BadgeEntry.TABLE_NAME + " ( " + BadgeEntry._ID + " ) ); ";
        db.execSQL(SQL_CREATE_TOUR_GUIDE_BADGE_TABLE);
        final String SQL_CREATE_TOUR_ADMIN_TABLE = "CREATE TABLE " + TourContract.TourAdminEntry.TABLE_NAME + " ("+
                TourContract.TourAdminEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                TourContract.TourAdminEntry.COLUMN_TOUR_ADMIN_NAME + " TEXT NOT NULL , " +
                TourContract.TourAdminEntry.COLUMN_TOUR_ADMIN_PASSWORD + " TEXT NOT NULL , " +
                TourContract.TourAdminEntry.COLUMN_TOUR_ADMIN_E_MAIL + " TEXT NOT NULL );";
        db.execSQL(SQL_CREATE_TOUR_ADMIN_TABLE);
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXITS " + TourGuideBadgeEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXITS " + TouristTourEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXITS " + TourPlaceEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXITS " + TourEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXITS " + BadgeEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXITS " + TourGuideEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXITS " + TouristEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXITS " + PlaceEntry.TABLE_NAME);
        onCreate(db);

    }
    public void addTourGuide(String tourGuideName, String tourGuideSurname, String tourGuidePassword,
                             String tourGuideEmail)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TourContract.TourGuideEntry.COLUMN_TOUR_GUIDE_NAME, tourGuideName);
        values.put(TourContract.TourGuideEntry.COLUMN_TOUR_GUIDE_SURNAME, tourGuideSurname);
        values.put(TourContract.TourGuideEntry.COLUMN_TOUR_GUIDE_PASSWORD, tourGuidePassword);
        values.put(TourContract.TourGuideEntry.COLUMN_TOUR_GUIDE_E_MAIL, tourGuideEmail);
        values.put(TourContract.TourGuideEntry.COLUMN_TOUR_GUIDE_RATING, -1);
        db.insert(TourGuideEntry.TABLE_NAME,null,values);
        db.close();
    }
    public void addTour(String tourGuideMail, String tourName, String tourPrice, String maxParticipant, String tourLanguage, String startDate, String startHour, String endHour)
    {

       SQLiteDatabase db = this.getWritableDatabase();
       String toBeAddedEndDate = startDate +" "+endHour+":00";
       String toBeAddedStartDate = startDate+" "+startHour+":00";
       int price = Integer.parseInt(tourPrice);
       int maxPart = Integer.parseInt(maxParticipant);
       int tourGuideId = returnTourGuideId(tourGuideMail);
       ContentValues values = new ContentValues();
       values.put(TourContract.TourEntry.COLUMN_TOUR_NAME, tourName);
       values.put(TourContract.TourEntry.COLUMN_TOUR_LANGUAGE, tourLanguage);
       values.put(TourContract.TourEntry.COLUMN_TOUR_PRICE, tourPrice);
       values.put(TourContract.TourEntry.COLUMN_TOUR_END_DATE, toBeAddedEndDate);
       values.put(TourContract.TourEntry.COLUMN_TOUR_START_DATE, toBeAddedStartDate);
       values.put(TourContract.TourEntry.COLUMN_TOUR_PRICE, price);
       values.put(TourContract.TourEntry.COLUMN_TOUR_LIMIT_OF_PARTICIPANTS, maxPart);
       values.put(TourContract.TourEntry.COLUMN_TOUR_NUMBER_OF_PARTICIPANTS, 0);
       //values.put(TourContract.TourEntry.COLUMN_TOUR_PROMOTED, 0);
       values.put(TourContract.TourEntry.COLUMN_TOUR_TOUR_GUIDE_KEY, tourGuideId);
       db.insert(TourEntry.TABLE_NAME,null,values);
       db.close();




    }
    public void addAdmin(String adminName, String adminPassword, String adminEmail)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TourContract.TourAdminEntry.COLUMN_TOUR_ADMIN_NAME, adminName);
        values.put(TourContract.TourAdminEntry.COLUMN_TOUR_ADMIN_E_MAIL, adminEmail);
        values.put(TourContract.TourAdminEntry.COLUMN_TOUR_ADMIN_PASSWORD, adminPassword);
        db.insert(TourAdminEntry.TABLE_NAME,null,values);
        db.close();

    }


    public void addTourist(String touristName, String surname ,String password, String e_mail){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TouristEntry.COLUMN_TOURIST_NAME, touristName);
        values.put(TouristEntry.COLUMN_TOURIST_SURNAME, surname);
        values.put(TouristEntry.COLUMN_TOURIST_PASSWORD, password);
        values.put(TouristEntry.COLUMN_TOURIST_E_MAIL, e_mail );
        db.insert(TouristEntry.TABLE_NAME,null,values);
        db.close();



    }
    public int returnTourGuideId(String email)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = " SELECT "+ TourGuideEntry._ID + " FROM "
                +TourGuideEntry.TABLE_NAME + " WHERE " + TourGuideEntry.COLUMN_TOUR_GUIDE_E_MAIL + " = '" + email + "';";
        Cursor c = db.rawQuery(selectQuery,null);
        c.moveToFirst();
        return c.getInt(c.getColumnIndex(TourGuideEntry._ID));

    }
    public String returnAdminPassword(String adminEmail)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = " SELECT "+ TourContract.TourAdminEntry.COLUMN_TOUR_ADMIN_PASSWORD+" FROM "
                +TourContract.TourAdminEntry.TABLE_NAME+" WHERE "
                + TourContract.TourAdminEntry.COLUMN_TOUR_ADMIN_E_MAIL + " = '"+adminEmail+"';";
        Cursor c = db.rawQuery(selectQuery,null);
        if(c.moveToFirst())
        {
            c.moveToFirst();
            return c.getString(c.getColumnIndex(TourContract.TourAdminEntry.COLUMN_TOUR_ADMIN_PASSWORD));
        }
        return "";

    }
    public String returnTouristPassword(String touristEmail)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT "+ TouristEntry.COLUMN_TOURIST_PASSWORD+" FROM "+TourContract.TouristEntry.TABLE_NAME+" WHERE "
                + TourContract.TouristEntry.COLUMN_TOURIST_E_MAIL + " = '"+touristEmail+"';";

        Cursor c = db.rawQuery(selectQuery,null);
        if(c.moveToFirst())
        {
            c.moveToFirst();
            return c.getString(c.getColumnIndex(TouristEntry.COLUMN_TOURIST_PASSWORD));

        }
        return "";

    }
    public String returnTourGuidePassword(String tourGuideEmail)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT "+ TourGuideEntry.COLUMN_TOUR_GUIDE_PASSWORD +" FROM " + TourGuideEntry.TABLE_NAME +" WHERE "
                + TourGuideEntry.COLUMN_TOUR_GUIDE_E_MAIL + " = '"+tourGuideEmail+"';";
        Cursor c = db.rawQuery(selectQuery,null);
        if(c.moveToFirst()) {
             c.moveToFirst();
             return c.getString(c.getColumnIndex(TourGuideEntry.COLUMN_TOUR_GUIDE_PASSWORD));

        }

        return "";

    }


    public TourDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


}
