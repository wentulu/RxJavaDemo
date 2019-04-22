package cn.stu.cusview.ruiz.rx.create;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.SafeObserver;

/**
 * 没有自定实现异步操作
 * */
public class FromFutureActivity extends AppCompatActivity {

    private static final String TAG = "FromFutureActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_future);
    }


    public void onFromFutureClick(View view){
        final FutureTask<Integer > futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Log.e(TAG,"futureTask run");
                return 3;
            }
        });

        Observable.fromFuture(futureTask)
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        futureTask.run();
                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG,"onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG,"onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG,"onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG,"onComplete");
                    }
                });
//                .subscribe(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.e(TAG,"accept run "+integer);
//                    }
//                });

    }

}
