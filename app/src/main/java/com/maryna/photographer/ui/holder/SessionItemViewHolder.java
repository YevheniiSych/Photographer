package com.maryna.photographer.ui.holder;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.maryna.photographer.MainActivity;
import com.maryna.photographer.R;
import com.maryna.photographer.model.PhotoSession;
import com.squareup.picasso.Picasso;

import static com.maryna.photographer.ui.fragments.DetailFragment.PHOTO_SESSION_ID;


public class SessionItemViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView orderBtn;
    private TextView detailBtn;
    private ImageView photo;
    private FragmentActivity activity;

    public SessionItemViewHolder(@NonNull View itemView, FragmentActivity activity) {
        super(itemView);
        this.activity = activity;
        title = itemView.findViewById(R.id.sessionTypeTitle);
        orderBtn = itemView.findViewById(R.id.orderPhotoSessionBtn);
        detailBtn = itemView.findViewById(R.id.moreDetailBtn);
        photo = itemView.findViewById(R.id.sessionTypePhoto);
    }

    public void bindSessionItem(PhotoSession photoSession) {
        title.setText(photoSession.getTitle());

        Picasso.get()
                .load(photoSession.getPhotoURL())
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_loading)
                .into(photo);

        orderBtn.setTag(photoSession.getSessionId());
        orderBtn.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putInt(PHOTO_SESSION_ID, ((int) view.getTag()));
            ((MainActivity) activity).getNavController().navigate(R.id.selectPackageFragment, bundle);
        });

        detailBtn.setTag(photoSession.getSessionId()); //сохраняем id фото сессии в теге кнопки
        detailBtn.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putInt(PHOTO_SESSION_ID, ((int) view.getTag()));
            ((MainActivity) activity).getNavController().navigate(R.id.detailFragment, bundle);
        });
    }

}
