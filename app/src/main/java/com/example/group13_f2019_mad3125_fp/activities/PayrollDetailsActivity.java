package com.example.group13_f2019_mad3125_fp.activities;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.group13_f2019_mad3125_fp.R;
import com.example.group13_f2019_mad3125_fp.models.Employee;
import com.example.group13_f2019_mad3125_fp.models.Job;
import com.example.group13_f2019_mad3125_fp.models.Vehicle;

import java.util.Calendar;

import static com.example.group13_f2019_mad3125_fp.activities.MainActivity.COMMISSION_BASED;
import static com.example.group13_f2019_mad3125_fp.activities.MainActivity.FIXED_BASED;
import static com.example.group13_f2019_mad3125_fp.activities.MainActivity.FULL_TIME;
import static com.example.group13_f2019_mad3125_fp.activities.MainActivity.INTERN;
import static com.example.group13_f2019_mad3125_fp.activities.MainActivity.PART_TIME;
import static com.example.group13_f2019_mad3125_fp.activities.MainActivity.employeeList;

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

        tv_name.setText(employee.getName()+" ("+calculateAge()+")");
        tv_earning.setText("Earning : "+calculateEarning());
        Vehicle vehicle = employee.getVehicle();
        if (vehicle == null){
            tv_vehicle.setVisibility(View.GONE);
        } else {
            tv_vehicle.setText(vehicle.getMake()+" "+vehicle.getIsA()+" : "+vehicle.getPlate());
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
            case PART_TIME:
                if (job.getPartTimeType().equalsIgnoreCase(FIXED_BASED)){
                    tv_job_one.setText("Rate : "+job.getRate());
                    tv_job_two.setText("Hours worked : "+job.getHours());
                    tv_job_three.setText("Fixed amount : "+job.getFixed());
                    tv_job_type.setText(FIXED_BASED);
                    earning = job.getFixed()+(job.getRate()*job.getHours());
                } else {
                    tv_job_one.setText("Rate : "+job.getRate());
                    tv_job_two.setText("Hours worked : "+job.getHours());
                    tv_job_three.setText("Commission : "+job.getCommission());
                    tv_job_type.setText(COMMISSION_BASED);
                    earning = job.getCommission()+(job.getRate()*job.getHours());
                }
                break;
            case INTERN:
                tv_job_one.setText("School : "+job.getSchool());
                tv_job_two.setVisibility(View.GONE);
                tv_job_three.setVisibility(View.GONE);
                tv_job_type.setText(INTERN);
                break;
            default:
                break;
        }
        return earning;
    }
}
