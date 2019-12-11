package com.example.group13_f2019_mad3125_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;


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

        tv_name.setText(employee.getName() + " (" + calculateAge() + ")");
        tv_earning.setText("Earning : " + calculateEarning());
        Vehicle vehicle = employee.getVehicle();
        if (vehicle == null) {
            tv_vehicle.setVisibility(View.GONE);
        } else {
            tv_vehicle.setText(vehicle.getMake() + " " + vehicle.getIsA() + " : " + vehicle.getPlate());
        }

    }

    private int calculateAge(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        return year - employee.getAge();
    }


    private double calculateEarning(){
        double earning = 0;
        Job job = employee.getJob();
        switch (job.getJobType()){
            case FULL_TIME:
                tv_job_type.setText(FULL_TIME);
                tv_job_one.setText("Salary : "+job.getSalary());
                tv_job_two.setText("Bonus : "+job.getBonus());
                tv_job_three.setVisibility(View.GONE);
                earning = job.getSalary()+job.getBonus();
                break;


}
}
