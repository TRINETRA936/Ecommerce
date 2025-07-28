package com.example.emarket;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminPanelActivity extends AppCompatActivity {
    EditText etName, etPrice, etDesc, etImgUrl;
    Button btnAddProduct;
    DatabaseReference productRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        etName = findViewById(R.id.etProductName);
        etPrice = findViewById(R.id.etProductPrice);
        etDesc = findViewById(R.id.etProductDesc);
        etImgUrl = findViewById(R.id.etProductImgUrl);
        btnAddProduct = findViewById(R.id.btnAddProduct);

        productRef = FirebaseDatabase.getInstance().getReference("Products");

        btnAddProduct.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String price = etPrice.getText().toString();
            String desc = etDesc.getText().toString();
            String img = etImgUrl.getText().toString();

            String id = productRef.push().getKey();
            Product product = new Product(id, name, price, desc, img);
            productRef.child(id).setValue(product);

            Toast.makeText(this, "Product Added", Toast.LENGTH_SHORT).show();
        });
    }
}