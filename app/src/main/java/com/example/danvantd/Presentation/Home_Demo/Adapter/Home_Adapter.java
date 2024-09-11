package com.example.danvantd.Presentation.Home_Demo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.danvantd.Domain.Model.Home;
import com.example.danvantd.Presentation.DetailPage_Demo.DetailNew_Demo_Acti;
import com.example.danvantd.Presentation.Home_Demo.ViewHolder.Home_ViewHolder;
import com.example.danvantd.R;

import java.util.List;

public class Home_Adapter extends RecyclerView.Adapter<Home_ViewHolder>{
    private List<Home> list_News;
    private LayoutInflater minflater;
    private Context context;

    public Home_Adapter(Context context, List<Home> list_News) {
        this.list_News = list_News;
        this.context = context;
        this.minflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Home_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = minflater.inflate(
                R.layout.item_home, parent, false);

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
        holder.ll_item_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoDetailPage(list_News.get(holder.getAdapterPosition()));
            }
        });

    }

    private void gotoDetailPage(Home home){
        Intent intent = new Intent(context, DetailNew_Demo_Acti.class);
        intent.putExtra("id", home.getId());
        context.startActivity(intent);
    }


}
