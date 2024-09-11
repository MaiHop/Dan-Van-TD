package com.example.danvantd.Presentation.News_Demo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.danvantd.Domain.Model.News;
import com.example.danvantd.Presentation.NewsDetail_Demo.DetailNew_Demo_Acti;
import com.example.danvantd.Presentation.News_Demo.ViewHolder.Home_ViewHolder;
import com.example.danvantd.R;

import java.util.List;

public class Home_Adapter extends RecyclerView.Adapter<Home_ViewHolder>{
    private List<News> list_News;
    private LayoutInflater minflater;
    private Context context;

    public Home_Adapter(Context context, List<News> list_News) {
        this.list_News = list_News;
        this.context = context;
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
        News news = list_News.get(position);

        holder.updateUI(news);
        holder.ll_item_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoDetailPage(list_News.get(holder.getAdapterPosition()));
            }
        });

    }

    private void gotoDetailPage(News news){
        Intent intent = new Intent(context, DetailNew_Demo_Acti.class);
        intent.putExtra("id", news.getId());
        intent.putExtra("type", "tin-tuc");
        context.startActivity(intent);
    }


}
