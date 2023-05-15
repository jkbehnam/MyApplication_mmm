package com.example.myapplication.RcycAdapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.AppDetailModel;
import com.example.myapplication.Models.MainMenuModel;
import com.example.myapplication.databinding.ItemListAppBinding;


import java.util.List;

public class AppManagmentAdapter extends RecyclerView.Adapter<AppManagmentAdapter.MyViewHolder> {
    private final List<AppDetailModel> dataList;
    OnItemClickListener onItemClickListener;
    Context context;

    public AppManagmentAdapter(List<AppDetailModel> dataList, OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListAppBinding binding = ItemListAppBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        context = parent.getContext();

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        AppDetailModel data = dataList.get(position);
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
        private final ItemListAppBinding binding;

        public MyViewHolder(ItemListAppBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(AppDetailModel data) {
            binding.tvAppName.setText(data.name);
            binding.tvAppVersion.setText(data.version);
            binding.tvAppReleaseDate.setText(data.releaseData);

        }
    }

    public interface OnItemClickListener {
        void onItemClick(AppDetailModel item, int position);
    }
}




