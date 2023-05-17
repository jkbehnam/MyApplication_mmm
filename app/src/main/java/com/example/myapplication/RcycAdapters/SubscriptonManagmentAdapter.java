package com.example.myapplication.RcycAdapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.CustomerModel;
import com.example.myapplication.Models.SubscriptionListModel;
import com.example.myapplication.databinding.ItemListCustomerBinding;
import com.example.myapplication.databinding.ItemListSubscriptionBinding;

import java.util.List;

public class SubscriptonManagmentAdapter extends RecyclerView.Adapter<SubscriptonManagmentAdapter.MyViewHolder> {
    private final List<SubscriptionListModel> dataList;
    OnItemClickListener onItemClickListener;
    Context context;

    public SubscriptonManagmentAdapter(List<SubscriptionListModel> dataList, OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListSubscriptionBinding binding = ItemListSubscriptionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        context = parent.getContext();

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        SubscriptionListModel data = dataList.get(position);
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
        private final ItemListSubscriptionBinding binding;

        public MyViewHolder(ItemListSubscriptionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(SubscriptionListModel data) {
            binding.tvAppName.setText(data.AppName);
            binding.tvAppName.setText(data.SubName);
            binding.tvSubStart.setText(data.StartDate);
            binding.tvSubEnd.setText(data.EndDate);

        }
    }

    public interface OnItemClickListener {
        void onItemClick(SubscriptionListModel item, int position);
    }
}




