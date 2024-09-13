package com.example.danvantd.Presentation.GuongDetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.danvantd.Domain.Model.News_Detail;
import com.example.danvantd.Presentation.DocumentDetail.Adapter.DetailNew_RelatedNews_Adapter;
import com.example.danvantd.Presentation.GuongDetail.ViewModel.DetailGuong_ViewModel;
import com.example.danvantd.R;

public class DetailGuong_Fragment extends Fragment {

    private TextView tv_detailguong_Tenvi,tv_detailguong_Noidungvi;
    private ImageView iv_detailguong_Photo;
    private RecyclerView rv_detailguong_RelatedNews;
    private DetailGuong_ViewModel detailGuong_viewModel;

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_guong_detail_demo, container, false);
        init();

        if (getArguments() != null) {
            Bundle bundle = getArguments();
            int id =  bundle.getInt("id", -1);
            String type = bundle.getString("type", "");
            if (id != -1 && !type.equals("")) {
                detailGuong_viewModel = new ViewModelProvider(this).get(DetailGuong_ViewModel.class);
                detailGuong_viewModel.getDetailGuongLiveData().observe(getViewLifecycleOwner(), new Observer<News_Detail>() {
                    @Override
                    public void onChanged(News_Detail documentDetail) {
                        showDetailNew(documentDetail);
                    }
                });
                detailGuong_viewModel.fetch_DetailGuong(type,id);
            }
        }

        return view;
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
        rv_detailguong_RelatedNews.setLayoutManager(new LinearLayoutManager(getContext()));
        DetailNew_RelatedNews_Adapter adapter = new DetailNew_RelatedNews_Adapter(getContext(), doc.getNews());
        rv_detailguong_RelatedNews.setAdapter(adapter);
    }
    private void init(){
        //TextView
        tv_detailguong_Tenvi = view.findViewById(R.id.tv_detailguong_Tenvi);
        tv_detailguong_Noidungvi = view.findViewById(R.id.tv_detailguong_Noidungvi);
        //ImageView
        iv_detailguong_Photo = view.findViewById(R.id.iv_detailguong_Photo);
        //RecyclerView
        rv_detailguong_RelatedNews = view.findViewById(R.id.rv_detailguong_RelatedNews);
    }
}
