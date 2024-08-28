package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    NumberPicker numberPickerX, numberPickerY;
    TextView txtResult;
    Button btnPlus, btnMinus, btnMultiply, btnDivide, btnMod;

    private void initControl() {
        numberPickerX = findViewById(R.id.numberPickerX);
        numberPickerY = findViewById(R.id.numberPickerY);
        txtResult = findViewById(R.id.txtResult);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnMod = findViewById(R.id.btnMod);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = numberPickerX.getValue();
                int y = numberPickerY.getValue();
                int result = x + y;
                txtResult.setText(String.valueOf(result));
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = numberPickerX.getValue();
                int y = numberPickerY.getValue();
                int result = x - y;
                txtResult.setText(String.valueOf(result));
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = numberPickerX.getValue();
                int y = numberPickerY.getValue();
                int result = x * y;
                txtResult.setText(String.valueOf(result));
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = numberPickerX.getValue();
                int y = numberPickerY.getValue();
                if (y != 0) {
                    int result = x / y;
                    txtResult.setText(String.valueOf(result));
                } else {
                    txtResult.setText("Error: Division by Zero");
                }
            }
        });

        btnMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = numberPickerX.getValue();
                int y = numberPickerY.getValue();
                if (y != 0) {
                    int result = x % y;
                    txtResult.setText(String.valueOf(result));
                } else {
                    txtResult.setText("Error: Division by Zero");
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initControl(); // Corrected method name

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
