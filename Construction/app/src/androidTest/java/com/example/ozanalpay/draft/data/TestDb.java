package com.example.ozanalpay.draft.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import java.util.HashSet;

/**
 * Created by OzanAlpay on 15.5.2015.
 */
public class TestDb extends AndroidTestCase {
    public static final String LOG_TAG =TestDb.class.getSimpleName();


    public void deleteTheDatabase() {
        mContext.deleteDatabase(TourDbHelper.DATABASE_NAME);
    }


    public void setUp() {
        deleteTheDatabase();
    }

    public void testCreateDb() throws Throwable {

        final HashSet<String> tableNameHashSet = new HashSet<String>();

        tableNameHashSet.add(TourContract.TouristEntry.TABLE_NAME);
        tableNameHashSet.add(TourContract.TourEntry.TABLE_NAME);
        tableNameHashSet.add(TourContract.TourGuideEntry.TABLE_NAME);
        tableNameHashSet.add(TourContract.PlaceEntry.TABLE_NAME);
        tableNameHashSet.add(TourContract.BadgeEntry.TABLE_NAME);
        tableNameHashSet.add(TourContract.TourPlaceEntry.TABLE_NAME);
        tableNameHashSet.add(TourContract.TouristTourEntry.TABLE_NAME);
        tableNameHashSet.add(TourContract.TourGuideBadgeEntry.TABLE_NAME);

        mContext.deleteDatabase(TourDbHelper.DATABASE_NAME);
        SQLiteDatabase db = new TourDbHelper(this.mContext).getWritableDatabase();
        assertEquals(true,db.isOpen());

        Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'",null);
        assertTrue("Error Database not created correctly",c.moveToFirst());

        do {
            tableNameHashSet.remove(c.getString(0));
        }while(c.moveToNext());

        assertTrue("Error Database was created without any tables",tableNameHashSet.isEmpty());

        c = db.rawQuery("PRAGMA table_info (" + TourContract.TouristEntry.TABLE_NAME+")",null);

        assertTrue("Error: This means that we were unable to query the database for table info",c.moveToFirst());


        db.close();


    }
    public void TestTouristTable() throws Throwable
    {
        TourDbHelper tourHelper = new TourDbHelper(mContext);
        SQLiteDatabase db = tourHelper.getWritableDatabase();
        ContentValues testValues = TestUtilites.createTouristValues();
        long rowId;
        rowId = db.insert(TourContract.TouristEntry.TABLE_NAME,null,testValues);
        assertTrue(rowId != -1);


        Cursor cursor = db.query(
                TourContract.TouristEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);
        assertTrue(" Error : No queries returned from query ",cursor.moveToFirst());

        TestUtilites.validateCurrentRecord("Error Location Query Failed", cursor, testValues);
        assertFalse("Error More than one record returned!? (WTF??)  ", cursor.moveToNext());
        cursor.close();
        db.close();


        //return rowId;









    }







}








