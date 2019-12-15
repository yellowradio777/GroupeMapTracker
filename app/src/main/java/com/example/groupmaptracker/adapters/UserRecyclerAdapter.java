package com.example.groupmaptracker.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groupmaptracker.models.User;

import java.util.ArrayList;

import groupmaptracker.R;

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.ViewHolder> {

    private ArrayList<User> mUsers;
    private UserListRecyclerClickListener mClickListener;

    public UserRecyclerAdapter(ArrayList<User> users, UserListRecyclerClickListener mClickListener) {
        this.mUsers = users;
        this.mClickListener = mClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_user_list_item, parent, false);
        return new ViewHolder(view, mClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.username.setText(mUsers.get(position).getUsername());
        holder.email.setText(mUsers.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public interface UserListRecyclerClickListener {
        void onUserClicked(int position);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {
        TextView username, email;
        UserListRecyclerClickListener mClickListener;

        ViewHolder(View itemView, UserListRecyclerClickListener clickListener) {
            super(itemView);
            username = itemView.findViewById(R.id.username);
            email = itemView.findViewById(R.id.email);

            mClickListener = clickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mClickListener.onUserClicked(getAdapterPosition());
        }
    }
}
















