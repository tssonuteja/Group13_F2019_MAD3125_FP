package com.example.group13_f2019_mad3125_fp.ui.listPayroll;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.group13_f2019_mad3125_fp.PayrollAdapter;
import com.example.group13_f2019_mad3125_fp.PayrollDetailsActivity;
import com.example.group13_f2019_mad3125_fp.R;
import com.example.group13_f2019_mad3125_fp.interfaces.OnPayrollClicked;

import static com.example.group13_f2019_mad3125_fp.MainActivity.employeeList;



public class ListPayrollFragment extends Fragment {

    private RecyclerView payroll_list;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list_payroll, container, false);
        payroll_list = root.findViewById(R.id.payroll_list);

        setAdapter();
        return root;
    }

    private void setAdapter() {

        PayrollAdapter adapter = new PayrollAdapter(getActivity(), employeeList, new OnPayrollClicked() {
            @Override
            public void onPayrollClicked(int position) {
                Intent intent = new Intent(getActivity(), PayrollDetailsActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });

        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        payroll_list.setLayoutManager(manager);
        payroll_list.setAdapter(adapter);
    }

}

