package com.maryna.photographer.ui.adpter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maryna.photographer.R;
import com.maryna.photographer.model.Photo;
import com.maryna.photographer.ui.holder.PhotoItemViewHolder;

import java.util.List;

public class PhotoItemAdapter extends RecyclerView.Adapter<PhotoItemViewHolder> {

    private List<Photo> photos;

    public PhotoItemAdapter(List<Photo> photos) {
        this.photos = photos;
    }

    @NonNull
    @Override
    public PhotoItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.detail_photo_item, parent, false);
        return new PhotoItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoItemViewHolder holder, int position) {
        holder.bind(photos.get(position));
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }
}
