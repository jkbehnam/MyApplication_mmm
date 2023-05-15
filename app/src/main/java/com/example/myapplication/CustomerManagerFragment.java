package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.Models.AppDetailModel;
import com.example.myapplication.Models.CustomerModel;
import com.example.myapplication.RcycAdapters.AppManagmentAdapter;
import com.example.myapplication.RcycAdapters.CustomerManagmentAdapter;
import com.example.myapplication.databinding.FragmentAppManagerBinding;
import com.example.myapplication.databinding.FragmentCustomerManagerBinding;

import java.util.ArrayList;
import java.util.List;

public class CustomerManagerFragment extends Fragment {
    private TextView toolbarTitle;
    private Toolbar toolbar;
    FragmentCustomerManagerBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCustomerManagerBinding.inflate(inflater, container, false);

        toolbarTitle = binding.toolbar.textView3;
        toolbarTitle.setText("مشتریان");
        toolbar = binding.toolbar.tlbMain;
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        List<CustomerModel> customerModels = new ArrayList<>();
        customerModels.add(new CustomerModel("محمد احمدی مقدم مقدم", "09133432650" ));
        customerModels.add(new CustomerModel("محمد احمدی مقدم", "09133432650" ));
        customerModels.add(new CustomerModel("محمد احمدی مقدم", "09133432650" ));
        customerModels.add(new CustomerModel("محمد احمدی مقدم", "09133432650" ));
        customerModels.add(new CustomerModel("محمد احمدی مقدم", "09133432650" ));
        customerModels.add(new CustomerModel("محمد احمدی مقدم", "09133432650" ));
        customerModels.add(new CustomerModel("محمد احمدی مقدم", "09133432650" ));
        customerModels.add(new CustomerModel("محمد احمدی مقدم", "09133432650" ));
        customerModels.add(new CustomerModel("محمد احمدی مقدم", "09133432650" ));
        customerModels.add(new CustomerModel("محمد احمدی مقدم", "09133432650" ));
        customerModels.add(new CustomerModel("محمد احمدی مقدم", "09133432650" ));


        CustomerManagmentAdapter appManagmentAdapter = new CustomerManagmentAdapter(customerModels,(item, position) -> {});
        binding.rclAppmanager.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        binding.rclAppmanager.setAdapter(appManagmentAdapter);

        return binding.getRoot();
    }
}