package com.irfan.moviesapptask.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.irfan.moviesapptask.R;

public class DetailsActivity extends AppCompatActivity {
    ImageView Poster;
    TextView tvTitle,tvDesc, tvRdate, tvVoteAvg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Poster = findViewById(R.id.moviePoster);
        tvTitle = findViewById(R.id.movieTitle);
        tvDesc = findViewById(R.id.movieDsc);
        tvRdate = findViewById(R.id.movieRdate);
        tvVoteAvg = findViewById(R.id.movieVAverage);

        Poster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailsActivity.this,MyActivity.class));
            }
        });
    }
}
