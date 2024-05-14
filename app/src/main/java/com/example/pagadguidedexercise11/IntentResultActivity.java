package com.example.pagadguidedexercise11;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IntentResultActivity extends AppCompatActivity {

    TextView lblNameIntent, lblAgeIntent, lblGenderIntent, lblSubjectsIntent, lblJobIntent, lblThesisIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_result);
        init();
        showResults();
    }

    public void init(){
        lblNameIntent = findViewById(R.id.lblNameIntent);
        lblAgeIntent = findViewById(R.id.lblAgeIntent);
        lblGenderIntent = findViewById(R.id.lblGenderIntent);
        lblSubjectsIntent = findViewById(R.id.lblSubjectsIntent);
        lblJobIntent = findViewById(R.id.lblJobIntent);
        lblThesisIntent = findViewById(R.id.lblThesisIntent);
    }

    public void showResults(){
        lblNameIntent.setText("Name: " + getIntent().getStringExtra("id_name"));
        lblAgeIntent.setText("Age: " + getIntent().getStringExtra("id_age") + " years old");
        lblGenderIntent.setText("Gender: " +getIntent().getStringExtra("id_gender"));
        lblSubjectsIntent.setText("Subjects: \n" +getIntent().getStringExtra("id_subjects"));
        lblJobIntent.setText("Job: " +getIntent().getStringExtra("id_job"));
        lblThesisIntent.setText("Thesis Topic: " +getIntent().getStringExtra("id_thesis"));
    }


}

