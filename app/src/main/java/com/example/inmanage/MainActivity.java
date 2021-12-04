package com.example.inmanage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.model.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RequestQueue requestQueue;

    private Context context;
    private List<Movie> movieList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.hasFixedSize();
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MovieAdapter movieAdapter=new MovieAdapter(context,movieList);
        recyclerView.setAdapter(movieAdapter);

        requestQueue=VolleySingleton.getmInstance(this).getRequestQueue();

        movieList=new ArrayList<>();
        fetchMovies();


       // movieList= Movie.instance.getAllMovies();

    }

    private void fetchMovies() {

        String url="https://picsum.photos/v2/list";
//"https://jsonplaceholder.typicode.com/photos"


        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0; i<response.length();i++)
                {
                    try {
                        JSONObject jsonObject=response.getJSONObject(i);
                        String title=jsonObject.getString("author");
//                        String overview=jsonObject.getString("overview");
                        String poster=jsonObject.getString("download_url");
//                        Double rating=jsonObject.getDouble("rating");

                        Movie movie=new Movie(title,poster);
//                        ,poster,overview,rating ds
                        movieList.add(movie);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    MovieAdapter adapter=new MovieAdapter(MainActivity.this,movieList);
                    recyclerView.setAdapter(adapter);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TAG","error");
              Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonArrayRequest);

    }

    class MovieHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView title;
        TextView overview;
        TextView rating;

        //making the select item
        ConstraintLayout constraintLayout;
        //making the select item


        public MovieHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageview);
            title=itemView.findViewById(R.id.title_tv);
            overview=itemView.findViewById(R.id.overview_tv);
            rating=itemView.findViewById(R.id.rating);

            //making the select item
            constraintLayout=itemView.findViewById(R.id.main_layout);
            //making the select item
        }
    }


    class MovieAdapter extends RecyclerView.Adapter<MovieHolder>{

        public MovieAdapter(Context context1, List<Movie> movieList1)
        {
            context=context1;
            movieList=movieList1;
        }

        @NonNull
        @Override
        public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= getLayoutInflater().inflate(R.layout.item,null);
            MovieHolder holder=new MovieHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
            Movie movie=movieList.get(position);
           // holder.rating.setText(movie.getRating().toString());
            holder.title.setText(movie.getTitle());
    //      holder.overview.setText(movie.getOverview());
           Glide.with(context).load(movie.getPoster()).into(holder.imageView);

            //making the select item
            holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,DetailActivity.class);

                    Bundle bundle=new Bundle();
                    bundle.putString("author",movie.getTitle());
                    bundle.putString("download_url",movie.getPoster());

                    intent.putExtras(bundle);
                    context.startActivity(intent);
            //making the select item

                }
            });


        }

        @Override
        public int getItemCount() {
            return movieList.size();
        }
    }

}