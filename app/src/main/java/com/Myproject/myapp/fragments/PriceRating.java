package com.Myproject.myapp.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.Myproject.myapp.R;

public class PriceRating extends Fragment {
    SeekBar seekBar;
    CheckBox five_starcheck,four_starcheck,three_starcheck,two_starcheck,one_starcheck;
    TextView max_amount;
    ImageView Close;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.price_rating,container,false);
        seekBar =view.findViewById(R.id.seekbar_price);
        five_starcheck=view.findViewById(R.id.five_star_check);
        four_starcheck=view.findViewById(R.id.four_starcheck);
        three_starcheck=view.findViewById(R.id.three_starcheck);
        two_starcheck=view.findViewById(R.id.two_starcheck);
        one_starcheck=view.findViewById(R.id.first_starcheck);
        max_amount=view.findViewById(R.id.max_amount);
        Close=view.findViewById(R.id.close);
        seekBar2();

        Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        return view;
    }

    private void seekBar2() {
        seekBar.setMax(70000);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
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
