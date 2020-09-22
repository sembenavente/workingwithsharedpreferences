package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private EditText mName, mPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mName = (EditText) findViewById(R.id.etUser);
        mPassword = (EditText) findViewById(R.id.etPass);
        btnLogin = (Button) findViewById(R.id.btLogin);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        mEditor = mPreferences.edit();

        checkSharedPreferences();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //save the name
                String name = mName.getText().toString();
                mEditor.putString(getString(R.string.name), name);
                mEditor.commit();

                //save the password
                String password = mPassword.getText().toString();
                mEditor.putString(getString(R.string.password), password);
                mEditor.commit();

                Intent intent = new Intent(MainActivity.this, LogCorrect.class);
                startActivity(intent);
            }
        });

    }

    private void checkSharedPreferences(){
        String name = mPreferences.getString(getString(R.string.name), "");
        String password = mPreferences.getString(getString(R.string.password), "");

        if (!name.equals("") && !password.equals("")){
            Intent intent = new Intent(MainActivity.this, LogCorrect.class);
            startActivity(intent);
        }else{
            mName.setText(name);
            mPassword.setText(password);
        }
    }
}