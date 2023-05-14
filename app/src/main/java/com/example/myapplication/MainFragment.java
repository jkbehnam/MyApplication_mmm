package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Models.MainMenuModel;
import com.example.myapplication.RcycAdapters.MainMenuAdapter;
import com.example.myapplication.databinding.FragmentMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    FragmentMainBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);

        NavController navController = Navigation.findNavController(container);

        List<MainMenuModel> mainAdapterItems=new ArrayList<>();
        mainAdapterItems.add(new MainMenuModel("مدیریت کاربران","افزودن کاربر جدید دیدن کاربرهای قدیمی",R.drawable.ic_group));
        mainAdapterItems.add(new MainMenuModel("مدیریت نرم افزار ها","افزودن نرم افزار جدید",R.drawable.ic_key));
        mainAdapterItems.add(new MainMenuModel("آمار","",R.drawable.ic_person));
        mainAdapterItems.add(new MainMenuModel("تست","",R.drawable.ic_group));

        MainMenuAdapter mainMenuAdapter=new MainMenuAdapter(mainAdapterItems, new MainMenuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(MainMenuModel item, int position) {
                switch (position){
                    case 0:
                        break;
                    case 1:
                        navController.navigate(R.id.action_mainFragment_to_appManagerFragment);
                        break;
                    case 2:
                        break;
                }
            }
        });
        binding.mainRclMain.setLayoutManager(new GridLayoutManager(this.getActivity(),2));
        binding.mainRclMain.setAdapter(mainMenuAdapter);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}