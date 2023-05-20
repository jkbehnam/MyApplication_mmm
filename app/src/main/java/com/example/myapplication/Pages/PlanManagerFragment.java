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

import com.example.myapplication.Models.PlanModel;
import com.example.myapplication.R;
import com.example.myapplication.RcycAdapters.PlanManagmentAdapter;
import com.example.myapplication.databinding.FragmentPlanManagerBinding;

import java.util.ArrayList;
import java.util.List;

public class PlanManagerFragment extends Fragment {
    private TextView toolbarTitle;
    private Toolbar toolbar;
FragmentPlanManagerBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding =FragmentPlanManagerBinding.inflate(inflater,container,false);
        toolbarTitle = binding.toolbar.textView3;
        toolbarTitle.setText("پلن ها");
        toolbar = binding.toolbar.tlbMain;
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        List<PlanModel> planModels = new ArrayList<>();
        planModels.add(new PlanModel(1,"اشتراک 10 روزه","",10,5));
        planModels.add(new PlanModel(1,"اشتراک 30 روزه","",30,5));
        planModels.add(new PlanModel(1,"اشتراک 60 روزه","",60,5));


        PlanManagmentAdapter planManagmentAdapter=new PlanManagmentAdapter(planModels, new PlanManagmentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(PlanModel item, int position) {

            }
        });
        binding.rclPlanmanager.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        binding.rclPlanmanager.setAdapter(planManagmentAdapter);

        binding.fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getView()).navigate(R.id.action_planManagerFragment_to_planAddFragment);

            }
        });

        return binding.getRoot();
    }
}