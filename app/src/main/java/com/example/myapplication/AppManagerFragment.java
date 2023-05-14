package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Models.AppDetailModel;
import com.example.myapplication.Models.MainMenuModel;
import com.example.myapplication.RcycAdapters.AppManagmentAdapter;
import com.example.myapplication.RcycAdapters.MainMenuAdapter;
import com.example.myapplication.databinding.FragmentAppManagerBinding;
import com.example.myapplication.databinding.FragmentMainBinding;

import java.util.ArrayList;
import java.util.List;


public class AppManagerFragment extends Fragment {

FragmentAppManagerBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAppManagerBinding.inflate(inflater, container, false);
        List<AppDetailModel> appDetailModels=new ArrayList<>();
        appDetailModels.add(new AppDetailModel("صندوقک","13.1.0","1401.2.2"));
        appDetailModels.add(new AppDetailModel("ویژیتو","4.2","1402.2.2"));
        appDetailModels.add(new AppDetailModel("سفارشگیر","2.5","1402.2.5"));

        AppManagmentAdapter appManagmentAdapter=new AppManagmentAdapter(appDetailModels, new AppManagmentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(AppDetailModel item, int position) {

            }
        });
        binding.rclAppmanager.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        binding.rclAppmanager.setAdapter(appManagmentAdapter);

        return binding.getRoot();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}