package com.example.group13_f2019_mad3125_fp.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.group13_f2019_mad3125_fp.R;

import java.util.Calendar;
import java.util.Date;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        Date currentTime = Calendar.getInstance().getTime();
        textView.setText(currentTime.toString());
        return root;
    }


}
