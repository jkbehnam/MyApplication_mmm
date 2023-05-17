package com.example.myapplication.Pages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.Models.SubscriptionListModel;
import com.example.myapplication.R;
import com.example.myapplication.RcycAdapters.SubscriptonManagmentAdapter;
import com.example.myapplication.databinding.FragmentAppDetailBinding;
import com.example.myapplication.databinding.FragmentCustomerDetailBinding;

import java.util.ArrayList;
import java.util.List;


public class CustomerDetailFragment extends Fragment {
    FragmentCustomerDetailBinding binding;
    private TextView toolbarTitle;
    private Toolbar toolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCustomerDetailBinding.inflate(inflater, container, false);

        toolbarTitle = binding.toolbar.textView3;
        toolbarTitle.setText("اطلاعات مشتری");
        toolbar = binding.toolbar.tlbMain;
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        List<SubscriptionListModel> subscriptionListModels=new ArrayList<>();
        subscriptionListModels.add(new SubscriptionListModel(0l,"صندوقک","اشتراک 10 روزه","1402/2/2","1402/2/2",true));
        subscriptionListModels.add(new SubscriptionListModel(1l,"صندوقک","اشتراک 30 روزه","1401/1/1","1401/1/1",false));

        SubscriptonManagmentAdapter subscriptonManagmentAdapter=new SubscriptonManagmentAdapter(subscriptionListModels, new SubscriptonManagmentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(SubscriptionListModel item, int position) {

            }
        });

        binding.subRclc.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        binding.subRclc.setAdapter(subscriptonManagmentAdapter);

        binding.customerDetailsTvAddSubscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getView()).navigate(R.id.action_customerDetailFragment_to_subscriptionAddFragment);

            }
        });
        return binding.getRoot();
    }
}