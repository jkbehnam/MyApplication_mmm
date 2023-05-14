package com.example.myapplication.RcycAdapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.MainMenuModel;
import com.example.myapplication.databinding.MainListItemBinding;

import java.util.List;

public class UserManagmentAdapter extends RecyclerView.Adapter<UserManagmentAdapter.MyViewHolder> {
    private final List<MainMenuModel> dataList;
    OnItemClickListener onItemClickListener;
    Context context;

    public UserManagmentAdapter(List<MainMenuModel> dataList, OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MainListItemBinding binding = MainListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        context = parent.getContext();

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        MainMenuModel data = dataList.get(position);
        holder.binding.mainCv.setOnClickListener(new View.OnClickListener() {
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
        private final MainListItemBinding binding;

        public MyViewHolder(MainListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(MainMenuModel data) {
            binding.itemMainTvTitle.setText(data.title);
            binding.itemMainTvSubtitle.setText(data.subTitle);
            binding.itemMainImg.setImageResource(data.img);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(MainMenuModel item, int position);
    }
}




