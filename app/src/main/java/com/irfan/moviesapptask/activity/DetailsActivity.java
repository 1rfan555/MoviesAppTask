package com.irfan.moviesapptask.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.irfan.moviesapptask.R;
import com.squareup.picasso.Picasso;

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

        Intent intent = getIntent();
        Picasso.with(this)
                .load(intent.getStringExtra("image_name"))
                .error(R.drawable.error_gallery_image)
                .into(Poster);

        tvTitle.setText(intent.getStringExtra("movieTitle"));
        tvRdate.setText(intent.getStringExtra("releaseDate"));
        tvDesc.setText(intent.getStringExtra("description"));
        tvVoteAvg.setText(String.valueOf(intent.getDoubleExtra("voteAverage",0)));


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.info:
                startActivity(new Intent(this,MyActivity.class));

        }
        return super.onOptionsItemSelected(item);
    }


}
