package com.example.myapplication.Pages;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentPlanAddBinding;


public class PlanAddFragment extends Fragment {

    private TextView toolbarTitle;
    private Toolbar toolbar;
    FragmentPlanAddBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentPlanAddBinding.inflate(inflater,container,false);

        toolbarTitle = binding.toolbar.textView3;
        toolbarTitle.setText("افزودن پلن");
        toolbar = binding.toolbar.tlbMain;
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        binding.addPlanIfName.setText("نام پلن");
        binding.addPlanIfDays.setText("تعداد روزها");
        binding.addPlanIfMaxdevice.setText("حداکثر تعداد دستگاه متصل");
        binding.addPlanIfDescription.setText("توضیحات");
        return binding.getRoot();
    }
}