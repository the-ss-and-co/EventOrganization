package com.Myproject.myapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Myproject.myapp.Adapter.EventViewAdapter;
import com.Myproject.myapp.Adapter.WishListAdapter;
import com.Myproject.myapp.Model.EventTag;
import com.Myproject.myapp.Model.WishListModel;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class WishListFragment extends Fragment {
    RecyclerView Recyclrer_service,Recycler_wish_list;
    EventViewAdapter eventViewAdapter;
    ArrayList<EventTag> arrayList;
    ArrayList<WishListModel>wisharraylist;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.wishlistfragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Recyclrer_service =view.findViewById(R.id.Recyclrer_service);
        Recycler_wish_list=view.findViewById(R.id.wish_list);
        arrayList=new ArrayList<>();
        arrayList.add(new EventTag("Service 1"));
        arrayList.add(new EventTag("Service 2"));
        arrayList.add(new EventTag("Service 3"));


        eventViewAdapter=new EventViewAdapter(arrayList,getContext());
        Recyclrer_service.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        Recyclrer_service.setAdapter(eventViewAdapter);
  wisharraylist=new ArrayList<>();
        adddata(wisharraylist);
        WishListAdapter wishListAdapter=new WishListAdapter(wisharraylist,getContext());
        Recycler_wish_list.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        Recycler_wish_list.setAdapter(wishListAdapter);

    }

    private void adddata(ArrayList<WishListModel> wisharraylist) {
        wisharraylist.add(new WishListModel("1111 People wishlished","Panama Beach Carol Avanue","50km","50",3,R.drawable.price1));
        wisharraylist.add(new WishListModel("151 People wishlished","Paragohn Beach Carol Avanue","50km","50",4,R.drawable.prince2));
        wisharraylist.add(new WishListModel("500 People wishlished","Panama  Carol Avanue","50km","50",5,R.drawable.img4));
        wisharraylist.add(new WishListModel("500 People wishlished","Panama  Carol Avanue","50km","50",5,R.drawable.img4));
        wisharraylist.add(new WishListModel("500 People wishlished","Panama  Carol Avanue","50km","50",5,R.drawable.img4));


    }
}
