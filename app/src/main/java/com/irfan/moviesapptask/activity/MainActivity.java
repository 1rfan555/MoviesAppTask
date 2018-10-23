package com.irfan.moviesapptask.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.irfan.moviesapptask.R;
import com.irfan.moviesapptask.client.ApiClient;
import com.irfan.moviesapptask.client.ApiInterface;
import com.irfan.moviesapptask.model.Movie;
import com.irfan.moviesapptask.model.MoviesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Movie> movies;

    private static final String TAG = MainActivity.class.getSimpleName();

    private final static String API_KEY = "3e48d40afcc1d7ea8e6f53753781ad43";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Insert API key", Toast.LENGTH_LONG).show();
            return;
        }



        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<MoviesResponse> call = apiService.getUpcomingMovies(API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {

            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {

            }
        });


    }
}
