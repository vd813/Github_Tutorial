package com.example.viktord.sharedpreferences_65;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usernameInput;
    EditText passwordInput;
    TextView slimText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = (EditText) findViewById(R.id.usernameID);
        passwordInput = (EditText) findViewById(R.id.passwordID);
        slimText = (TextView) findViewById(R.id.textID);
    }


    //Save user's login info
    public void saveInfo(View view){
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE); //MODE_PRIVATE: info can only be access by this app

        SharedPreferences.Editor editor = sharedPref.edit();    //shared pref file is a file with 2 columns key:value
        editor.putString("username", usernameInput.getText().toString());
        editor.putString("password", passwordInput.getText().toString());
        editor.apply();

        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
    }

    public void displayData(View view){
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE); //MODE_PRIVATE: info can only be access by this app

        String name = sharedPref.getString("username", ""); //return nothing "" if "username" is not valid
        String pw = sharedPref.getString("password", "");
        slimText.setText(name + " " + pw);
    }

}
