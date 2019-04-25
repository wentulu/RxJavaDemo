package cn.stu.cusview.ruiz.rx.combine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;

public class CombineLastestOperatorActivity extends AppCompatActivity {
    private static final String TAG = "CombineLastestOperatorA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combine_lastest_operator);
    }


    public void onCombileLatestClick(View view) {
        Observable.combineLatest(
                Observable.just(1, 2, 3, 4, 5, 6, 7, 8),
                Observable.just(11, 12, 13, 14, 15, 16, 17),
                Observable.just(21, 22, 23, 24, 25),
                new Function3<Integer, Integer, Integer, String>() {
                    @Override
                    public String apply(Integer integer, Integer integer2, Integer integer3) {
                        return integer + "->" + integer2 + "->" + integer3;
                    }
                }
        ).subscribe(
                new Observer<String>() {
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
                        Log.e(TAG, "onError: ", e);
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: ");
                    }
                }
        );
    }


    public void onCombineLatestDelayErrorClick(View view) {
        ArrayList<Observable> observables = new ArrayList();
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onError(new IllegalArgumentException("aa"));
            }
        });
        Observable<Integer> observable1 = Observable.just(1, 2, 3, 4, 5, 6, 7, 8);
        Observable<Integer> observable2 = Observable.just(11, 12, 13, 14, 15, 16, 17);
        Observable<Integer> observable3 = Observable.just(21, 22, 23, 24, 25);
        observables.add(observable);
        observables.add(observable1);
        observables.add(observable2);
        observables.add(observable3);
        Toast.makeText(this, "没弄明白", Toast.LENGTH_SHORT).show();
    }
}
