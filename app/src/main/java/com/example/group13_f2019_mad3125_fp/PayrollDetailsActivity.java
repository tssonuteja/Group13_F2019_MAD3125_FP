package com.example.group13_f2019_mad3125_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;



public class PayrollDetailsActivity extends AppCompatActivity {
    Employee employee;
    TextView tv_job_one, tv_job_two, tv_job_three, tv_job_type, tv_vehicle, tv_earning, tv_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payroll_details);

        tv_job_three = findViewById(R.id.tv_job_three);
        tv_job_two = findViewById(R.id.tv_job_two);
        tv_job_one = findViewById(R.id.tv_job_one);
        tv_job_type = findViewById(R.id.tv_job_type);
        tv_vehicle = findViewById(R.id.tv_vehicle);
        tv_earning = findViewById(R.id.tv_earning);
        tv_name = findViewById(R.id.tv_name);
        int position = getIntent().getIntExtra("position", 0);
        employee = employeeList.get(position);

    }
}
