package com.Myproject.myapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.Myproject.myapp.R;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {
RelativeLayout Services;
CardView service1,service2,Service3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        service1=findViewById(R.id.service1);
        service2=findViewById(R.id.service2);
        Service3=findViewById(R.id.Service3);

service1.setOnClickListener(this);
service2.setOnClickListener(this);
Service3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.service1:
                startActivity(new Intent(this,EventActivity.class));
                break;
                case R.id.service2:
                    startActivity(new Intent(this,EventActivity.class));

                    break;
                    case R.id.Service3:
                        startActivity(new Intent(this,EventActivity.class));

                        break;
            }
        }
    }

