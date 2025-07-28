package com.example.emarket;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AdminLoginActivity extends AppCompatActivity {
    EditText etAdminId, etAdminPass;
    Button btnLogin;
    final String ADMIN_ID = "admin";
    final String ADMIN_PASS = "admin123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        etAdminId = findViewById(R.id.etAdminId);
        etAdminPass = findViewById(R.id.etAdminPass);
        btnLogin = findViewById(R.id.btnLoginAdmin);

        btnLogin.setOnClickListener(v -> {
            String enteredId = etAdminId.getText().toString();
            String enteredPass = etAdminPass.getText().toString();

            if (enteredId.equals(ADMIN_ID) && enteredPass.equals(ADMIN_PASS)) {
                logAdminLogin(enteredId);
                startActivity(new Intent(this, AdminPanelActivity.class));
            } else {
                Toast.makeText(this, "Invalid Admin Credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void logAdminLogin(String adminId) {
        DatabaseReference logRef = FirebaseDatabase.getInstance().getReference("AdminLogins");

        String timestamp = String.valueOf(System.currentTimeMillis());
        String readableTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                .format(new Date());

        Map<String, Object> logData = new HashMap<>();
        logData.put("adminId", adminId);
        logData.put("timestamp", timestamp);
        logData.put("readableTime", readableTime);

        logRef.child(timestamp).setValue(logData);
    }
}
