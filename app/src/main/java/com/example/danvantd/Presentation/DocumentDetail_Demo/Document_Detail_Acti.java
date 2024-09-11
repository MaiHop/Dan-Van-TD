package com.example.danvantd.Presentation.DocumentDetail_Demo;

import static android.graphics.Paint.UNDERLINE_TEXT_FLAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.danvantd.Domain.Model.Document_Detail;
import com.example.danvantd.Domain.Model.News_Detail;
import com.example.danvantd.Presentation.DetailNews_Demo.DetailNew_Demo_Acti;
import com.example.danvantd.Presentation.DetailNews_Demo.ViewModel.DetailNew_ViewModel;
import com.example.danvantd.Presentation.DocumentDetail_Demo.Adapter.DetailNew_RelatedNews_Adapter;
import com.example.danvantd.Presentation.DocumentDetail_Demo.ViewModel.DetailDoc_ViewModel;
import com.example.danvantd.R;

public class Document_Detail_Acti extends AppCompatActivity {
    private TextView tv_detaildoc_Tenvi,tv_detaildoc_Taive,tv_detaildoc_Noidungvi;
    private ImageView iv_detaildoc_Photo;
    private RecyclerView rv_detaildoc_RelatedNews;
    private DetailDoc_ViewModel detailDoc_viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_detail);

        init();

        Intent i = getIntent();
        int id = i.getIntExtra("id",-1);
//
        if (id!=-1){
            detailDoc_viewModel = new ViewModelProvider(this).get(DetailDoc_ViewModel.class);
            detailDoc_viewModel.getDetailDocLiveData().observe(this, new Observer<Document_Detail>() {
                @Override
                public void onChanged(Document_Detail documentDetail) {
//                    Log.d("OKOKOK", String.valueOf(documentDetail.getNews().size()));
                    showDetailNew(documentDetail);
                    tv_detaildoc_Taive.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dowloadVanBan(documentDetail);
                        }
                    });
                }
            });
            detailDoc_viewModel.fetch_DetailDoc(id);
        }
    }

    private void showDetailNew(Document_Detail doc){
        tv_detaildoc_Tenvi.setText(doc.getTenvi());
        Glide.with(this)
                .load(doc.getPhoto())
                .placeholder(R.drawable.loading) // ảnh hiển thị khi đang tải
                .error(R.drawable.placeholder_image)            // ảnh hiển thị khi có lỗi
                .into(iv_detaildoc_Photo);

        tv_detaildoc_Noidungvi.setText(doc.getNoidungvi());
        showTinLienQuan(doc);
    }

    public void showTinLienQuan(Document_Detail doc){
        this.rv_detaildoc_RelatedNews.setLayoutManager(new LinearLayoutManager(this));
        DetailNew_RelatedNews_Adapter adapter = new DetailNew_RelatedNews_Adapter(Document_Detail_Acti.this, doc.getNews());
        this.rv_detaildoc_RelatedNews.setAdapter(adapter);
    }

    public void dowloadVanBan(Document_Detail doc){
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(doc.getPhoto()));
        String title = URLUtil.guessFileName(doc.getPhoto(),null, null);
        request.setDescription("Đang tải ảnh về.....");
        String cookie = CookieManager.getInstance().getCookie(doc.getPhoto());
        request.addRequestHeader("cookie", cookie);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, title);

        DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        downloadManager.enqueue(request);

        Toast.makeText(Document_Detail_Acti.this, "Đang tải ảnh về.....", Toast.LENGTH_SHORT).show();
    }

    private void init(){
        //TextView
        tv_detaildoc_Tenvi = findViewById(R.id.tv_detaildoc_Tenvi);
        tv_detaildoc_Taive = findViewById(R.id.tv_detaildoc_Taive);
        tv_detaildoc_Taive.setPaintFlags( UNDERLINE_TEXT_FLAG);
        tv_detaildoc_Noidungvi = findViewById(R.id.tv_detaildoc_Noidungvi);
        //ImageView
        iv_detaildoc_Photo = findViewById(R.id.iv_detaildoc_Photo);
        //RecyclerView
        rv_detaildoc_RelatedNews = findViewById(R.id.rv_detaildoc_RelatedNews);
    }
}