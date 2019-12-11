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
    }
}
