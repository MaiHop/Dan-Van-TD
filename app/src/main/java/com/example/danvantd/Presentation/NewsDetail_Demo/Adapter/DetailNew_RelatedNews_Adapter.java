package com.example.danvantd.Presentation.NewsDetail_Demo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.danvantd.Domain.Model.RelatedNews;
import com.example.danvantd.Presentation.NewsDetail_Demo.DetailNew_Demo_Acti;
import com.example.danvantd.Presentation.NewsDetail_Demo.ViewHolder.DetailNew_RelatedNews_ViewHolder;
import com.example.danvantd.R;

import java.util.List;

public class DetailNew_RelatedNews_Adapter extends RecyclerView.Adapter<DetailNew_RelatedNews_ViewHolder>{
    private List<RelatedNews> list_news;
    private LayoutInflater minflater;

    private Context context;

    public DetailNew_RelatedNews_Adapter(Context context, List<RelatedNews> list_news) {
        this.list_news = list_news;
        this.context = context;
        this.minflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public DetailNew_RelatedNews_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = minflater.inflate(
                R.layout.item_detailnew_related_news, parent, false);

        return new DetailNew_RelatedNews_ViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return list_news.size();
    }

    @Override
    public void onBindViewHolder(@NonNull DetailNew_RelatedNews_ViewHolder holder, int position) {
        RelatedNews n = list_news.get(position);

        holder.updateUI(n);

        holder.ll_detailnew_RelatedNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoDetailPage(list_news.get(holder.getAdapterPosition()));
            }
        });

    }
    private void gotoDetailPage(RelatedNews n){
        Intent intent = new Intent(context, DetailNew_Demo_Acti.class);
        intent.putExtra("id", n.getId());
        intent.putExtra("type", "tin-tuc");
        context.startActivity(intent);
    }

}
