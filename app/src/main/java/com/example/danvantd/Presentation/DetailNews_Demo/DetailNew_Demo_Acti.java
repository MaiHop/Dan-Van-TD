package com.example.danvantd.Presentation.DetailNews_Demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.danvantd.Domain.Model.News_Detail;
import com.example.danvantd.Domain.Model.Image;
import com.example.danvantd.Presentation.DetailNews_Demo.Adapter.DetailNew_Image_Adapter;
import com.example.danvantd.Presentation.DetailNews_Demo.Adapter.DetailNew_RelatedNews_Adapter;
import com.example.danvantd.Presentation.DetailNews_Demo.ViewModel.DetailNew_ViewModel;
import com.example.danvantd.R;

import java.util.ArrayList;
import java.util.List;

public class DetailNew_Demo_Acti extends AppCompatActivity {

    private TextView tv_detailnew_Tenvi,tv_detailnew_Noidungvi;
    private ImageView iv_detailnew_Photo;
    private RecyclerView rv_detailnew_Images,rv_detailnew_RelatedNews;
    private DetailNew_ViewModel detailNew_viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailnew_demo);

        init();

        Intent i = getIntent();
        int id = i.getIntExtra("id",-1);

        if (id!=-1){
            detailNew_viewModel = new ViewModelProvider(this).get(DetailNew_ViewModel.class);
            detailNew_viewModel.getDetailNewLiveData().observe(this, new Observer<News_Detail>() {
                @Override
                public void onChanged(News_Detail newsDetail) {
                    showDetailNew(newsDetail);
                }
            });
            detailNew_viewModel.fetch_DetailNew(id);
        }
    }

    private void showDetailNew(News_Detail newsDetail){
        tv_detailnew_Tenvi.setText(newsDetail.getTenvi());
        Glide.with(this)
                .load(newsDetail.getPhoto())
                .placeholder(R.drawable.loading) // ảnh hiển thị khi đang tải
                .error(R.drawable.placeholder_image)            // ảnh hiển thị khi có lỗi
                .into(iv_detailnew_Photo);

        showNoiDungvi(newsDetail);
        showTinLienQuan(newsDetail);
    }

    public void showNoiDungvi(News_Detail d){
        //Hiển thị nội dung

        String noidungvi = d.getNoidungvi();
        int indexOfFigure = noidungvi.indexOf("<figure");
        String contentBeforeFigure = "";
        if (indexOfFigure != -1) {
            contentBeforeFigure = noidungvi.substring(0, indexOfFigure);
        } else {
            contentBeforeFigure = noidungvi; // Không có thẻ <figure>
        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            tv_detailnew_Noidungvi.setText(Html.fromHtml(contentBeforeFigure, Html.FROM_HTML_MODE_LEGACY));
        } else {
            tv_detailnew_Noidungvi.setText(Html.fromHtml(contentBeforeFigure));
        }

        String contentAfterFigure = "";
        if (indexOfFigure != -1) {
            contentAfterFigure = noidungvi.substring(indexOfFigure, noidungvi.length());
        } else {
            contentAfterFigure = noidungvi; // Không có thẻ <figure>
        }

        //Hiển thị danh sách hình ảnh và content của ảnh
        String[] arr_img= contentAfterFigure.split("<p> </p>");
        List<Image> list_Image= new ArrayList<>();
        for(int i = 0; i<arr_img.length; i++){
//            Log.d("IMG_SRC: ", i+" "+arr_img[i]+"\n");
            if (!getSrcValue(arr_img[i]).equals("")){
                Image img = new Image();
                String img_src = getSrcValue(arr_img[i]);
                String img_contetn = getContent(arr_img[i]);
                img.setSrc(img_src);
                img.setContent(img_contetn);
                list_Image.add(img);
            }

        }
        if (!list_Image.isEmpty()){
            this.rv_detailnew_Images.setLayoutManager(new LinearLayoutManager(this));
            DetailNew_Image_Adapter adapter = new DetailNew_Image_Adapter(DetailNew_Demo_Acti.this, list_Image);
            this.rv_detailnew_Images.setAdapter(adapter);
        }
    }

    public void showTinLienQuan(News_Detail d){
        this.rv_detailnew_RelatedNews.setLayoutManager(new LinearLayoutManager(this));
        DetailNew_RelatedNews_Adapter adapter = new DetailNew_RelatedNews_Adapter(DetailNew_Demo_Acti.this, d.getNews());
        this.rv_detailnew_RelatedNews.setAdapter(adapter);
    }

    public String getSrcValue(String input) {
        String start = "src=\"";
        String end = "\"";

        int startIndex = input.indexOf(start);
        if (startIndex != -1) {
            startIndex += start.length();
            int endIndex = input.indexOf(end, startIndex);
            if (endIndex != -1) {
                return input.substring(startIndex, endIndex);
            }
        }
        return "";
    }
    public String getContent(String input) {
        String start = "<figcaption contenteditable=\"true\">";
        String end = "</ figcaption>";

        int startIndex = input.indexOf(start);
        if (startIndex != -1) {
            startIndex += start.length();
            int endIndex = input.indexOf(end, startIndex);
            if (endIndex != -1) {
                return input.substring(startIndex, endIndex);
            }
        }
        return "";
    }

    private void init(){
        //TextView
        tv_detailnew_Tenvi = findViewById(R.id.tv_detailnew_Tenvi);
        tv_detailnew_Noidungvi = findViewById(R.id.tv_detailnew_Noidungvi);
        //ImageView
        iv_detailnew_Photo = findViewById(R.id.iv_detailnew_Photo);
        //RecyclerView
        rv_detailnew_Images = findViewById(R.id.rv_detailnew_Images);
        rv_detailnew_RelatedNews = findViewById(R.id.rv_detailnew_RelatedNews);
    }
}