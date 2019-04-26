package cn.stu.cusview.ruiz.rx.funcation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.concurrent.TimeUnit;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DelayOperatorActivity extends AppCompatActivity {

    private static final String TAG = "DelayOperatorActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delay_operator);
    }



    public void onDelayClick(View view){
        Observable.just(1,2,3,4)
                .delay(2, TimeUnit.SECONDS)
                .subscribe(
                        new Observer<Integer>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                Log.e(TAG, "onSubscribe: "+System.currentTimeMillis()/1000 );
                            }

                            @Override
                            public void onNext(Integer integer) {
                                Log.e(TAG, "onNext: " +integer +"   "+System.currentTimeMillis()/1000);
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e(TAG, "onError: ");
                            }

                            @Override
                            public void onComplete() {
                                Log.e(TAG, "onComplete: ");
                            }
                        }
                );
    }

}
