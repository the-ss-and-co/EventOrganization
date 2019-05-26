package com.Myproject.myapp.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.Myproject.myapp.Model.WishListModel;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class WishListAdapter extends RecyclerView.Adapter<WishListAdapter.ViewHolder> {
ArrayList<WishListModel>arrayList;
Context context;

    public WishListAdapter(ArrayList<WishListModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wishlistitem,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.img.setBackgroundResource(arrayList.get(i).getImg());
        viewHolder.name.setText(arrayList.get(i).getName());
        viewHolder.price.setText(arrayList.get(i).getPrice());
        viewHolder.rating.setNumStars(arrayList.get(i).getStar_count());
        viewHolder.wish_count.setText(arrayList.get(i).getPeople_count());
        setrangetext(viewHolder.range,arrayList.get(i).getOut_of_range());



    }

    private void setrangetext(TextView range,String reg) {
        SpannableStringBuilder builder = new SpannableStringBuilder();

        SpannableString str1= new SpannableString("Out of Range");
        str1.setSpan(new ForegroundColorSpan(Color.BLACK), 0, str1.length(), 0);
        builder.append(str1);

        SpannableString str2= new SpannableString("(available upto "+reg+")");
        str2.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.colorAccent)), 0, str2.length(), 0);
        builder.append(str2);

        range.setText(builder, TextView.BufferType.SPANNABLE);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
      ImageView img;
      TextView wish_count,name,range,price;
      RatingBar rating;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img =itemView.findViewById(R.id.img);
            wish_count =itemView.findViewById(R.id.wish_count);
            name =itemView.findViewById(R.id.name);
            range =itemView.findViewById(R.id.range);
            price =itemView.findViewById(R.id.price);
            rating =itemView.findViewById(R.id.rating);


        }
    }
}
