package com.example.danvantd.Presentation.Document_Demo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.danvantd.Domain.Model.News;
import com.example.danvantd.Presentation.DocumentDetail_Demo.DetailDocument_Acti;
import com.example.danvantd.Presentation.Document_Demo.ViewHolder.Document_ViewHolder;
import com.example.danvantd.R;

import java.util.List;

public class Document_Adapter extends RecyclerView.Adapter<Document_ViewHolder>{
    private List<News> list_News;
    private LayoutInflater minflater;
    private Context context;

    public Document_Adapter(Context context, List<News> list_News) {
        this.list_News = list_News;
        this.context = context;
        this.minflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Document_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = minflater.inflate(
                R.layout.item_document, parent, false);

        return new Document_ViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return list_News.size();
    }

    @Override
    public void onBindViewHolder(@NonNull Document_ViewHolder holder, int position) {
        News news = list_News.get(position);

        holder.updateUI(news);
        holder.ll_item_document.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoDetailDoc(list_News.get(holder.getAdapterPosition()));
            }
        });

    }

    private void gotoDetailDoc(News news){
        Intent intent = new Intent(context, DetailDocument_Acti.class);
        intent.putExtra("id", news.getId());
        intent.putExtra("type", "van-ban-cong-tac");
        context.startActivity(intent);
    }


}
