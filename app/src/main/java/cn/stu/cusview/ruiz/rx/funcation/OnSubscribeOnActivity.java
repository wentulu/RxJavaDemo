package cn.stu.cusview.ruiz.rx.funcation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class OnSubscribeOnActivity extends AppCompatActivity {

    private static final String TAG = "OnSubscribeOnActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_subscribe_on);
    }

    public void onSubscribeOnClick(View view) {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) {
                Log.e(TAG, "subscribe: Thread " + Thread.currentThread().getName());
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onComplete();
            }
        })
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "onSubscribe: Thread " + Thread.currentThread().getName());
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "onNext: Thread " + Thread.currentThread().getName()+" value = "+integer);

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: Thread " + Thread.currentThread().getName());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: Thread " + Thread.currentThread().getName());

                    }
                });
    }

}
