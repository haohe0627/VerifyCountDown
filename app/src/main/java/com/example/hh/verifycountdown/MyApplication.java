package com.example.hh.verifycountdown;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by haohe on 2017/5/19 0019.
 * 为什么写在application里？ 实际项目中有多个地方用到此方法，因此写入application中方便调用
 */

public class MyApplication extends BaseApplication {

    private int verifyCountDown = 60;
    private Timer timer;
    private VerifyCountDown callback;

    public void startVerifyCountDown(){

        if(isVerifyCountDowning()){
            return;
        }
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                verifyCountDown --;
                if(callback != null){
                    callback.countDowning(verifyCountDown);
                }

                if(verifyCountDown == 0){
                    verifyCountDown = 60;
                    if(callback != null){
                        callback.countDownFinish();
                    }
                    cancel();
                    timer.cancel();
                    timer = null;
                }
            }
        };
        timer.schedule(task, 0 ,1000);
    }

    public boolean isVerifyCountDowning(){
        return verifyCountDown != 60;
    }

    public void setVerifyCallBack(VerifyCountDown callback){
        this.callback = callback;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }
}
