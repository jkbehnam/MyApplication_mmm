package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.databinding.FragmentAddAppBinding;
import com.example.myapplication.databinding.FragmentSubscriptionAddBinding;


public class SubscriptionAddFragment extends Fragment {
    private TextView toolbarTitle;
    private Toolbar toolbar;
    FragmentSubscriptionAddBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSubscriptionAddBinding.inflate(inflater, container, false);

        toolbarTitle = binding.toolbar.textView3;
        toolbarTitle.setText("افزودن محصول");
        toolbar = binding.toolbar.tlbMain;
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);


        binding.subAddIfApp.setText("محصول");
        binding.subAddIfPlan.setText("نوع اشتراک");


        binding.subAddIfApp.setAdapter(new String[]{"Option 1", "Option 2", "Option 3"});
        binding.subAddIfPlan.setAdapter(new String[]{"Option 1", "Option 2", "Option 3"});
        return binding.getRoot();
    }
}