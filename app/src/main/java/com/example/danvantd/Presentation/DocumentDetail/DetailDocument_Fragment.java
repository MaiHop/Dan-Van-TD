package com.example.danvantd.Presentation.DocumentDetail;

import static android.graphics.Paint.UNDERLINE_TEXT_FLAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.danvantd.Domain.Model.News_Detail;
import com.example.danvantd.Presentation.DocumentDetail.Adapter.DetailNew_RelatedNews_Adapter;
import com.example.danvantd.Presentation.DocumentDetail.ViewModel.DetailDoc_ViewModel;
import com.example.danvantd.R;

public class DetailDocument_Fragment extends Fragment {
    private TextView tv_detaildoc_Tenvi, tv_detaildoc_Taive, tv_detaildoc_Noidungvi;
    private ImageView iv_detaildoc_Photo;
    private RecyclerView rv_detaildoc_RelatedNews;
    private DetailDoc_ViewModel detailDoc_viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_document_detail, container, false);
        init(view);

        if (getArguments() != null) {
            Bundle bundle = getArguments();
            int id =  bundle.getInt("id", -1);
            String type = bundle.getString("type", "");
            if (id != -1 && !type.equals("")) {
                detailDoc_viewModel = new ViewModelProvider(this).get(DetailDoc_ViewModel.class);
                detailDoc_viewModel.getDetailDocLiveData().observe(getViewLifecycleOwner(), new Observer<News_Detail>() {
                    @Override
                    public void onChanged(News_Detail documentDetail) {
                        showDetailNew(documentDetail);
                        tv_detaildoc_Taive.setOnClickListener(v -> dowloadVanBan(documentDetail));
                    }
                });
                detailDoc_viewModel.fetch_DetailDoc(type, id);
            }
        }

        return view;
    }

    private void showDetailNew(News_Detail doc) {
        tv_detaildoc_Tenvi.setText(doc.getTenvi());
        Glide.with(this)
                .load(doc.getPhoto())
                .placeholder(R.drawable.loading)
                .error(R.drawable.placeholder_image)
                .into(iv_detaildoc_Photo);

        tv_detaildoc_Noidungvi.setText(doc.getNoidungvi());
        showTinLienQuan(doc);
    }

    public void showTinLienQuan(News_Detail doc) {
        rv_detaildoc_RelatedNews.setLayoutManager(new LinearLayoutManager(getContext()));
        DetailNew_RelatedNews_Adapter adapter = new DetailNew_RelatedNews_Adapter(getContext(), doc.getNews());
        rv_detaildoc_RelatedNews.setAdapter(adapter);
    }

    public void dowloadVanBan(News_Detail doc) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(doc.getPhoto()));
        String title = URLUtil.guessFileName(doc.getPhoto(), null, null);
        request.setDescription("Đang tải ảnh về.....");
        String cookie = CookieManager.getInstance().getCookie(doc.getPhoto());
        request.addRequestHeader("cookie", cookie);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, title);

        DownloadManager downloadManager = (DownloadManager) getActivity().getSystemService(getContext().DOWNLOAD_SERVICE);
        downloadManager.enqueue(request);

        Toast.makeText(getContext(), "Đang tải ảnh về.....", Toast.LENGTH_SHORT).show();
    }

    private void init(View view) {
        //TextView
        tv_detaildoc_Tenvi = view.findViewById(R.id.tv_detaildoc_Tenvi);
        tv_detaildoc_Taive = view.findViewById(R.id.tv_detaildoc_Taive);
        tv_detaildoc_Taive.setPaintFlags(UNDERLINE_TEXT_FLAG);
        tv_detaildoc_Noidungvi = view.findViewById(R.id.tv_detaildoc_Noidungvi);
        //ImageView
        iv_detaildoc_Photo = view.findViewById(R.id.iv_detaildoc_Photo);
        //RecyclerView
        rv_detaildoc_RelatedNews = view.findViewById(R.id.rv_detaildoc_RelatedNews);
    }
}
