package com.example.group13_f2019_mad3125_fp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;



import androidx.recyclerview.widget.RecyclerView;

public class PayrollAdapter extends RecyclerView.Adapter<PayrollAdapter.ViewHolder> {
    private Context context;
    private List<Employee> employeeList;
    private OnPayrollClicked onPayrollClicked;
    public PayrollAdapter(Context context, List<Employee> employeeList, OnPayrollClicked onPayrollClicked) {
        this.context = context;
        this.employeeList = employeeList;
        this.onPayrollClicked = onPayrollClicked;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_row_payrol_list, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(employee.getName()+" ("+employee.getAge()+")");
        holder.tvJob.setText(employee.getJob().getJobType());
        holder.tvVehicle.setText(employee.getVehicle().getIsA()+" : "+employee.getVehicle().getPlate());

    }
    @Override
    public int getItemCount() {

}