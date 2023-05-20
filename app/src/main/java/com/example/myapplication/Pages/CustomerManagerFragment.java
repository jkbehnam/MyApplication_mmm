package com.example.myapplication.Pages;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.Models.CustomerModel;
import com.example.myapplication.R;
import com.example.myapplication.RcycAdapters.CustomerManagmentAdapter;
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
        customerModels.add(new CustomerModel("محمد امین احمدی مقدم مقدم", "09133432650" ));
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


        CustomerManagmentAdapter appManagmentAdapter = new CustomerManagmentAdapter(customerModels,(item, position) -> {
            Navigation.findNavController(getView()).navigate(R.id.action_customerManagerFragment_to_customerDetailFragment);

        });
        binding.rclAppmanager.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        binding.rclAppmanager.setAdapter(appManagmentAdapter);

        binding.fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getView()).navigate(R.id.action_customerManagerFragment_to_customerAddFragment);

            }
        });

        return binding.getRoot();
    }
}