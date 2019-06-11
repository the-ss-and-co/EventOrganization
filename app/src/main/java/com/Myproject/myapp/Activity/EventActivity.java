package com.Myproject.myapp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;

import com.Myproject.myapp.Adapter.EventAdapter;
import com.Myproject.myapp.Model.EventModel;
import com.Myproject.myapp.R;

import java.util.ArrayList;

import com.Myproject.myapp.R;

public class EventActivity extends AppCompatActivity {

    RecyclerView EventView;
    EditText Evenetinput;
    TextView Go;
    EventAdapter eventAdapter;
    ArrayList<EventModel> arrayList ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        EventView = findViewById(R.id.eventview);

        arrayList = new ArrayList<>();
        arrayList.add(new EventModel("Marriage",R.drawable.ic_event_black_24dp,true));
        arrayList.add(new EventModel("Anniversary",R.drawable.ic_event_black_24dp,true));
        arrayList.add(new EventModel("Birthday",R.drawable.ic_event_black_24dp,true));
        arrayList.add(new EventModel("Corporate",R.drawable.ic_event_black_24dp,true));
        arrayList.add(new EventModel("Funeral",R.drawable.ic_event_black_24dp,true));

        eventView();
  

    }

    private void eventView() {
        EventView.setItemAnimator(new DefaultItemAnimator());
        EventView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        eventAdapter = new EventAdapter(this,arrayList);
        EventView.setAdapter(eventAdapter);
    }
}
