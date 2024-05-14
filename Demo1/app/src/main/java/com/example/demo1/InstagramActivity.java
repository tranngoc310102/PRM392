package com.example.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InstagramActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.instagram);
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(v ->{
            Intent intent = new Intent(InstagramActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
