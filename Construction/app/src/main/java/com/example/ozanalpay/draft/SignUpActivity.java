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


public class SignUpActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final Button back =(Button) findViewById(R.id.back_button_from_sign_up);
        final Button signUp = (Button) findViewById(R.id.sign_up_button_from_sign_up);
        final EditText name = (EditText) findViewById(R.id.name_input_from_sign_up);
        final EditText surname = (EditText) findViewById(R.id.surname_input_from_sign_up);
        final EditText email = (EditText) findViewById(R.id.mail_input_from_sign_up);
        final EditText password = (EditText) findViewById(R.id.password_input_from_sign_up);
        final TourDbHelper db = new TourDbHelper(this.getBaseContext());



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String checkName = name.getText().toString();
                String checkSurname = surname.getText().toString();
                String checkEmail = email.getText().toString();
                String checkPassword = password.getText().toString();
                if(checkRequiredAreas(checkName, checkSurname, checkEmail, checkPassword))
                {
                    Toast.makeText(getApplicationContext(), "You have to fulfill all the areas",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                db.addTourist(checkName, checkSurname, checkPassword, checkEmail);
                Toast.makeText(getApplicationContext(), "Succesfully Registered!, Thank You!",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);


            }
        });


    }
    public boolean checkRequiredAreas(String name, String surname, String mail, String password)
    {
        if(name.isEmpty() || surname.isEmpty() || mail.isEmpty() ||  password.isEmpty())
        {
            return true;
        }
        return false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
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
