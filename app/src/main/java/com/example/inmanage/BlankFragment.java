package com.example.inmanage;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;

import java.util.ArrayList;
import java.util.List;


public class BlankFragment extends Fragment {

//
//    View view;
//    private RecyclerView recyclerView;
//    private RequestQueue requestQueue;
//
//    private Context context;
//    private List<Movie> movieList;
//
//    public BlankFragment() {
//        // Required empty public constructor
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//
//        super.onCreate(savedInstanceState);
//      //  setContentView(R.layout.activity_main);
//
//        recyclerView=view.findViewById(R.id.recyclerview);
//        recyclerView.hasFixedSize();
//        LinearLayoutManager layoutManager=new LinearLayoutManager( getActivity());  ///
//        recyclerView.setLayoutManager(layoutManager);
//
//        MainActivity.MovieAdapter movieAdapter=new MainActivity.MovieAdapter(context,movieList);
//        recyclerView.setAdapter(movieAdapter);
//
//        requestQueue=VolleySingleton.getmInstance(this).getRequestQueue();
//
//        movieList=new ArrayList<>();
//        fetchMovies();
//
//
//
//
//
//        return inflater.inflate(R.layout.fragment_blank, container, false);
//    }
}