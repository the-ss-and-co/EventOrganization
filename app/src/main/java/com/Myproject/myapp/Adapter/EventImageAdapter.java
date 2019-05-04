package com.Myproject.myapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.Myproject.myapp.Model.Eventimage;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class EventImageAdapter extends RecyclerView.Adapter<EventImageAdapter.MyviewHOlderImage> {
    ArrayList<Eventimage> arrayList = new ArrayList<>();
    Context context;
    public EventImageAdapter(ArrayList<Eventimage> arrayList, Context context){
        this.arrayList =arrayList;
        this.context=context;

    }
    @NonNull
    @Override
    public EventImageAdapter.MyviewHOlderImage onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_image,viewGroup,false);
        return new MyviewHOlderImage(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventImageAdapter.MyviewHOlderImage myviewHOlderImage, int i) {
        myviewHOlderImage.imageView.setImageResource(arrayList.get(i).getImage());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyviewHOlderImage extends RecyclerView.ViewHolder {
        ImageView imageView;
        public MyviewHOlderImage(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.Image_card);
        }
    }
}
