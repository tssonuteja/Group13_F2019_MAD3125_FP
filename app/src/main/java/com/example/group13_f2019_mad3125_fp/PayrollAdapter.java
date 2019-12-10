package com.example.group13_f2019_mad3125_fp;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PayrollAdapter extends RecyclerView.Adapter<PayrollAdapter.ViewHolder> {
    private Context context;
    private List<PayrollData> payrollDataList;
    private OnPayrollClicked onPayrollClicked;
    public PayrollAdapter(Context context, List<PayrollData> payrollDataList, OnPayrollClicked onPayrollClicked) {
        this.context = context;
        this.payrollDataList = payrollDataList;
        this.onPayrollClicked = onPayrollClicked;
    }

    @NonNull
    @Override
    public PayrollAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PayrollAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
