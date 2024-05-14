package com.example.pagadguidedexercise11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText txtName, txtAge;
    RadioButton rdoMale, rdoFemale;
    CheckBox chkAPPDET, chkINTCOMP, chkCOMPROG1, chkCOMPROG2;
    Spinner spnJob;
    ListView lvThesis;
    Button btnSubmit;
    Intent intent;
    Adapter adapter;
    String[] jobList = {"Software Developer", "Software QA", "System Analyst", "Data Scientist"};
    String[] thesisTopics = {"Web Based/On-Line Application", "Network-Based Application ", "System/Software Development ", "Computer Aided Instruction "};
    String gender, subjects, topic = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        getThesis();
        displayResult();
    }

    public void init(){
        txtName =  findViewById(R.id.txtName);
        txtAge =  findViewById(R.id.txtAge);
        rdoMale =  findViewById(R.id.rdoMale);
        rdoFemale =  findViewById(R.id.rdoFemale);
        chkAPPDET = findViewById(R.id.chkAPPDET);
        chkINTCOMP = findViewById(R.id.chkINTCOMP);
        chkCOMPROG1 = findViewById(R.id.chkCOMPROG1);
        chkCOMPROG2 = findViewById(R.id.chkCOMPROG2);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Instantiation of intent Object
        intent = new Intent(this,IntentResultActivity.class);

        spnJob = findViewById(R.id.spnJob);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,jobList);
        spnJob.setAdapter((SpinnerAdapter) adapter);
        lvThesis = findViewById(R.id.lvThesis);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,thesisTopics);
        lvThesis.setAdapter((ListAdapter) adapter);
    }


    public void displayResult(){
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtName.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please enter your name",Toast.LENGTH_SHORT).show();
                    return;
                }else if(txtAge.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please enter your age",Toast.LENGTH_SHORT).show();
                    return;
                }else if(getSubjects().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please select at least 1 for your"+
                            " favorite subject",Toast.LENGTH_SHORT).show();
                    return;
                } else if(getThesis().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please select your Thesis Topic",Toast.LENGTH_SHORT).show();
                    return;
                }

                intent.putExtra("id_name",txtName.getText().toString());
                intent.putExtra("id_age",txtAge.getText().toString());
                intent.putExtra("id_gender",getGender());
                intent.putExtra("id_subjects",getSubjects());
                intent.putExtra("id_job",jobList[spnJob.getSelectedItemPosition()]);
                intent.putExtra("id_thesis",getThesis());
                startActivity(intent);
            }
        });
    }

    public String getSubjects(){
        subjects = "";
        if((!chkAPPDET.isChecked() && !chkINTCOMP.isChecked()) && (!chkCOMPROG1.isChecked() && !chkCOMPROG2.isChecked())){

        }
        else {
            if(chkAPPDET.isChecked()){
                subjects = subjects + chkAPPDET.getText().toString()+ "\n";
            }
            if(chkINTCOMP.isChecked()){
                subjects = subjects + chkINTCOMP.getText().toString()+ "\n";
            }
            if(chkCOMPROG1.isChecked()){
                subjects = subjects + chkCOMPROG1.getText().toString()+ "\n";
            }
            if(chkCOMPROG2.isChecked()){
                subjects = subjects + chkCOMPROG2.getText().toString()+ "\n";
            }
        }
        return subjects;
    }

    public String getGender(){
        if(rdoMale.isChecked()){
            gender = rdoMale.getText().toString();
        }else {
            gender = rdoFemale.getText().toString();
        }
        return gender;
    }

    public String getThesis(){
        lvThesis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"You select " + thesisTopics[position],
                        Toast.LENGTH_SHORT).show();
                topic = thesisTopics[position];
            }
        });
        return topic;
    }
}