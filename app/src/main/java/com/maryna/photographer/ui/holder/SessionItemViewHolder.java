package com.maryna.photographer.ui.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maryna.photographer.R;


public class SessionItemViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView orderBtn;
    private TextView detailBtn;
    private ImageView photo;

    public SessionItemViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.sessionTypeTitle);
        orderBtn = itemView.findViewById(R.id.orderPhotoSessionBtn);
        detailBtn = itemView.findViewById(R.id.moreDetailBtn);
        photo = itemView.findViewById(R.id.sessionTypePhoto);
    }

    public void bindSessionItem(){

    }
}
