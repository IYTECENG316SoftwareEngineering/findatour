package com.example.ozanalpay.draft;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ozanalpay.draft.data.TourDbHelper;


public class TourAdminActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_admin);
        final EditText inputName = (EditText)  findViewById(R.id.tour_guide_name_input_from_admin);
        final EditText inputSurname = (EditText) findViewById(R.id.tour_guide_surname_input_from_admin);
        final EditText inputEmail = (EditText) findViewById(R.id.tour_guide_email_input_from_admin);
        final EditText inputPassword = (EditText) findViewById(R.id.tour_guide_password_input_from_admin);
        Button create = (Button)findViewById(R.id.create_tour_guide_button_from_admin);
        final TourDbHelper db = new TourDbHelper(this.getBaseContext());

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String guideName = inputName.getText().toString();
                String guideSurname = inputSurname.getText().toString();
                String guideMail = inputEmail.getText().toString();
                String guidePassword = inputPassword.getText().toString();
                if(checkInputValues(guideName, guideSurname, guidePassword, guideMail))
                {
                    Toast.makeText(getApplicationContext(), "There are missing values!", Toast.LENGTH_LONG).show();
                    return;
                }
                db.getWritableDatabase();
                db.addTourGuide(guideName, guideSurname, guideMail, guidePassword);

                Toast.makeText(getApplicationContext(), "Succesfully Registered!, Thank You!",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                return;

            }
        });



    }
    public boolean checkInputValues(String s1, String s2, String s3, String s4)
    {
        if(s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty())
        {
            return true;
        }
        return false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tour_admin, menu);
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
