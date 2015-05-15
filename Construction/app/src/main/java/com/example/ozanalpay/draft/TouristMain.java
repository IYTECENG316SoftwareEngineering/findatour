package com.example.ozanalpay.draft;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;


public class TouristMain extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_main);
        Button getDateBtn = (Button) findViewById(R.id.tourist_main_place_start_date_input_button);
        Button getStartHourBtn = (Button) findViewById(R.id.tourist_main_place_start_time_input_button);
        Button getEndHourBtn = (Button) findViewById(R.id.tourist_main_place_end_time_input_button);
        final TextView showStartTime = (TextView) findViewById(R.id.activity_tourist_main_start_show_time);
        final TextView showEndTime = (TextView) findViewById(R.id.activity_tourist_main_end_show_time);
        final TextView showDate = (TextView) findViewById(R.id.activity_tourist_main_date);
        ScrollView scrollView = (ScrollView) findViewById(R.id.tourist_scroll_view);












        getStartHourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar MCurrentTime = Calendar.getInstance();//
                int hour = MCurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = MCurrentTime.get(Calendar.MINUTE);
                TimePickerDialog timePicker;

                timePicker = new TimePickerDialog(TouristMain.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        showStartTime.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);
                timePicker.setTitle("Pick Start Hour");
                timePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Set", timePicker);
                timePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "Cancel", timePicker);

                timePicker.show();    }
        });

        getEndHourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Calendar MCurrentTime = Calendar.getInstance();//
                int hour = MCurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = MCurrentTime.get(Calendar.MINUTE);
                TimePickerDialog timePicker;

                timePicker = new TimePickerDialog(TouristMain.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {


                        showEndTime.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);
                timePicker.setTitle("Pick End Hour");
                timePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Set", timePicker);
                timePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "Cancel", timePicker);

                timePicker.show();    }
        });
        getDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                Calendar MCurrentTime = Calendar.getInstance();//
                int day = MCurrentTime.get(Calendar.DAY_OF_MONTH);
                int month = MCurrentTime.get(Calendar.MONTH);
                int year = MCurrentTime.get(Calendar.YEAR);
                DatePickerDialog datePicker;

                datePicker = new DatePickerDialog(TouristMain.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker timePicker, int year, int month, int day) {
                        showDate.setText( year + ":" + month + ":" + day);
                    }
                }, year, month, day);
                datePicker.setTitle("Pick Tour Date");
                datePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Set", datePicker);
                datePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "Cancel", datePicker);

                datePicker.show();    }

        });

    }










    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tourist_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
