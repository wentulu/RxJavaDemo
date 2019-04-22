package cn.stu.cusview.ruiz.rx.create;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import java.util.concurrent.Callable;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 每一次订阅拿一下最新值
 * */
public class DeferActivity extends AppCompatActivity {

    private static final String TAG = "DeferActivity";

    private int defer;
    Observable mObservable;
    Observer observer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defer);
        //todo ObservableSource<? extends Integer> 一定要带上泛型
        mObservable = Observable.defer(new Callable<ObservableSource<? extends Integer>>() {
            @Override
            public ObservableSource<? extends Integer> call() throws Exception {
                return Observable.just(defer);
            }
        });

        observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer o) {
                Log.e(TAG,"onNext "+o);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }


    public void onDeferSubscribe(View view){
        mObservable.subscribe(observer);
        defer+=100;
    }
}
