package com.example.ozanalpay.draft.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import java.util.Map;
import java.util.Set;

/**
 * Created by OzanAlpay on 15.5.2015.
 */
public class TestUtilites extends AndroidTestCase {


     // December 20th, 2014

    static void validateCursor(String error, Cursor valueCursor, ContentValues expectedValues) {
        assertTrue("Empty cursor returned. " + error, valueCursor.moveToFirst());
        validateCurrentRecord(error, valueCursor, expectedValues);
        valueCursor.close();
    }

    static void validateCurrentRecord(String error, Cursor valueCursor, ContentValues expectedValues) {
        Set<Map.Entry<String, Object>> valueSet = expectedValues.valueSet();
        for (Map.Entry<String, Object> entry : valueSet) {
            String columnName = entry.getKey();
            int idx = valueCursor.getColumnIndex(columnName);
            assertFalse("Column '" + columnName + "' not found. " + error, idx == -1);
            String expectedValue = entry.getValue().toString();
            assertEquals("Value '" + entry.getValue().toString() +
                    "' did not match the expected value '" +
                    expectedValue + "'. " + error, expectedValue, valueCursor.getString(idx));
        }
    }

    /*
        Students: Use this to create some default weather values for your database tests.
     */
    static ContentValues createTouristValues() {
        ContentValues touristValues = new ContentValues();
        touristValues.put(TourContract.TouristEntry.COLUMN_TOURIST_NAME, "Ozan");
        touristValues.put(TourContract.TouristEntry.COLUMN_TOURIST_SURNAME, "Alpay");
        touristValues.put(TourContract.TouristEntry.COLUMN_TOURIST_E_MAIL, "ozanalpay@yandex.com.tr");
        touristValues.put(TourContract.TouristEntry.COLUMN_TOURIST_PASSWORD, "123456");



        return touristValues;
    }
    public static long insertTouristValues(Context context)
    {
        TourDbHelper dbHelper = new TourDbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues testValues = TestUtilites.createTouristValues();
        long rowId;
        rowId = db.insert(TourContract.TouristEntry.TABLE_NAME,null,testValues);
        assertTrue("Error Failure to insert Tourist Test Values", rowId!=-1);
        return rowId;


    }






}
