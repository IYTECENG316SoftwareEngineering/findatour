package com.example.ozanalpay.draft.data;

import android.provider.BaseColumns;

/**
 * Created by OzanAlpay on 14.5.2015.
 */
public class TourContract {

    public static final class TouristEntry implements BaseColumns {
        public static final String TABLE_NAME = "tourist";

        //public static final String COLUMN_TOURIST_ID = "id"; +

        public static final String COLUMN_TOURIST_NAME = "name";

        public static final String COLUMN_TOURIST_SURNAME = "surname";

        public static final String COLUMN_TOURIST_PASSWORD = "password";

        public static final String COLUMN_TOURIST_E_MAIL ="e_mail";

    }

    public static final class PlaceEntry implements BaseColumns {

        public static final String TABLE_NAME = "place";

        //public static final String COLUMN_PLACE_ID = "id"; +

        public static final String COLUMN_PLACE_NAME = "name";




    }

    public static final class BadgeEntry implements BaseColumns {

        public static final String TABLE_NAME = "badge";

        //public static final String COLUMN_BADGE_ID = "id"; +

        public static final String COLUMN_BADGE_DESCRIPTION = "description";


    }

    public static final class TourGuideEntry implements BaseColumns {

        public static final String TABLE_NAME = "tour_guide";

        //public static final String COLUMN_TOUR_GUIDE_ID = "id"; +

        public static final String COLUMN_TOUR_GUIDE_NAME = "name";

        public static final String COLUMN_TOUR_GUIDE_SURNAME = "surname";

        public static final String COLUMN_TOUR_GUIDE_PASSWORD = "password";

        public static final String COLUMN_TOUR_GUIDE_RATING = "rating";

        public static final String COLUMN_TOUR_GUIDE_E_MAIL = "e_mail";
    }
    public static final class TourAdminEntry implements BaseColumns {
        public static final String TABLE_NAME = "tour_admin";

        public static final String COLUMN_TOUR_ADMIN_NAME = "name";

        public static final String COLUMN_TOUR_ADMIN_PASSWORD = "password";

        public static final String COLUMN_TOUR_ADMIN_E_MAIL = "e_mail";
    }
    public static final class TourEntry implements BaseColumns {

        public static final String TABLE_NAME = "tour";

        //public static final String COLUMN_TOUR_ID = "id"; +

        public static final String COLUMN_TOUR_NAME = "name";

        public static final String COLUMN_TOUR_CITY = "city";

        public static final String COLUMN_TOUR_START_DATE = "start_date";

        public static final String COLUMN_TOUR_END_DATE = "end_date";

        public static final String COLUMN_TOUR_PROMOTED = "promoted";

       // public static final String COLUMN_TOUR_START_HOUR = "start_hour";

       //public static final String COLUMN_TOUR_END_HOUR = "end_hour";

        public static final String COLUMN_TOUR_PRICE = "price";

        public static final String COLUMN_TOUR_NUMBER_OF_PARTICIPANTS = "number_of_participants";

        public static final String COLUMN_TOUR_LIMIT_OF_PARTICIPANTS = "limit_of_participants";

        public static final String COLUMN_TOUR_LANGUAGE = "language";

        public static final String COLUMN_TOUR_TOUR_GUIDE_KEY = "tour_guide_id";



    }

    public static final class TouristTourEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "tourist_tour";

        public static final String COLUMN_TOURIST_KEY = "tourist_id";

        public static final String COLUMN_TOUR_KEY = "tour_id";

        public static final String COLUMN_TOUR_TOURIST_GRADE = "tour_grade";
    }

    public static final class TourGuideBadgeEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "tour_guide_badge";

        public static final String COLUMN_TOUR_GUIDE_KEY = "tour_guide_id";

        public static final String COLUMN_BADGE_KEY = "badge_id";


    }
    public static final class TourPlaceEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "tour_place";

        public static final String COLUMN_TOUR_KEY = "tour_id";

        public static final String COLUMN_PLACE_KEY = "place_id";



    }











}
