package com.example.android.login;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText userName;
    EditText password;
    EditText passwordAgain;
    EditText mobileNumber;
    TextView continueLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginButton();
    }

    public void LoginButton() {
        userName = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.pass);
        passwordAgain = (EditText) findViewById(R.id.again);
        mobileNumber = (EditText) findViewById(R.id.mob);
        continueLog = (TextView) findViewById(R.id.cont);


        continueLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkData()){
                    Intent intent= new Intent(v.getContext(),Welcome.class);
                    intent.putExtra("userName",userName.getText().toString());
                    intent.putExtra("password",password.getText().toString());
                    intent.putExtra("mobileNumber",mobileNumber.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

    boolean isEmail(EditText text){
        CharSequence email = text.getText().toString();
        return  (!Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
    boolean isEmpty(EditText text){
        CharSequence test = text.getText().toString();
        return (TextUtils.isEmpty(test));
    }

    public boolean checkData(){
        boolean isTrue = true;
        if (isEmail(userName)){
            userName.setError("Enter valid email");
            isTrue= false;
        }
        if (isEmpty(userName)){
            userName.setError("Email is Empty Enter valid email");
            isTrue= false;
        }
        if (isEmpty(password)){
            password.setError("password is Empty");
            isTrue= false;
        }
        if (isEmpty(passwordAgain)){
            passwordAgain.setError("password is Empty");
            isTrue= false;
        }
        if (!password.getText().toString().equals(passwordAgain.getText().toString()))  {
            passwordAgain.setError("password not math");
            isTrue= false;
        }
        if (isEmpty(mobileNumber)){
            mobileNumber.setError("password is Empty");
            isTrue= false;
        }
        return (isTrue);
    }
}
