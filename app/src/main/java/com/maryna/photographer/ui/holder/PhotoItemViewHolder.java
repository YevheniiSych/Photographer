package com.maryna.photographer.ui.holder;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maryna.photographer.R;
import com.maryna.photographer.model.Photo;
import com.squareup.picasso.Picasso;

public class PhotoItemViewHolder extends RecyclerView.ViewHolder {

    private ImageView photoView;

    public PhotoItemViewHolder(@NonNull View itemView) {
        super(itemView);
        photoView = itemView.findViewById(R.id.detailPhoto);
    }

    public void bind(Photo photo){
        Picasso.get()
                .load(photo.getPhotoUrl())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(photoView);
    }
}
