package cn.stu.cusview.ruiz.rx.convert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class WindowOpActivity extends AppCompatActivity {


    private static final String TAG = "WindowOpActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window_op);
    }



    public void onWindowOpClick(View view){
        Observable.just(1,2,3,4,5,6,7,8,9)
                .window(4)
                .subscribe(new Observer<Observable<Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "onSubscribe: out" );
                    }

                    @Override
                    public void onNext(Observable<Integer> integerObservable) {
                        Log.e(TAG, "onNext: out");
                        integerObservable.subscribe(new Observer<Integer>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                Log.e(TAG, "onSubscribe: in");
                            }

                            @Override
                            public void onNext(Integer integer) {
                                Log.e(TAG, "onNext: "+integer );
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e(TAG, "onError: in" );
                            }

                            @Override
                            public void onComplete() {
                                Log.e(TAG, "onComplete: in" );
                            }
                        });
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: out" );
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: out" );
                    }
                });
    }

}
