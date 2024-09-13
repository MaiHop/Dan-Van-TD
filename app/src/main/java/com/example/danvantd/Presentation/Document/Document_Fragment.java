package com.example.danvantd.Presentation.Document;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.danvantd.Domain.Model.News;
import com.example.danvantd.Presentation.Document.Adapter.Document_Adapter;
import com.example.danvantd.Presentation.Document.ViewModel.Document_ViewModel;
import com.example.danvantd.R;

import java.util.List;

public class Document_Fragment extends Fragment {
    private Document_ViewModel document_viewModel;
    private RecyclerView rv_document_News;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_document_demo, container, false);

        rv_document_News = view.findViewById(R.id.rv_document_News);

        this.rv_document_News.setLayoutManager(new LinearLayoutManager(getContext()));

        document_viewModel = new ViewModelProvider(this).get(Document_ViewModel.class);
        // Observe dữ liệu từ LiveData
        document_viewModel.getListNewsLiveData().observe(getViewLifecycleOwner(), new Observer<List<News>>() {
            @Override
            public void onChanged(List<News> news) {
                if(!news.isEmpty()){
                    Document_Adapter adapter = new Document_Adapter(requireContext(), news);
                    rv_document_News.setAdapter(adapter);
                }
            }
        });

//         Gọi hàm để lấy dữ liệu
        document_viewModel.fetch_Document("van-ban-cong-tac");

        return view;

    }
}
