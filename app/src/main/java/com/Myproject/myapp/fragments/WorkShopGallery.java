package com.Myproject.myapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Myproject.myapp.Adapter.EventImageAdapter;
import com.Myproject.myapp.Adapter.EventViewAdapter;
import com.Myproject.myapp.Model.EventTag;
import com.Myproject.myapp.Model.Eventimage;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class WorkShopGallery extends Fragment {
    RecyclerView Event_view,Event_image;
    EventViewAdapter eventViewAdapter;
    EventImageAdapter eventImageAdapter;
    ArrayList<Eventimage> arrayListimage = new ArrayList<>();
    ArrayList<EventTag> arrayList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.work_shop_gallery,container,false);
        Event_view = view.findViewById(R.id.event_view);
        Event_image = view.findViewById(R.id.event_image);
        arrayList.add(new EventTag("Event"));
        arrayList.add(new EventTag("Event"));
        arrayList.add(new EventTag("Event"));
        arrayList.add(new EventTag("Event"));
        arrayList.add(new EventTag("Event"));

        arrayListimage.add(new Eventimage(R.drawable.price1));
        arrayListimage.add(new Eventimage(R.drawable.prince2));
        arrayListimage.add(new Eventimage(R.drawable.price1));
        arrayListimage.add(new Eventimage(R.drawable.prince2));
        arrayListimage.add(new Eventimage(R.drawable.price1));



        eventViewAdapter=new EventViewAdapter(arrayList,getContext());
        Event_view.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        Event_view.setAdapter(eventViewAdapter);

        eventImageAdapter=new EventImageAdapter(arrayListimage,getContext());
        Event_image.setLayoutManager(new GridLayoutManager(getContext(),4));
        Event_image.setAdapter(eventImageAdapter);

        return  view;
    }
}
