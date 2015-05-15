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


public class LoginActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText password = (EditText) findViewById(R.id.login_password_input);
        final EditText email = (EditText) findViewById(R.id.login_email_input);
        final Button LoginButton =(Button) findViewById(R.id.loginButton);
        final Button GoEnrollButton =(Button) findViewById(R.id.gotoEnrollButton);



        GoEnrollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TourDbHelper db = new TourDbHelper(getBaseContext());
                db.addAdmin("Ozan","123456","admin@admin.com");


                String inputEmail = email.getText().toString();
                String inputPassword = password.getText().toString();
                if(inputEmail.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"You should fulfill login details",Toast.LENGTH_LONG).show();
                    return;
                }

                String s = db.returnTouristPassword(inputEmail);
                if(s.equals(inputPassword))
                {
                    Intent intent = new Intent(getApplicationContext(), TouristMain.class);

                    startActivity(intent);
                    return;

                }
                String g = db.returnTourGuidePassword(inputEmail);
                if(g.equals(inputPassword))
                {
                    Intent intent = new Intent(getApplicationContext(), TourGuideMainActivity.class);
                    intent.putExtra("tourguideemail",inputEmail);
                    startActivity(intent);
                    startActivity(intent);
                    return;


                }
                String l = db.returnAdminPassword(inputEmail);
                if(l.equals(inputPassword))
                {
                    Intent intent = new Intent(getApplicationContext(), TourAdminActivity.class);
                    startActivity(intent);
                    return;
                }

                    Toast.makeText(getApplicationContext(), "Wrong Login Input!", Toast.LENGTH_LONG).show();
                    return;
                }










        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
