package com.example.greendaodecoder.jetpack;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.example.greendaodecoder.BaseActivity;
import com.example.greendaodecoder.R;
import com.example.greendaodecoder.databinding.JetpackActivityLayoutBinding;


import java.util.concurrent.TimeUnit;

public class JetpackActivity extends BaseActivity implements View.OnClickListener {
    private JetpackActivityLayoutBinding mBinding;
    private static final String TAG = "JetpackActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.jetpack_activity_layout);
        mBinding = DataBindingUtil.setContentView(this, R.layout.jetpack_activity_layout);
        UserViewModel userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        mBinding.setUser(userViewModel);
        mBinding.setLifecycleOwner(this);
        userViewModel.getNameData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mBinding.tvUsrName.setText(s);
            }
        });

        mBinding.demoBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Data data = new Data.Builder().putString("1653", "伊斯坦布尔").build();
        OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(SimpleWorker.class)
                .setBackoffCriteria(BackoffPolicy.LINEAR, 1, TimeUnit.HOURS)
                .setInputData(data).build();
        WorkManager.getInstance().enqueue(workRequest);
        Constraints constraints = new Constraints.Builder()
                .setRequiresStorageNotLow(false)
                .setRequiresBatteryNotLow(false)
                .build();
    }
}
