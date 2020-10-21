package com.example.task2.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.task2.R;
import com.example.task2.database.DataBaseAdapter;
import com.example.task2.database.Movies;
import com.example.task2.ui.main.MovieViewModel;
import com.example.task2.ui.main.OnItemClick;
import java.util.List;

public class FavouriteFragment extends Fragment implements OnItemClick {
    public static final String TAG = "FavouriteFragment";
    private MovieViewModel movieViewModel;
    private RecyclerView recyclerView;
    private DataBaseAdapter dataBaseAdapter;
    private List<Movies> mMovies;

    public FavouriteFragment() {
    }

    public static FavouriteFragment newInstance() {
        return new FavouriteFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);
        initRecyclerView(view);
        return view;

    }

    private void initRecyclerView(View view) {
        Log.e(TAG, "initRecyclerView: ");
        recyclerView = view.findViewById(R.id.item_favourite);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.hasFixedSize();
        dataBaseAdapter = new DataBaseAdapter(getContext(), this);
        recyclerView.setAdapter(dataBaseAdapter);
        movieViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.
                getInstance(getActivity().getApplication())).get(MovieViewModel.class);

        movieViewModel.getAllmovie().observe(getActivity(), new Observer<List<Movies>>() {
            @Override
            public void onChanged(List<Movies> movies) {
                mMovies = movies;
                dataBaseAdapter.submitList(mMovies);


            }
        });
    }


    @Override
    public void onItemClick(int position, ImageView imageView) {
        Movies movies = mMovies.get(position);
        movieViewModel.delete(movies);
        Toast.makeText(getActivity(), "Removed from favourite", Toast.LENGTH_SHORT).show();


    }
}



