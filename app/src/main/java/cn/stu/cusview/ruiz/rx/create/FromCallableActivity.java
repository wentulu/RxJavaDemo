package cn.stu.cusview.ruiz.rx.create;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.lang.annotation.Target;
import java.util.concurrent.Callable;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class FromCallableActivity extends AppCompatActivity {
    private static final String TAG = "FromCallableActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_callable);
    }


    public void onFromCallableClick(View view){
        Observable.fromCallable(new Callable<Integer>() {
            @Override
            public Integer call() {
                return 1;
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG,"onSubscribe ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG,"onNext "+integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG,"onError ");
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"onComplete ");
            }
        });
    }


    public void onFromCallableConsumerClick(View view){
        Observable.fromCallable(new Callable<Integer>(){
            @Override
            public Integer call() {
                return 3;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e(TAG,"accept "+integer);
            }
        });
    }

}
