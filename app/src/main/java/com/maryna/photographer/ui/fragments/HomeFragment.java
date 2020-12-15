package com.maryna.photographer.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.maryna.photographer.MainActivity;
import com.maryna.photographer.R;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        TextView orderBtn = view.findViewById(R.id.orderPhotoSessionBtn);
        orderBtn.setOnClickListener(v -> ((MainActivity) getActivity()).getNavController().navigate(R.id.navigation_portfolio));
        super.onViewCreated(view, savedInstanceState);
    }
}