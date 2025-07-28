package com.example.emarket;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class UserTypeActivity extends AppCompatActivity {
    Button btnAdmin, btnCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);

        btnAdmin = findViewById(R.id.btnAdmin);
        btnCustomer = findViewById(R.id.btnCustomer);

        btnAdmin.setOnClickListener(v -> {
            startActivity(new Intent(UserTypeActivity.this, AdminLoginActivity.class));
        });

        btnCustomer.setOnClickListener(v -> {
            startActivity(new Intent(UserTypeActivity.this, UserLoginActivity.class));
        });
    }
}