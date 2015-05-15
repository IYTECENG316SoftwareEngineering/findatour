package com.example.ozanalpay.draft;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.ozanalpay.draft.data.TourDbHelper;

import java.util.Calendar;


public class CreateTourActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_tour);
        Button setStartDate = (Button) findViewById(R.id.create_tour_date_input_button);
        Button setStartHourBtn = (Button) findViewById(R.id.create_tour_start_time_input_button);
        Button setEndHourBtn = (Button) findViewById(R.id.create_tour_end_time_input_button);
        Button createDateBtn = (Button) findViewById(R.id.create_tour_now_button);
        final EditText getTourName = (EditText) findViewById(R.id.tour_name_input_from_tour_create);
        final EditText getTourPrice = (EditText) findViewById(R.id.tour_ticket_price_input_from_tour_create);
        final TextView getTourStartDate = (TextView) findViewById(R.id.create_tour_get_date);
        final TextView getTourStartHour = (TextView) findViewById(R.id.create_tour_get_start_hour);
        final TextView getTourEndHour = (TextView) findViewById(R.id.create_tour_get_end_hour);
        final EditText getMaxParticipant = (EditText) findViewById(R.id.tour_max_person_value_input_from_tour_create);
        final TourDbHelper db = new TourDbHelper(this.getBaseContext());
        final Spinner getLanguage = (Spinner) findViewById(R.id.language_input_from_tour_create);

        createDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tourName = getTourName.getText().toString();
                String tourPrice = getTourPrice.getText().toString();
                String startHour = getTourStartHour.getText().toString();
                String endHour = getTourEndHour.getText().toString();
                String date = getTourStartDate.getText().toString();
                String maxParticipant = getMaxParticipant.getText().toString();
                String tourLanguage = getLanguage.getSelectedItem().toString();
                Intent intent = getIntent();
                String tourGuideMailAdress = intent.getExtras().getString("tourguideemail");
                db.addTour(tourGuideMailAdress, tourName, tourPrice, maxParticipant, tourLanguage, date, startHour, endHour);

                Toast.makeText(getApplicationContext(), "You Created A New Tour!", Toast.LENGTH_LONG).show();
                return;




            }
        });






        setStartHourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar MCurrentTime = Calendar.getInstance();//
                int hour = MCurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = MCurrentTime.get(Calendar.MINUTE);
                TimePickerDialog timePicker;

                timePicker = new TimePickerDialog(CreateTourActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        getTourStartHour.setText(selectedHour + ":" + selectedMinute);

                    }
                }, hour, minute, true);
                timePicker.setTitle("Pick Start Hour");
                timePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Set", timePicker);
                timePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "Cancel", timePicker);

                timePicker.show();



            }
        });
        setEndHourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Calendar MCurrentTime = Calendar.getInstance();
                int hour = MCurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = MCurrentTime.get(Calendar.MINUTE);
                TimePickerDialog timePicker;

                timePicker = new TimePickerDialog(CreateTourActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        getTourEndHour.setText(selectedHour + ":" + selectedMinute);

                    }
                }, hour, minute, true);//true 24 saatli sistem için
                timePicker.setTitle("Pick End Hour");
                timePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Set", timePicker);
                timePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "Cancel", timePicker);

                timePicker.show();

            }
        });

        setStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar MCurrentTime = Calendar.getInstance();//
                int day = MCurrentTime.get(Calendar.DAY_OF_MONTH);
                int month = MCurrentTime.get(Calendar.MONTH);
                int year = MCurrentTime.get(Calendar.YEAR);
                DatePickerDialog datePicker;

                datePicker = new DatePickerDialog(CreateTourActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker timePicker, int year, int month, int day) {
                        getTourStartDate.setText(year + "-" + month + "-" + day);

                    }
                }, year, month, day);
                datePicker.setTitle("Pick Tour Date");
                datePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Set", datePicker);
                datePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "Cancel", datePicker);

                datePicker.show();

            }
        });



























    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_tour, menu);
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
