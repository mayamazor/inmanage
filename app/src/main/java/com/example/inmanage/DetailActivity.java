package com.example.inmanage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        //making the select item
        ImageView imageView=findViewById(R.id.poster_image);
        TextView title=findViewById((R.id.mTitle));


        Bundle bundle=getIntent().getExtras();
        String mTitle=bundle.getString("author");
        String mPoster=bundle.getString("download_url");

        Glide.with(this).load(mPoster).into(imageView);
        title.setText(mTitle);
        //making the select item

    }
}