package com.example.myapplication.RcycAdapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.CustomerModel;
import com.example.myapplication.Models.PlanModel;
import com.example.myapplication.databinding.ItemListCustomerBinding;
import com.example.myapplication.databinding.ItemListPlanBinding;

import java.util.List;

public class PlanManagmentAdapter extends RecyclerView.Adapter<PlanManagmentAdapter.MyViewHolder> {
    private final List<PlanModel> dataList;
    OnItemClickListener onItemClickListener;
    Context context;

    public PlanManagmentAdapter(List<PlanModel> dataList, OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListPlanBinding binding = ItemListPlanBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        context = parent.getContext();

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        PlanModel data = dataList.get(position);
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
        private final ItemListPlanBinding binding;

        public MyViewHolder(ItemListPlanBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(PlanModel data) {
         //   binding.tvPlanName.setText(data.Name);
            binding.tvPlanName.setText(data.Name);
            binding.tvPlanDay.setText(String.valueOf(data.Days));


        }
    }

    public interface OnItemClickListener {
        void onItemClick(PlanModel item, int position);
    }
}




