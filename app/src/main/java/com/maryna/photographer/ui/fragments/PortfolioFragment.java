package com.maryna.photographer.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.maryna.photographer.App;
import com.maryna.photographer.R;
import com.maryna.photographer.ui.adpter.SessionItemAdapter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PortfolioFragment extends Fragment {

    private RecyclerView sessionTypesList;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_portfolio, container, false);
        init(root);
        return root;
    }

    private void init(View root) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        sessionTypesList = root.findViewById(R.id.sessionTypesList);
        sessionTypesList.setLayoutManager(linearLayoutManager);

        App.getInstance().getDatabase().photoSessionDao().getAllPhotoSessions()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        photoSessions -> sessionTypesList.setAdapter(new SessionItemAdapter(photoSessions)),
                        error -> Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show()
                );
    }
}