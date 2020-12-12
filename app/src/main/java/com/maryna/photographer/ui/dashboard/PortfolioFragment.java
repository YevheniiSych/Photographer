package com.maryna.photographer.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.maryna.photographer.R;

public class PortfolioFragment extends Fragment {

    private PortfolioViewModel portfolioViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_portfolio, container, false);
        init(root);
        return root;
    }

    private void init(View root){
        portfolioViewModel = new ViewModelProvider(this).get(PortfolioViewModel.class);
        portfolioViewModel.getText().observe(getViewLifecycleOwner(), s -> {});

    }
}