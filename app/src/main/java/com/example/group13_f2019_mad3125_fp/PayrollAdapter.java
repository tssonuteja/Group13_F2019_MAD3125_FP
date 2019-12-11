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


}