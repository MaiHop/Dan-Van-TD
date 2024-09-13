package com.example.danvantd.Presentation.Guong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.danvantd.Domain.Model.News;
import com.example.danvantd.Presentation.Guong.Adapter.Guong_Adapter;
import com.example.danvantd.Presentation.Guong.ViewModel.Guong_ViewModel;
import com.example.danvantd.R;

import java.util.List;

public class Guong_Acti extends AppCompatActivity {
    private Guong_ViewModel guong_viewModel;
    private RecyclerView rv_guong_News;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guong_demo);

        rv_guong_News = findViewById(R.id.rv_guong_News);

        this.rv_guong_News.setLayoutManager(new LinearLayoutManager(this));

        guong_viewModel = new ViewModelProvider(this).get(Guong_ViewModel.class);
        // Observe dữ liệu từ LiveData
        guong_viewModel.getListNewsLiveData().observe(this, new Observer<List<News>>() {
            @Override
            public void onChanged(List<News> newss) {
                if(!newss.isEmpty()){
                    Guong_Adapter adapter = new Guong_Adapter(Guong_Acti.this, newss);
                    rv_guong_News.setAdapter(adapter);
                }
            }
        });

//         Gọi hàm để lấy dữ liệu
        guong_viewModel.fetch_News("guong-dien-hinh");
    }
}