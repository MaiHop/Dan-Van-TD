package com.example.danvantd.Presentation.Home_Demo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.danvantd.Domain.Model.Home;
import com.example.danvantd.Presentation.Home_Demo.ViewHolder.Home_ViewHolder;
import com.example.danvantd.R;

import java.util.List;

public class Home_Adapter extends RecyclerView.Adapter<Home_ViewHolder>{
    private List<Home> list_News;
    private LayoutInflater minflater;

    public Home_Adapter(Context context, List<Home> list_News) {
        this.list_News = list_News;
        this.minflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Home_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = minflater.inflate(
                R.layout.item_news, parent, false);

        return new Home_ViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return list_News.size();
    }

    @Override
    public void onBindViewHolder(@NonNull Home_ViewHolder holder, int position) {
        Home home = list_News.get(position);

        holder.updateUI(home);

    }


}
