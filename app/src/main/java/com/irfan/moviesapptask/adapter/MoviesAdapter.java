package com.irfan.moviesapptask.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.irfan.moviesapptask.R;
import com.irfan.moviesapptask.activity.MainActivity;
import com.irfan.moviesapptask.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {
    private List<Movie> movies;
    MainActivity activity;
    private Context context;



    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView date,adult;
        ImageView poster;


        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieTitle = (TextView) v.findViewById(R.id.title);
            date = (TextView) v.findViewById(R.id.release_date);
            adult = (TextView) v.findViewById(R.id.adult);
            poster = (ImageView) v.findViewById(R.id.poster);
        }
    }
    public MoviesAdapter(List<Movie> movies, MainActivity activity, Context context) {
        this.movies = movies;
        this.activity = activity;
        this.context = context;


    }

    @NonNull
    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_movie, parent, false);
        return new MovieViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, final int position) {
        Picasso.with(context)
                .load("http://image.tmdb.org/t/p/w185/"+movies.get(position).getPosterPath())
                .error(R.drawable.error_gallery_image)
                .into(holder.poster);
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.date.setText(movies.get(position).getReleaseDate());

        holder.moviesLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.callDetailPage(
                        "http://image.tmdb.org/t/p/w185/"+movies.get(position).getPosterPath(),
                        movies.get(position).getTitle(),
                        movies.get(position).getOverview(),
                        movies.get(position).getReleaseDate(),
                        movies.get(position).getVoteAverage());
            }
        });

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
