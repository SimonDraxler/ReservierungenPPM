package com.ttssoftware.android.reservierung;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ttssoftware.android.reservierung.Database.DatabaseHandler;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Register extends AppCompatActivity {

    private EditText username, pwd, name;
    private Button registrieren;
    private String usernametxt, pwdtxt, nametxt;
    private DatabaseHandler databaseHandler;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        databaseHandler = new DatabaseHandler(getApplicationContext());

        username = (EditText)findViewById(R.id.editText_Username);
        pwd = (EditText)findViewById(R.id.editText_pwd);
        name = (EditText)findViewById(R.id.editText_name);

        registrieren = (Button)findViewById(R.id.btn_newregister);
        registrieren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Log.d("register", "onklick");
                usernametxt = username.getText().toString();
                pwdtxt = computeMD5Hash(pwd.getText().toString());
                nametxt = name.getText().toString();
                User user = new User(0,usernametxt,pwdtxt,nametxt);
                int id = databaseHandler.neuerUser(user);
                Toast.makeText(getApplicationContext(), "User angelegt" + id, Toast.LENGTH_LONG).show();
            }
        });

    }

    public String computeMD5Hash(String pwdtxt)
    {

        try {

            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(pwdtxt.getBytes());
            byte messageDigest[] = digest.digest();

            StringBuffer MD5Hash = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++)
            {
                String h = Integer.toHexString(0xFF & messageDigest[i]);
                while (h.length() < 2)
                    h = "0" + h;
                MD5Hash.append(h);
            }
            return MD5Hash.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
            return null;
        }


    }


}
