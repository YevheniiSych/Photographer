package com.maryna.photographer.ui.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maryna.photographer.R;
import com.maryna.photographer.model.PhotoSession;
import com.maryna.photographer.ui.holder.SessionItemViewHolder;

import java.util.List;

public class SessionItemAdapter extends RecyclerView.Adapter<SessionItemViewHolder> {

    private List<PhotoSession> photoSessions;

    public SessionItemAdapter(List<PhotoSession> photoSessions) {
        this.photoSessions = photoSessions;
    }

    @NonNull
    @Override
    public SessionItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.session_type_item, parent, false);
        return new SessionItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SessionItemViewHolder holder, int position) {
        holder.bindSessionItem(photoSessions.get(position));
    }

    @Override
    public int getItemCount() {
        return photoSessions.size();
    }
}
