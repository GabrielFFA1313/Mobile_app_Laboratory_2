package com.example.activity_2_araneta;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    EditText weight,height;

    Button enter;

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        enter = findViewById(R.id.enter);
        result = findViewById(R.id.result);

        enter.setOnClickListener(v -> {
            String weightStr = weight.getText().toString();
            String heightStr = height.getText().toString();

            if (weightStr.isEmpty() || heightStr.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter both weight and height", Toast.LENGTH_SHORT).show();
                return;
            }

            double weight = Double.parseDouble(weightStr);
            double height = Double.parseDouble(heightStr);
            double heightf = height / 100.0;

            double bmi = weight / (heightf * heightf);

            String bmiCategory;
            if (bmi < 18.5) {
                bmiCategory = "Underweight";
            } else if (bmi < 24.9) {
                bmiCategory = "Normal weight";
            } else if (bmi < 29.9) {
                bmiCategory = "Overweight";
            } else {
                bmiCategory = "Obese";
            }

            result.setText(String.format("BMI: %.2f (%s)", bmi, bmiCategory));
        });
    }
}
