package com.Myproject.myapp.Activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.Myproject.myapp.Adapter.ImageAdapter;
import com.Myproject.myapp.R;

public class ImageGalleryView extends AppCompatActivity {
    ViewPager pager;
    ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        pager = findViewById(R.id.viewpager);

        imageAdapter = new ImageAdapter(this);
        pager.setAdapter(imageAdapter);

    }
}
