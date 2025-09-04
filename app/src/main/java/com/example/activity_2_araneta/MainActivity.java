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
            double heightf = height / 100.0; // From Centimeters to Meters

            double bmi = weight / (heightf * heightf);

            String bmiCategory;
            if (bmi < 15) {
                bmiCategory = "Very severely underweight";
            }else if (bmi < 16) {
                bmiCategory = "Severely Underweight";
            }else if (bmi < 18.5) {
                bmiCategory = "Underweight";
            } else if (bmi < 25) {
                bmiCategory = "Normal weight";
            } else if (bmi < 30) {
                bmiCategory = "Overweight";
            } else if (bmi < 35) {
                bmiCategory = "Obese Class 1 - Moderately Obese";
            }else if (bmi < 40) {
                bmiCategory = "Obese Class 2 - Severely Obese";
            }else {
                bmiCategory = "Obese Class 3 - Very Severely Obese";

            }


            result.setText(String.format("BMI: %.2f (%s)", bmi, bmiCategory));
        });
    }
}
