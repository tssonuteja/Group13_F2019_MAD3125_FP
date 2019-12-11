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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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
    }


    // TODO: Rename and change types and number of parameters
    public static AddEmployeeFragment newInstance(String param1, String param2) {
        AddEmployeeFragment fragment = new AddEmployeeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
