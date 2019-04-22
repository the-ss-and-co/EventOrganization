package com.Myproject.myapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.Myproject.myapp.Activity.VenderListingActivity;
import com.Myproject.myapp.R;

public class DestinationAdress extends Fragment {
    SeekBar seekBar;
    TextView localaddress,min_amount,max_amount;
    ImageView backpressed;
    CardView cardViewaddress;
    EditText enter_amount;
    Button explore;
    RelativeLayout skip;





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.destination_adress,container,false);
        seekBar = view.findViewById(R.id.seekbar_price);
        skip = view.findViewById(R.id.skip);
        localaddress = view.findViewById(R.id.localaddress);
        min_amount = view.findViewById(R.id.min_amount);
        max_amount = view.findViewById(R.id.max_amount);
        backpressed = view.findViewById(R.id.backpressed);
        cardViewaddress = view.findViewById(R.id.cardviewaddress);
        enter_amount =view.findViewById(R.id.enter_amount);
        explore = view.findViewById(R.id.explore);
        min_amount.setText("0");
        seekbar();
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), VenderListingActivity.class));
            }
        });
        return view;
    }



    private void seekbar() {
        seekBar.setMax(70000);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                max_amount.setText(""+progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
