
package com.maryna.photographer.ui.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.maryna.photographer.App;
import com.maryna.photographer.MainActivity;
import com.maryna.photographer.R;
import com.maryna.photographer.model.PhotoSession;
import com.maryna.photographer.ui.adpter.PhotoItemAdapter;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DetailFragment extends Fragment {

    static public String PHOTO_SESSION_ID = "PHOTO_SESSION_ID";

    private ImageView detailImage;
    private TextView detailTitle;
    private TextView detailDescription;
    private RecyclerView detailPhotos;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.detail_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    @SuppressLint("CheckResult")
    private void init(View view) {
//        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
//        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        setHasOptionsMenu(true);

        detailImage = view.findViewById(R.id.detailImage);
        detailTitle = view.findViewById(R.id.detailTitleText);
        detailDescription = view.findViewById(R.id.detailDescriptionText);
        detailPhotos = view.findViewById(R.id.detailsPhotos);

        if (getArguments() != null) {
            int sessionId = getArguments().getInt(PHOTO_SESSION_ID);
            App.getInstance().getDatabase().photoSessionDao().getPhotoSessionById(sessionId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::setUpViews);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home && getActivity() != null) {
            getActivity().onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("CheckResult")
    private void setUpViews(PhotoSession photoSession) {
        if (getActivity() != null) {
            Objects.requireNonNull(((MainActivity) getActivity()).getSupportActionBar()).setTitle(photoSession.getTitle());
        }
        detailTitle.setText(photoSession.getTitle());
        detailDescription.setText(photoSession.getDescription());
        Picasso.get()
                .load(photoSession.getPhotoURL())
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_loading)
                .fit()
                .into(detailImage);
        detailPhotos.setLayoutManager(new GridLayoutManager(getContext(), 2));
        App.getInstance().getDatabase().photoDao().getPhotosBySession(photoSession.getType())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(photos -> {
                    detailPhotos.setAdapter(new PhotoItemAdapter(photos));
                });
    }
}