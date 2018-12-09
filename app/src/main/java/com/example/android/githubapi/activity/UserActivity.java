package com.example.android.githubapi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.githubapi.R;
import com.example.android.githubapi.model.GithubUser;
import com.example.android.githubapi.rest.APIClient;
import com.example.android.githubapi.rest.GitHubUserEndPoints;
import com.squareup.picasso.Picasso;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {

    ImageView avatarImg;
    TextView userNameTv;
    TextView followersTv;
    TextView followingTv;
    TextView login;
    TextView email;
    //Button ownedRepos;

    Bundle extras;
    String newString;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitity_user);

        avatarImg = findViewById(R.id.avatar);
        userNameTv = findViewById(R.id.username);
        followersTv = findViewById(R.id.followers);
        followingTv = findViewById(R.id.following);
        login = findViewById(R.id.login);
        email = findViewById(R.id.email);
        // ownedRepos = findViewById(R.id.ownedreposBtn);

        extras = getIntent().getExtras();
        newString = extras.getString("String_need");

        loadData();

    }

    public void loadData() {

        //Getting instance of GitHubUserEndpointsInterface and getting the generated class
        final GitHubUserEndPoints apiService =
                APIClient.getClient().create(GitHubUserEndPoints.class);
        Call<GithubUser> call = apiService.getUser(newString);
        call.enqueue(new Callback<GithubUser>() {
            @Override
            public void onResponse(Call<GithubUser> call, Response<GithubUser> response) {


                //Image loading
                Picasso.get().load(response.body().getAvatar())
                        .resize(220, 220)
                        .into(avatarImg);

                //Rest of the body and text view loading
                if (response.body().getName() == null) {
                    userNameTv.setText("No name provided");
                } else {
                    userNameTv.setText("Username: " + response.body().getName());
                }

                followersTv.setText("Followers: " + response.body().getFollowers());
                followingTv.setText("Following: " + response.body().getFollowing());
                login.setText("Login: " + response.body().getLogin());

                if (response.body().getEmail() == null) {
                    email.setText("Email not provided");
                } else {
                    email.setText("Email: " + response.body().getEmail());
                }
            }

            @Override
            public void onFailure(Call<GithubUser> call, Throwable t) {

            }
        });
    }

    //Method for moving from UserActivity to Repositories

    public void loadownRepos(View view) {
        Intent intent = new Intent(UserActivity.this, Repositories.class);
        intent.putExtra("username", newString);
        startActivity(intent);
    }
}
