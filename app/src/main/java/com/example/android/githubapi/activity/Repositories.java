package com.example.android.githubapi.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.android.githubapi.Adapter.ReposAdapter;
import com.example.android.githubapi.R;
import com.example.android.githubapi.model.GithuRepo;
import com.example.android.githubapi.rest.APIClient;
import com.example.android.githubapi.rest.GitHubRepoEndPoints;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repositories extends AppCompatActivity {

    TextView usernameTv;
    String usernameRecieved;
    RecyclerView mRecyclerView;
    List<GithuRepo> myDatasource = new ArrayList<>();
    RecyclerView.Adapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repository_screen);

        Bundle extras = getIntent().getExtras();
        usernameRecieved = extras.getString("username");

        usernameTv = findViewById(R.id.username_tv);
        usernameTv.setText("User : " + usernameRecieved);

        mRecyclerView = findViewById(R.id.repos_recycle_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new ReposAdapter(myDatasource, R.id.repo_item_layout, getApplicationContext());
        mRecyclerView.setAdapter(myAdapter);

        loadRepositories();

    }

    private void loadRepositories() {
        final GitHubRepoEndPoints apiService =
                APIClient.getClient().create(GitHubRepoEndPoints.class);
        Call<List<GithuRepo>> call = apiService.getRepo(usernameRecieved);
        call.enqueue(new Callback<List<GithuRepo>>() {
            @Override
            public void onResponse(Call<List<GithuRepo>> call, Response<List<GithuRepo>> response) {
                myDatasource.clear();
                myDatasource.addAll(response.body());
                myAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<GithuRepo>> call, Throwable t) {
                Log.e("Repos", t.toString());

            }
        });
    }


}
