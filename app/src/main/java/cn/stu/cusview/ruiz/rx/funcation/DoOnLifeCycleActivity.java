package cn.stu.cusview.ruiz.rx.funcation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class DoOnLifeCycleActivity extends AppCompatActivity {

    private static final String TAG = "DoOnLifeCycleActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_on_life_cycle);
    }



    public void onLifecycleClick(View view){
        Observable.just(1,2,3,4,56,7)
                .doOnLifecycle(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        Log.e(TAG, "accept: life disposable" );
                        disposable.dispose();
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.e(TAG, "run: life" );
                    }
                })
                .doOnDispose(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.e(TAG, "run: doOnDispose");
                    }
                })
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        Log.e(TAG, "accept: doOnSubscribe");
                    }
                })
                .subscribe(new Observer<Integer>() {
                    private Disposable mDisposable;
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "onSubscribe: " );
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "onNext: "+integer);
                        mDisposable.dispose();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: ");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: " );
                    }
                });
    }
}
