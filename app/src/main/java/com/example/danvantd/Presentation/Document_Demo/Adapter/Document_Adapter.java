package com.example.danvantd.Presentation.Document_Demo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.danvantd.Domain.Model.Document;
import com.example.danvantd.Presentation.DocumentDetail_Demo.Document_Detail_Acti;
import com.example.danvantd.Presentation.Document_Demo.ViewHolder.Document_ViewHolder;
import com.example.danvantd.R;

import java.util.List;

public class Document_Adapter extends RecyclerView.Adapter<Document_ViewHolder>{
    private List<Document> list_Document;
    private LayoutInflater minflater;
    private Context context;

    public Document_Adapter(Context context, List<Document> list_Document) {
        this.list_Document = list_Document;
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
        return list_Document.size();
    }

    @Override
    public void onBindViewHolder(@NonNull Document_ViewHolder holder, int position) {
        Document document = list_Document.get(position);

        holder.updateUI(document);
        holder.ll_item_document.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoDetailDoc(list_Document.get(holder.getAdapterPosition()));
            }
        });

    }

    private void gotoDetailDoc(Document document){
        Intent intent = new Intent(context, Document_Detail_Acti.class);
        intent.putExtra("id", document.getId());
        context.startActivity(intent);
    }


}
