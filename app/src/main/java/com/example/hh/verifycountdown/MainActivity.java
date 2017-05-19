package com.example.hh.verifycountdown;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements VerifyCountDown{

    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.txt)
    TextView txt;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {

        findViews();
        setOnClickListener();

        getApp().setVerifyCallBack(this);
        if(getApp().isVerifyCountDowning()){
            btn.setEnabled(false);
        }
    }

    private void setOnClickListener() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVerifyCountDown();
            }
        });
    }

    @Override
    public void countDowning(final int count) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                btn.setEnabled(false);
                txt.setText(count+"");
            }
        });
    }

    @Override
    public void countDownFinish() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                btn.setEnabled(true);
                btn.setText("点击就送");
                txt.setText("");
            }
        });
    }

    private void findViews() {

    }

    private void startVerifyCountDown(){

        getApp().startVerifyCountDown();
    }

    @Override
    protected void onPause() {
        super.onPause();
        getApp().setVerifyCallBack(null);
    }
}
