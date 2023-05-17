package com.example.myapplication.Pages;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentAddAppBinding;


public class AppAddFragment extends Fragment {

    private TextView toolbarTitle;
    private Toolbar toolbar;
FragmentAddAppBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddAppBinding.inflate(inflater, container, false);

        toolbarTitle = binding.toolbar.textView3;
        toolbarTitle.setText("افزودن محصول");
        toolbar = binding.toolbar.tlbMain;
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        binding.addAppIfName.setText("نام محصول");
        binding.addAppIfDescription.setText("توضیحات محصول");

        return  binding.getRoot();
    }
}