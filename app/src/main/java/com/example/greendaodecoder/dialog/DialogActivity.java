package com.example.greendaodecoder.dialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.greendaodecoder.R;
import com.example.greendaodecoder.jetpack.MyViewModel;
import com.example.greendaodecoder.volley.VolleyDemo;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "DialogActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_activity_layout);
        Log.d(TAG, "onCreate: ");
        TextView showDialog=findViewById(R.id.show_dialog);
        showDialog.setOnClickListener(this);
        VolleyDemo.getInstance().run();
        MyViewModel viewModel= ViewModelProviders.of(this).get(MyViewModel.class);
        Log.d(TAG, "onCreate: app="+viewModel.getApplication());

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }


    @Override
    public void onClick(View v) {
        new AlertDialog.Builder(this)
                .setTitle("跳转")
                .setPositiveButton("跳转", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent();
                        intent.setClass(DialogActivity.this,DialogActivity.class);
                        DialogActivity.this.startActivity(intent);
                    }
                })
                .create()
                .show();
    }
}
