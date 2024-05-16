package com.example.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private Button button_login;
    private EditText edEmail;
    private EditText edPass;
    private TextView tvSignUp;

    private void setValue() {
        spinner = findViewById(R.id.spinner);
        button_login = findViewById(R.id.button);
        edEmail = findViewById(R.id.edEmail);
        edPass = findViewById(R.id.edPass);
        tvSignUp = findViewById(R.id.tvSignUp);
    }

    private void handlingAction() {
        setArrayValue();
        button_login.setOnClickListener(this::handlingLogin);
        tvSignUp.setOnClickListener(this::changeActivity);
    }

    private void handlingLogin(View view) {
        String userName = edEmail.getText().toString();
        String pass = edPass.getText().toString();
        Log.d("test", userName + "," + pass);
        if (userName.equals("admin") && pass.equals("123456")) {
            Toast.makeText(this, "Login successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
        }
    }

    private void changeActivity(View view) {
        Intent intent = new Intent(this, InstagramActivity.class);
        startActivity(intent);
    }

    private void setArrayValue() {
        String[] spinnerArray = getResources().getStringArray(R.array.language);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.layout_spinner, spinnerArray);
        adapter.setDropDownViewResource(R.layout.layout_spinner);
        spinner.setAdapter(adapter);
    }

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
        setValue();
        handlingAction();
    }
}