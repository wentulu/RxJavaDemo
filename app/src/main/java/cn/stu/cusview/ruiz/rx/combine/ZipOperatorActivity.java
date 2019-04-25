package cn.stu.cusview.ruiz.rx.combine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.concurrent.TimeUnit;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.observers.SafeObserver;

public class ZipOperatorActivity extends AppCompatActivity {

    private static final String TAG = "ZipOperatorActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zip_operator);
    }


    public void onZipOpClick(View view) {
        Observable.zip(Observable.just(1, 2, 3, 4, 5, 6)
                        .map(new Function<Integer, String>() {
                            @Override
                            public String apply(Integer aLong) throws Exception {
                                return "A" + aLong;
                            }
                        }),
                Observable.just("a", "b", "c", "d", "e")
                        .map(new Function<String, String>() {
                            @Override
                            public String apply(String s) {
                                return "B " + s;
                            }
                        })
                , new BiFunction<String, String, String>() {
                    @Override
                    public String apply(String s, String s2) {
                        return s + "<-->" + s2;
                    }
                }
        ).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(String s) {
                Log.e(TAG, "onNext: " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ");
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete: ");

            }
        });
    }
}
