package com.ttssoftware.android.reservierung;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView login;
    Button neueReservierung, reservierungenansehen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());


        login = (TextView) findViewById(R.id.textView2);

        login.setText(sharedPreferences.getString("login_name","default"));

        neueReservierung = (Button) findViewById(R.id.btn_newReserv);
        neueReservierung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NeueReservierung.class);
                startActivity(intent);
            }
        });
        reservierungenansehen = (Button) findViewById(R.id.btn_seeReserv);
        reservierungenansehen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Reservierungen.class);
                startActivity(intent);
            }
        });
    }

}
