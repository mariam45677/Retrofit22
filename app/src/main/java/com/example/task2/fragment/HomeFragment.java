package com.example.task2.fragment;

import android.graphics.Movie;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task2.R;
import com.example.task2.data.PostModel;
import com.example.task2.data.Results;
import com.example.task2.database.Movies;
import com.example.task2.retrofit.MovieClient;
import com.example.task2.retrofit.PostApi;
import com.example.task2.ui.main.MovieAdapter;
import com.example.task2.ui.main.MovieViewModel;
import com.example.task2.ui.main.OnItemClick;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import static androidx.constraintlayout.motion.utils.Oscillator.TAG;
import static com.example.task2.data.Constant.Api_Key;

public class HomeFragment extends Fragment implements OnItemClick {
    private RecyclerView recyclerView;
    private MovieAdapter adapter;
    private List<Results> mList;
    private PostApi postApi;
    private MovieViewModel movieViewModel;

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        BuildRetrofit();
       getRetrofit(Api_Key,1);
        recyclerView = view.findViewById(R.id.recycler);
        return view;



    }
    private void initRecyclerView(List<Results> result) {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mList = result;
        recyclerView.setLayoutManager(manager);
        recyclerView.hasFixedSize();
        adapter = new MovieAdapter(getContext(), this);
        adapter.submitList(mList);
        recyclerView.setAdapter(adapter);
    }
    private void BuildRetrofit() {
        Log.e(TAG, "BuildRetrofit: ");
        postApi = MovieClient.getClient().create(PostApi.class);

    }
    private void getRetrofit (String api_key ,int PageId) {
        Call<PostModel> call = postApi.getMovie(api_key, PageId);
        call.enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                PostModel body = response.body();
                List<Results> result = body.getResults();
                initRecyclerView(result);

            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }




    @Override
    public void onItemClick(int position, ImageView imageView) {
         Results res =  mList.get(position);
        Movies movies = new Movies(res.getId(),res.getVote_count(),res.getPoster_path(),res.getTitle(),res.getVote_average());
        movieViewModel.insert(movies);
        Toast.makeText(getActivity(), "Add the movies", Toast.LENGTH_SHORT).show();









    }
}