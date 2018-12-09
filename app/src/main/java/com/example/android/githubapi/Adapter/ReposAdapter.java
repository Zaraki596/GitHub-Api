package com.example.android.githubapi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.githubapi.R;
import com.example.android.githubapi.model.GithuRepo;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ReposViewHolder> {
    private List<GithuRepo> repos;
    private int rowLayout;
    private Context mContext;

    public ReposAdapter(List<GithuRepo> repos, int rowLayout, Context context) {
        this.setRepos(repos);
        this.setRowLayout(rowLayout);
        this.setContext(context);
    }

    public List<GithuRepo> getRepos() {
        return repos;
    }

    public void setRepos(List<GithuRepo> repos) {
        this.repos = repos;
    }

    public int getRowLayout() {
        return rowLayout;
    }

    public void setRowLayout(int rowLayout) {
        this.rowLayout = rowLayout;
    }

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public ReposViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_repo, parent, false);
        return new ReposViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReposViewHolder holder, int position) {
        holder.repoName.setText(repos.get(position).getName());
        holder.repoDescription.setText(repos.get(position).getDescription());
        holder.repoLanguage.setText(repos.get(position).getLanguage());

    }

    @Override
    public int getItemCount() {
        return repos.size();
    }


    public static class ReposViewHolder extends RecyclerView.ViewHolder {
        LinearLayout reposLayout;
        TextView repoName;
        TextView repoDescription;
        TextView repoLanguage;

        public ReposViewHolder(@NonNull View itemView) {
            super(itemView);
            reposLayout = itemView.findViewById(R.id.repo_item_layout);
            repoName = itemView.findViewById(R.id.repo_name);
            repoDescription = itemView.findViewById(R.id.repo_descripton);
            repoLanguage = itemView.findViewById(R.id.repo_language);
        }
    }
}
