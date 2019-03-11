package com.example.demomvp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demomvp.R;
import com.example.demomvp.presenter.PresenterLogin;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewLoginListener {
    private String username;
    private String password;
    private EditText edt_username;
    private EditText edt_password;
    private Button btnLogin;
    private PresenterLogin presenterLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        edt_username = findViewById(R.id.edt_username);
        edt_password = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        presenterLogin = new PresenterLogin(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                username = edt_username.getText().toString();
                password = edt_password.getText().toString();
                presenterLogin.receiveRequireLogin(username, password);
                break;
        }
    }

    @Override
    public void onLoginSuccess() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    @Override
    public void onLoginFail() {
        Toast.makeText(this, "Login Fail", Toast.LENGTH_SHORT).show();
    }
}
