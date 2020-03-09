package com.example.greendaodecoder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.greendaodecoder.data.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User user = new User();
        user.setId(12);
        user.setName("renwj");
        DataUtils.getInstance().addItem(user);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        DataUtils.getInstance().removeItem(12);
    }
}
