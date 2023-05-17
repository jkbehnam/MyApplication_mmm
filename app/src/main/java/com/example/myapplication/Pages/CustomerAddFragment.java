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
import com.example.myapplication.databinding.FragmentAddCustomerBinding;


public class CustomerAddFragment extends Fragment {
    private TextView toolbarTitle;
    private Toolbar toolbar;
    FragmentAddCustomerBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAddCustomerBinding.inflate(inflater, container, false);

        toolbarTitle = binding.toolbar.textView3;
        toolbarTitle.setText("مشتری جدید");
        toolbar = binding.toolbar.tlbMain;
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        binding.addCustomerIfName.setText("نام مشتری");
        binding.addCustomerIfMobile.setText("موبایل");
        binding.addCustomerIfUsername.setText("نام کاربری");
        binding.addCustomerIfPassword.setText("رمز عبور");
        return binding.getRoot();
    }
}