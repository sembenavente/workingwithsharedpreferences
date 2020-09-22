package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class LogCorrect extends AppCompatActivity {

    private TextView mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_correct);

        mName = (TextView) findViewById(R.id.textView);

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mPreferences.edit();

        String name = mPreferences.getString(getString(R.string.name), "");
        mName.setText("Usuario " + name + " Logueado con exito");
    }
}