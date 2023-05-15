package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.Models.AppDetailModel;
import com.example.myapplication.Models.MainMenuModel;
import com.example.myapplication.RcycAdapters.AppManagmentAdapter;
import com.example.myapplication.RcycAdapters.MainMenuAdapter;
import com.example.myapplication.databinding.FragmentAppManagerBinding;
import com.example.myapplication.databinding.FragmentMainBinding;
import com.example.myapplication.databinding.ToolbarMainBinding;

import java.util.ArrayList;
import java.util.List;


public class AppManagerFragment extends Fragment {
    private TextView toolbarTitle;
    private Toolbar toolbar;
    FragmentAppManagerBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAppManagerBinding.inflate(inflater, container, false);

        toolbarTitle = binding.toolbar.textView3;
        toolbarTitle.setText("نرم افزارها");
        toolbar = binding.toolbar.tlbMain;
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);


        List<AppDetailModel> appDetailModels = new ArrayList<>();
        appDetailModels.add(new AppDetailModel("صندوقک", "13.1.0", "1401.2.2"));
        appDetailModels.add(new AppDetailModel("ویژیتو", "4.2", "1402.2.2"));
        appDetailModels.add(new AppDetailModel("سفارشگیر", "2.5", "1402.2.5"));
        appDetailModels.add(new AppDetailModel("سفارشگیر", "2.5", "1402.2.5"));
        appDetailModels.add(new AppDetailModel("سفارشگیر", "2.5", "1402.2.5"));
        appDetailModels.add(new AppDetailModel("سفارشگیر", "2.5", "1402.2.5"));
        appDetailModels.add(new AppDetailModel("سفارشگیر", "2.5", "1402.2.5"));
        appDetailModels.add(new AppDetailModel("سفارشگیر", "2.5", "1402.2.5"));
        appDetailModels.add(new AppDetailModel("سفارشگیر", "2.5", "1402.2.5"));
        appDetailModels.add(new AppDetailModel("سفارشگیر", "2.5", "1402.2.5"));
        appDetailModels.add(new AppDetailModel("سفارشگیر", "2.5", "1402.2.5"));
        appDetailModels.add(new AppDetailModel("سفارشگیر", "2.5", "1402.2.5"));


        AppManagmentAdapter appManagmentAdapter = new AppManagmentAdapter(appDetailModels, new AppManagmentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(AppDetailModel item, int position) {
                NavController navController = Navigation.findNavController(container);
                navController.navigate(R.id.action_appManagerFragment_to_appDetailFragment);
            }
        });
        binding.rclAppmanager.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        binding.rclAppmanager.setAdapter(appManagmentAdapter);

        binding.fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(container);
                navController.navigate(R.id.action_appManagerFragment_to_addAppFragment);

            }
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}