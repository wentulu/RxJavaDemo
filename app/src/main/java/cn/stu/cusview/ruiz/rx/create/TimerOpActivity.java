package cn.stu.cusview.ruiz.rx.create;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Observer;
import java.util.concurrent.TimeUnit;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class TimerOpActivity extends AppCompatActivity {

    private static final String TAG = "TimerOpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_op);
    }



    public void onTimerClick(View view){
        Observable.timer(5, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e(TAG,"accept "+aLong);
                    }
                });
    }
}
