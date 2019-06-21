package com.Myproject.myapp.Vendor.AB.Activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

import com.Myproject.myapp.R;
import com.Myproject.myapp.Vendor.AB.Fragment.RegistrationFrag1;

public class PaymentActivity extends AppCompatActivity {
Button go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
go=findViewById(R.id.go);

go.setOnClickListener(v -> {
    startActivity(new Intent(PaymentActivity.this, PackageList.class));
});
    }
}
