package com.example.task2.ui.main;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.task2.R;
import com.example.task2.data.Results;

public class MovieAdapter extends ListAdapter<Results, MovieAdapter.MovieViewHolder> {
    // TODO 10: use tags like the next line (do not use the imported one)
    public static final String TAG = "MovieAdapter";
    private static final ListItemCallback ListItemCallback = new ListItemCallback();

    Context mContext;
    OnItemClick onItemClick;

    public MovieAdapter(Context context, OnItemClick onItemClick) {
        super(ListItemCallback);

        this.mContext = context;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_view, parent, false);
        return new MovieViewHolder(view, onItemClick);

    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Results movie = getItem(position);
        // requestOptions = requestOptions.placeholder(R.drawable.ic_launcher_background);
        if (movie != null) {
            Uri image_uri = Uri.parse("https://image.tmdb.org/t/p/w500/" + movie.getPoster_path());

            Glide.with(mContext).load(image_uri)
                    .into(holder.poster);

            holder.title.setText(movie.getTitle());
            holder.raw.setText(movie.getVote_average() + "");
        }
    }


    public static class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView poster, favouriteImageView;
        TextView title, raw;
        OnItemClick onItemClick;


        public MovieViewHolder(@NonNull View itemView, OnItemClick onClick) {
            super(itemView);
            poster = itemView.findViewById(R.id.Frame);
            title = itemView.findViewById(R.id.title);
            raw = itemView.findViewById(R.id.raw);
            favouriteImageView = itemView.findViewById(R.id.item_favourite);
            favouriteImageView.setOnClickListener(this);
            onItemClick = onClick;

        }

        @Override
        public void onClick(View view) {
            onItemClick.onItemClick(getAdapterPosition(), poster);
        }


    }

}
