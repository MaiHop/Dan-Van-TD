package com.example.danvantd.Presentation.Document_Demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.danvantd.Domain.Model.Document;
import com.example.danvantd.Domain.Model.Home;
import com.example.danvantd.Presentation.Document_Demo.Adapter.Document_Adapter;
import com.example.danvantd.Presentation.Document_Demo.ViewModel.Document_ViewModel;
import com.example.danvantd.Presentation.Home_Demo.Adapter.Home_Adapter;
import com.example.danvantd.Presentation.Home_Demo.Home_Demo_Acti;
import com.example.danvantd.Presentation.Home_Demo.ViewModel.Home_ViewModel;
import com.example.danvantd.R;

import java.util.List;

public class Document_Demo_Acti extends AppCompatActivity {
    private Document_ViewModel document_viewModel;
    private RecyclerView rv_document_News;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_demo);

        rv_document_News = findViewById(R.id.rv_document_News);

        this.rv_document_News.setLayoutManager(new LinearLayoutManager(this));

        document_viewModel = new ViewModelProvider(this).get(Document_ViewModel.class);
        // Observe dữ liệu từ LiveData
        document_viewModel.getListNewsLiveData().observe(this, new Observer<List<Document>>() {
            @Override
            public void onChanged(List<Document> documents) {
                if(!documents.isEmpty()){
                    Document_Adapter adapter = new Document_Adapter(Document_Demo_Acti.this, documents);
                    rv_document_News.setAdapter(adapter);
                }
            }
        });

//         Gọi hàm để lấy dữ liệu
        document_viewModel.fetch_Document();
    }
}