package com.example.task2.database;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.task2.R;
import com.example.task2.ui.main.OnItemClick;

public class DataBaseAdapter extends ListAdapter<Movies, DataBaseAdapter.MoviesViewHolder> {
    // TODO 10: use tags like the next line (do not use the imported one)
    public static final String TAG = "MovieAdapter";
    private static final ListItemDbCallback listItemDbCallback = new ListItemDbCallback();
    Context mContext;
    OnItemClick onItemClick;
    public DataBaseAdapter (Context context, OnItemClick onItemClick) {
        super(listItemDbCallback);
        this.mContext = context;
        this.onItemClick = onItemClick;
    }
    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_view, parent, false);
        return new MoviesViewHolder(view,onItemClick);

    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {
        Movies movies = getItem(position);
        if (movies != null) {
            Uri image_uri = Uri.parse("https://image.tmdb.org/t/p/w500/"+movies.getPoster_path());

            Glide.with(mContext).load(image_uri)
                    .into(holder.poster);

            holder.title.setText(movies.getTitle());
            holder.raw.setText(movies.getVote_average() + "");



    }}

    public  class MoviesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView poster,favouriteImageView;
        TextView title,raw;
        OnItemClick onItemClick;

        public MoviesViewHolder(@NonNull View itemView,OnItemClick onClick) {
            super(itemView);
            poster = itemView.findViewById(R.id.Frame);
            title = itemView.findViewById(R.id.title);
            raw = itemView.findViewById(R.id.raw);
            favouriteImageView=itemView.findViewById(R.id.item_favourite);
            favouriteImageView.setOnClickListener(this);
            onItemClick= onClick;
        }

        @Override
        public void onClick(View view) {
            onItemClick.onItemClick(getAdapterPosition(),poster);


        }
    }


}
