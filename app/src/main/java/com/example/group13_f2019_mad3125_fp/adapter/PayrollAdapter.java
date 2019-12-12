package com.example.group13_f2019_mad3125_fp.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.group13_f2019_mad3125_fp.R;
import com.example.group13_f2019_mad3125_fp.interfaces.OnPayrollClicked;
import com.example.group13_f2019_mad3125_fp.models.Employee;

import java.util.List;

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
        Employee employee = employeeList.get(position);
        holder.tvName.setText(employee.getName()+" ("+employee.getAge()+")");
        holder.tvJob.setText(employee.getJob().getJobType());
        holder.tvVehicle.setText(employee.getVehicle().getIsA()+" : "+employee.getVehicle().getPlate());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvJob, tvVehicle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvJob   = itemView.findViewById(R.id.tv_job);
            tvVehicle = itemView.findViewById(R.id.tv_vehicle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onPayrollClicked.onPayrollClicked(getAdapterPosition());
                }
            });
        }
    }
}
