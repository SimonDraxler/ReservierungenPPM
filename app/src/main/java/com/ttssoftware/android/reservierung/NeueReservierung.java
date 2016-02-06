package com.ttssoftware.android.reservierung;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class NeueReservierung extends AppCompatActivity {

    public Spinner sp_sport, sp_court, sp_zeit;
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neue_reservierung);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sp_sport = (Spinner) findViewById(R.id.sp_sportart);
        sp_court = (Spinner) findViewById(R.id.sp_court);
        sp_zeit = (Spinner) findViewById(R.id.sp_zeit);

        button = (Button) findViewById(R.id.btn_reservieren);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sport = sp_sport.getSelectedItem().toString();
                String zeit = sp_zeit.getSelectedItem().toString();
                int court = Integer.parseInt(sp_court.getSelectedItem().toString());

                Reservierung reservierung = new Reservierung(sport,zeit,court);
            }
        });

    }

}
