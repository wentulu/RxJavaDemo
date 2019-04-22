package cn.stu.cusview.ruiz.rx.create;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import java.util.concurrent.TimeUnit;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

public class IntervalOpActivity extends AppCompatActivity {

    private static final String TAG = "IntervalOpActivity";
    Observable observable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interval_op);
    }



    public void onInterValClick(View view){
         observable = Observable.interval(5, TimeUnit.SECONDS).takeWhile(new Predicate<Long>() {
             @Override
             public boolean test(Long aLong) throws Exception {
                 return  !isFinishing();
             }
         });
                observable.subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e(TAG,"accept "+aLong);
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
