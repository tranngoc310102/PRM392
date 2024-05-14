package com.example.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Spinner spinner = findViewById(R.id.spinner);
        String[] spinnerArray = getResources().getStringArray(R.array.language);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.layout_spinner, spinnerArray);
        adapter.setDropDownViewResource(R.layout.layout_spinner);
        spinner.setAdapter(adapter);

        Button button_login = findViewById(R.id.button);
        button_login.setOnClickListener(v ->{
            Intent intent = new Intent(MainActivity.this, InstagramActivity.class);
            startActivity(intent);
        });
    }
}