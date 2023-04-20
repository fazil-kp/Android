package com.example.lab;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup genderGroup;
    private RadioButton maleButton;
    private RadioButton femaleButton;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        genderGroup = findViewById(R.id.gender_group);
        maleButton = findViewById(R.id.male_button);
        femaleButton = findViewById(R.id.female_button);
        submitButton = findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = genderGroup.getCheckedRadioButtonId();

                if (selectedId == maleButton.getId()) {
                    Toast.makeText(MainActivity.this, "You selected Male", Toast.LENGTH_SHORT).show();
                } else if (selectedId == femaleButton.getId()) {
                    Toast.makeText(MainActivity.this, "You selected Female", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please select a gender", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}