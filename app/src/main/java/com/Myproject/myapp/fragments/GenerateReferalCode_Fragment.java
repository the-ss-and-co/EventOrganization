package com.Myproject.myapp.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Myproject.myapp.R;

public class GenerateReferalCode_Fragment extends Fragment {
    TextView success;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.generatereferalcode,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        success=view.findViewById(R.id.success);
        setrangetext(success);
    }

    private void setrangetext(TextView range) {
        SpannableStringBuilder builder = new SpannableStringBuilder();

        SpannableString str1= new SpannableString("share this one time generated refferal code with earn ");
        str1.setSpan(new ForegroundColorSpan(Color.BLACK), 0, str1.length(), 0);
        builder.append(str1);

        SpannableString str2= new SpannableString("success point");
        str2.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.blue)), 0, str2.length(), 0);
        builder.append(str2);

        range.setText(builder, TextView.BufferType.SPANNABLE);
    }
}
