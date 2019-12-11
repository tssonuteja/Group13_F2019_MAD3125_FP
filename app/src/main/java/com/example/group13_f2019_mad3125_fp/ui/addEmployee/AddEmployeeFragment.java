package com.example.group13_f2019_mad3125_fp.ui.addEmployee;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.group13_f2019_mad3125_fp.R;

public class AddEmployeeFragment extends Fragment {
    private RadioGroup rg_part_time, vehicle_layout;
    private LinearLayout part_time_layout, intern_layout, full_time_layout, vehicle_details_layout;
    private RadioButton rb_commission_based, rb_fixed_based, rb_part_time, rb_intern, rb_full_time, rbCar, rbBike;
    private CheckBox has_vehicle_check;
    EditText etName, etSalary, etBonus, etSchool, etRate, etHours, etCommission, etFixed, etMake, etPlate;
    EditText tvDob;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_add_employee, container, false);
        has_vehicle_check = root.findViewById(R.id.has_vehicle_check);
        rb_commission_based = root.findViewById(R.id.rb_commission_based);
        rb_fixed_based = root.findViewById(R.id.rb_fixed_based);
        rb_part_time = root.findViewById(R.id.rb_part_time);
        rb_intern = root.findViewById(R.id.rb_intern);
        rb_full_time = root.findViewById(R.id.rb_full_time);
        part_time_layout = root.findViewById(R.id.part_time_layout);
        intern_layout = root.findViewById(R.id.intern_layout);
        full_time_layout = root.findViewById(R.id.full_time_layout);
        rg_part_time = root.findViewById(R.id.rg_part_time);
        vehicle_layout = root.findViewById(R.id.vehicle_layout);
        vehicle_details_layout = root.findViewById(R.id.vehicle_details_layout);
        rbCar = root.findViewById(R.id.rb_car);
        rbBike = root.findViewById(R.id.rb_bike);
        etName = root.findViewById(R.id.et_name);
        etSalary = root.findViewById(R.id.et_salary);
        etBonus = root.findViewById(R.id.et_bonus);
        etSchool = root.findViewById(R.id.et_school);
        etRate = root.findViewById(R.id.et_rate);
        etHours = root.findViewById(R.id.et_hours);
        etCommission = root.findViewById(R.id.et_commission);
        etFixed = root.findViewById(R.id.et_fixed_amount);
        etMake = root.findViewById(R.id.et_make);
        etPlate = root.findViewById(R.id.et_plate);
        tvDob = root.findViewById(R.id.tv_dob);

        has_vehicle_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    vehicle_layout.setVisibility(View.VISIBLE);
                    vehicle_details_layout.setVisibility(View.VISIBLE);
                    rbCar.setChecked(true);
                } else {
                    vehicle_layout.setVisibility(View.GONE);
                    vehicle_details_layout.setVisibility(View.GONE);
                }
            }
        });


        rb_full_time.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    full_time_layout.setVisibility(View.VISIBLE);
                    etCommission.setVisibility(View.GONE);
                    etFixed.setVisibility(View.GONE);
                } else {
                    full_time_layout.setVisibility(View.GONE);
                    etCommission.setVisibility(View.GONE);
                    etFixed.setVisibility(View.GONE);
                }
            }
        });
        rb_intern.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    intern_layout.setVisibility(View.VISIBLE);
                    etCommission.setVisibility(View.GONE);
                    etFixed.setVisibility(View.GONE);
                } else {
                    intern_layout.setVisibility(View.GONE);
                    etCommission.setVisibility(View.GONE);
                    etFixed.setVisibility(View.GONE);
                }
            }
        });
        rb_part_time.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    part_time_layout.setVisibility(View.VISIBLE);
                    rg_part_time.setVisibility(View.VISIBLE);
                    part_time_layout.setVisibility(View.VISIBLE);
                    rb_commission_based.setChecked(true);
                }
                else {
                    part_time_layout.setVisibility(View.GONE);
                    part_time_layout.setVisibility(View.GONE);
                    rg_part_time.setVisibility(View.GONE);
                }
            }
        });
        rb_commission_based.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    etCommission.setVisibility(View.VISIBLE);
                } else {
                    etCommission.setVisibility(View.GONE);
                }
            }
        });
        rb_fixed_based.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    etFixed.setVisibility(View.VISIBLE);
                } else {
                    etFixed.setVisibility(View.GONE);
                }
            }
        });
        root.findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSaveClicked();
            }
        });

        return root;
    }
    private void onSaveClicked(){
        Employee employee = new Employee();
        Job job = new Job();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_employee, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
