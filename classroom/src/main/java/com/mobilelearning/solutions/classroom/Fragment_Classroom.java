package com.mobilelearning.solutions.classroom;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_Classroom extends Fragment {

    private VMClassroom mViewModel;

    public static Fragment_Classroom newInstance() {
        return new Fragment_Classroom();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(VMClassroom.class);
        return inflater.inflate(R.layout.fragment_classroom, container, false);
    }
}