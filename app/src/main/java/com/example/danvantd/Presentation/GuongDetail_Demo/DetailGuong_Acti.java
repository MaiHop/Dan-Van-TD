package com.example.danvantd.Presentation.GuongDetail_Demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.danvantd.Domain.Model.News_Detail;
import com.example.danvantd.Presentation.DocumentDetail_Demo.Adapter.DetailNew_RelatedNews_Adapter;
import com.example.danvantd.Presentation.GuongDetail_Demo.ViewModel.DetailGuong_ViewModel;
import com.example.danvantd.R;

public class DetailGuong_Acti extends AppCompatActivity {
    private TextView tv_detailguong_Tenvi,tv_detailguong_Noidungvi;
    private ImageView iv_detailguong_Photo;
    private RecyclerView rv_detailguong_RelatedNews;
    private DetailGuong_ViewModel detailGuong_viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guong_detail_demo);

        init();

        Intent i = getIntent();
        int id = i.getIntExtra("id",-1);
        String type = i.getStringExtra("type");
        if (id!=-1 && !type.equals("")){
            detailGuong_viewModel = new ViewModelProvider(this).get(DetailGuong_ViewModel.class);
            detailGuong_viewModel.getDetailGuongLiveData().observe(this, new Observer<News_Detail>() {
                @Override
                public void onChanged(News_Detail documentDetail) {
                    showDetailNew(documentDetail);
                }
            });
            detailGuong_viewModel.fetch_DetailGuong(type,id);
        }

    }

    private void showDetailNew(News_Detail doc){
        tv_detailguong_Tenvi.setText(doc.getTenvi());
        Glide.with(this)
                .load(doc.getPhoto())
                .placeholder(R.drawable.loading) // ảnh hiển thị khi đang tải
                .error(R.drawable.placeholder_image)            // ảnh hiển thị khi có lỗi
                .into(iv_detailguong_Photo);

        tv_detailguong_Noidungvi.setText(doc.getNoidungvi());
        showTinLienQuan(doc);
    }

    public void showTinLienQuan(News_Detail doc){
        this.rv_detailguong_RelatedNews.setLayoutManager(new LinearLayoutManager(this));
        DetailNew_RelatedNews_Adapter adapter = new DetailNew_RelatedNews_Adapter(DetailGuong_Acti.this, doc.getNews());
        this.rv_detailguong_RelatedNews.setAdapter(adapter);
    }
    private void init(){
        //TextView
        tv_detailguong_Tenvi = findViewById(R.id.tv_detailguong_Tenvi);
        tv_detailguong_Noidungvi = findViewById(R.id.tv_detailguong_Noidungvi);
        //ImageView
        iv_detailguong_Photo = findViewById(R.id.iv_detailguong_Photo);
        //RecyclerView
        rv_detailguong_RelatedNews = findViewById(R.id.rv_detailguong_RelatedNews);
    }
}