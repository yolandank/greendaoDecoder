package com.example.greendaodecoder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.greendaodecoder.adaptscreen.AdaptScreenUtil;

public class Adapt2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapt2_activity_layout);
        TextView jump2Adapt1=findViewById(R.id.jump2adapt2);
        jump2Adapt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Adapt2Activity.this,Adapt1Activity.class);
                Adapt2Activity.this.startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        AdaptScreenUtil.printCurrentDensity(this,this.getClass().getSimpleName());
    }
}
