package com.example.android.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    TextView userName;
    TextView mobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        userName.setText(getIntent().getExtras().getString("userName"));
        mobileNumber.setText(getIntent().getExtras().getString("mobileNumber"));
    }
}
