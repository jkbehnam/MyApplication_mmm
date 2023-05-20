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

import com.example.myapplication.Models.ApiModel.ApiGetAppListModel;
import com.example.myapplication.Pages.Presenters.AppManagerPresenter;
import com.example.myapplication.R;
import com.example.myapplication.RcycAdapters.AppManagmentAdapter;
import com.example.myapplication.databinding.FragmentAppManagerBinding;

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
        AppManagerPresenter appManagerPresenter = new AppManagerPresenter(this);

        toolbarTitle = binding.toolbar.textView3;
        toolbarTitle.setText("نرم افزارها");
        toolbar = binding.toolbar.tlbMain;
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);


//        List<ApiGetAppListModel> appDetailModels = new ArrayList<>();
//        appDetailModels.add(new ApiGetAppListModel("صندوقک", "13.1.0", 1684416642000l));
//        appDetailModels.add(new ApiGetAppListModel("ویژیتو", "4.2", 1684416642000l));
//        appDetailModels.add(new ApiGetAppListModel("سفارشگیر", "2.5", 1684416642000l));


        appManagerPresenter.getAllApps();

        binding.fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getView()).navigate(R.id.action_appManagerFragment_to_addAppFragment);

            }
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void updateList(List<ApiGetAppListModel> apiGetAppListModels) {
        AppManagmentAdapter appManagmentAdapter = new AppManagmentAdapter(apiGetAppListModels, new AppManagmentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ApiGetAppListModel item, int position) {
                Navigation.findNavController(getView()).navigate(R.id.action_appManagerFragment_to_appDetailFragment);
            }
        });
        binding.rclAppmanager.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        binding.rclAppmanager.setAdapter(appManagmentAdapter);

    }
}