package com.example.task2.fragment;

import android.graphics.Movie;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task2.R;
import com.example.task2.data.PostModel;
import com.example.task2.data.Results;
import com.example.task2.retrofit.MovieClient;
import com.example.task2.retrofit.PostApi;
import com.example.task2.ui.main.MovieAdapter;
import com.example.task2.ui.main.OnItemClick;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.QueryMap;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

public class HomeFragment extends Fragment implements OnItemClick {
    private RecyclerView recyclerView;
    private MovieAdapter adapter;
    private List<PostModel> mList;

    private PostApi postApi;
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
        getRetrofit("2",4);
        recyclerView = view.findViewById(R.id.recycler);
        return view;



    }
    private void initRecyclerView(List<PostModel> result) {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mList = result;
        recyclerView.setLayoutManager(manager);
        recyclerView.hasFixedSize();
        adapter = new MovieAdapter(getContext(), this);
       // adapter.submitList(mList);
        recyclerView.setAdapter(adapter);
    }
    private void BuildRetrofit() {
        Log.e(TAG, "BuildRetrofit: ");
        postApi = MovieClient.getClient().create(PostApi.class);

    }
    private void getRetrofit (String api_key ,int PageId){
        Call<List<PostModel>> call = postApi.getMovie(api_key,PageId);
        call.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                List<PostModel> result = response.body();
                initRecyclerView(result);




            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());


            }
        });
    }


    @Override
    public void onItemClick(int position, ImageView imageView) {

    }
}