package com.maryna.photographer.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.maryna.photographer.MainActivity;
import com.maryna.photographer.R;
import com.squareup.picasso.Picasso;

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

        ImageView mainPhoto = view.findViewById(R.id.mainPhoto);
        Picasso.get()
                .load("https://user-images.githubusercontent.com/66691210/102411508-b53d4f00-3ffa-11eb-9956-f3382b44b491.png")
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_loading)
                .fit()
                .into(mainPhoto);
        super.onViewCreated(view, savedInstanceState);
    }
}