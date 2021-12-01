package com.example.ichat.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ichat.Models.Users;
import com.example.ichat.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder>{

    ArrayList<Users> list;
    Context context;

    public UsersAdapter(ArrayList<Users> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_show_user , parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Users users = list.get(position);
            Picasso.get().load(users.getProfilepic()).placeholder(R.drawable.user).into(holder.image);
        holder.userName.setText(users.getUseraName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView userName,lastMessage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.profile_image);
            userName = itemView.findViewById(R.id.userNamelist);
            lastMessage = itemView.findViewById(R.id.lastMessage);
        }
    }
}

