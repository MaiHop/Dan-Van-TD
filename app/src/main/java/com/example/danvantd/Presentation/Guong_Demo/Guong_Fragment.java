package com.example.danvantd.Presentation.Guong_Demo;

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
import com.example.danvantd.Presentation.Guong_Demo.Adapter.Guong_Adapter;
import com.example.danvantd.Presentation.Guong_Demo.ViewModel.Guong_ViewModel;
import com.example.danvantd.R;

import java.util.List;

public class Guong_Fragment extends Fragment {
    private Guong_ViewModel guong_viewModel;
    private RecyclerView rv_guong_News;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_guong_demo, container, false);

        rv_guong_News = view.findViewById(R.id.rv_guong_News);

        this.rv_guong_News.setLayoutManager(new LinearLayoutManager(getContext()));

        guong_viewModel = new ViewModelProvider(this).get(Guong_ViewModel.class);
        // Observe dữ liệu từ LiveData
        guong_viewModel.getListNewsLiveData().observe(getViewLifecycleOwner(), new Observer<List<News>>() {
            @Override
            public void onChanged(List<News> newss) {
                if(!newss.isEmpty()){
                    Guong_Adapter adapter = new Guong_Adapter(requireContext(), newss);
                    rv_guong_News.setAdapter(adapter);
                }
            }
        });

//         Gọi hàm để lấy dữ liệu
        guong_viewModel.fetch_News("guong-dien-hinh");

        return view;
    }
}
