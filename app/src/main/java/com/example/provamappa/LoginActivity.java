package com.example.provamappa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import connessioneDB.ConnessioneDB_login;

public class LoginActivity extends AppCompatActivity {
    EditText pas,usr;
    static boolean verifica=true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            usr = findViewById(R.id.userField);
            pas = findViewById(R.id.passwordFiled);

    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("ciaoI");
    }

    public void loginBtn(View view){
        String user = usr.getText().toString();
        String pass = pas.getText().toString();

        //ConnessioneDB_login con=new ConnessioneDB_login(this);
        //con.execute(user,pass);
        verifica=false;
        Intent i = new Intent(this, MapsActivity.class);
        startActivity(i);

    }

    public void vaiRegistraActivity(View view){
        Intent i = new Intent(this, RegistazioneActivity.class);
        startActivity(i);

    }
}
