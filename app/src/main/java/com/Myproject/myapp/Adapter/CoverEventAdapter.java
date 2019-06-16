package com.Myproject.myapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.Myproject.myapp.Model.EventcoverModel;
import com.Myproject.myapp.R;

import org.w3c.dom.Text;

import java.security.PublicKey;
import java.util.ArrayList;

public class CoverEventAdapter extends RecyclerView.Adapter<CoverEventAdapter.MyviewHolder> {
    ArrayList<EventcoverModel> arrayList;
    Context context;

    public  CoverEventAdapter(ArrayList<EventcoverModel> arrayList,Context context){
        this.arrayList =arrayList;
        this.context=context;
    }
    @NonNull
    @Override
    public CoverEventAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_cover,viewGroup,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoverEventAdapter.MyviewHolder myviewHolder, int i) {
     myviewHolder.event_name.setText(arrayList.get(i).getCheckText());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        TextView event_name;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox =  itemView.findViewById(R.id.event_checkbox);
            event_name = itemView.findViewById(R.id.event_name);
        }
    }
}
