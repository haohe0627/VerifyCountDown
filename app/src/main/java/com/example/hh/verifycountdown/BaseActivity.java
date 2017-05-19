package com.example.hh.verifycountdown;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by haohe on 2017/5/19 0019.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        unbinder = ButterKnife.bind(this);
        init();
    }

    protected abstract int setLayoutId();
    protected abstract void init();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    protected MyApplication getApp(){
        return (MyApplication)getApplication();
    }
}
