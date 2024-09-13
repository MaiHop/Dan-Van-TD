package com.example.danvantd.Presentation.News;

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
import com.example.danvantd.Presentation.News.Adapter.Home_Adapter;
import com.example.danvantd.Presentation.News.ViewModel.Home_ViewModel;
import com.example.danvantd.R;

import java.util.List;

public class New_Fragment extends Fragment {
    private Home_ViewModel home_viewModel;
    private RecyclerView rv_home_News;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_news_demo, container, false);

        rv_home_News = view.findViewById(R.id.rv_home_News);

        this.rv_home_News.setLayoutManager(new LinearLayoutManager(getContext()));

        home_viewModel = new ViewModelProvider(this).get(Home_ViewModel.class);
        // Observe dữ liệu từ LiveData
        home_viewModel.getListNewsLiveData().observe(getViewLifecycleOwner(), new Observer<List<News>>() {
            @Override
            public void onChanged(List<News> newss) {
                if(!newss.isEmpty()){
                    Home_Adapter adapter = new Home_Adapter(requireContext(), newss);
                    rv_home_News.setAdapter(adapter);
                }
            }
        });

//         Gọi hàm để lấy dữ liệu
        home_viewModel.fetch_News("tin-tuc");

        return view;
    }
}
