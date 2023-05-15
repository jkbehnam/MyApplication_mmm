package com.example.myapplication.RcycAdapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.CustomerModel;
import com.example.myapplication.Models.MainMenuModel;
import com.example.myapplication.databinding.ItemListCustomerBinding;
import com.example.myapplication.databinding.ItemListMainBinding;



import java.util.List;

public class CustomerManagmentAdapter extends RecyclerView.Adapter<CustomerManagmentAdapter.MyViewHolder> {
    private final List<CustomerModel> dataList;
    OnItemClickListener onItemClickListener;
    Context context;

    public CustomerManagmentAdapter(List<CustomerModel> dataList, OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListCustomerBinding binding = ItemListCustomerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        context = parent.getContext();

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        CustomerModel data = dataList.get(position);
        holder.binding.appItemLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(data, position);
            }
        });
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final ItemListCustomerBinding binding;

        public MyViewHolder(ItemListCustomerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(CustomerModel data) {
            binding.tvCustomerName.setText(data.name);
            binding.tvCustomerMobile.setText(data.mobile);

        }
    }

    public interface OnItemClickListener {
        void onItemClick(CustomerModel item, int position);
    }
}




