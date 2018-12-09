package com.example.android.githubapi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.githubapi.R;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private Button logIn;
    private EditText userName_Text;

    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logIn = findViewById(R.id.login_btn);
        userName_Text = findViewById(R.id.input_username);

    }

    public void getUser(View view) {
        i = new Intent(LoginActivity.this, UserActivity.class);
        i.putExtra("String_need", userName_Text.getText().toString());
        startActivity(i);
    }
}
