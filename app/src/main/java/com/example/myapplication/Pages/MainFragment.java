package com.example.myapplication.Pages;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Models.MainMenuModel;
import com.example.myapplication.R;
import com.example.myapplication.RcycAdapters.MainMenuAdapter;
import com.example.myapplication.databinding.FragmentMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    FragmentMainBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);

            ((AppCompatActivity) getActivity()).getSupportActionBar().hide();


        List<MainMenuModel> mainAdapterItems=new ArrayList<>();
        mainAdapterItems.add(new MainMenuModel("مشتریان","مدریت کاربران و افزودن اشتراک", R.drawable.ic_group,R.color.red_light));
        mainAdapterItems.add(new MainMenuModel("نرم افزارها","مدیریت نرم افزار های رسیس",R.drawable.ic_rasis_logo,R.color.lightButton));
        mainAdapterItems.add(new MainMenuModel("پلن ها","مدیریت پلن ",R.drawable.ic_list,R.color.green_light));
        mainAdapterItems.add(new MainMenuModel("'گزارش ها'","",R.drawable.ic_bar_chart,R.color.purple_light));

        MainMenuAdapter mainMenuAdapter=new MainMenuAdapter(mainAdapterItems, new MainMenuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(MainMenuModel item, int position) {
                switch (position){
                    case 0:
                        Navigation.findNavController(getView()).navigate(R.id.action_mainFragment_to_customerManagerFragment);
                        break;
                    case 1:
                        Navigation.findNavController(getView()).navigate(R.id.action_mainFragment_to_appManagerFragment);
                        break;
                    case 2:
                        Navigation.findNavController(getView()).navigate(R.id.action_mainFragment_to_planManagerFragment);

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