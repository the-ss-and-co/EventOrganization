package com.Myproject.myapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.Myproject.myapp.Activity.VenderDetailsActivity;
import com.Myproject.myapp.Model.NewAddedlistModel;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class NewAddedAdapter extends RecyclerView.Adapter<NewAddedAdapter.ViewHolder> {
ArrayList<NewAddedlistModel>arrayList;
Context context;

    public NewAddedAdapter(ArrayList<NewAddedlistModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.new_added, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
   viewHolder.name.setText(arrayList.get(i).getName());
   viewHolder.address.setText(arrayList.get(i).getAddress());
   viewHolder.count.setText(arrayList.get(i).getCount()+" people looking for");
   viewHolder.imageView.setBackgroundResource(R.drawable.img4);
   viewHolder.r_main.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        context.startActivity(new Intent(context, VenderDetailsActivity.class));
    }
});
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,address,count;
        ImageView imageView;
        RelativeLayout r_main;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            r_main=itemView.findViewById(R.id.r_main);

            name=itemView.findViewById(R.id.name);
            address=itemView.findViewById(R.id.address);
            count=itemView.findViewById(R.id.count);
            imageView=itemView.findViewById(R.id.img);

        }
    }
}
