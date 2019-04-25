package cn.stu.cusview.ruiz.rx.combine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ConcatArrayDelayErrorActivity extends AppCompatActivity {

    private static final String TAG = "ConcatArrayDelayErrorAc";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concat_array_delay_error);
    }


    public void onConcatArrayDelayErrorClick(View view){
        Observable.concatArrayDelayError(Observable.create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                        emitter.onNext(-3);
                        emitter.onNext(-2);
                        emitter.onNext(-1);
                        emitter.onError(new IllegalArgumentException("Error Params"));

                        emitter.onNext(-0);
                    }
                }),
                Observable.just(1,2,3),
                Observable.just(4,5,6),
                Observable.just(7,8),
                Observable.just(9,10),
                Observable.just(11,12))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "onSubscribe: " );
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "onNext: "+integer );
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " );
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: " );
                    }
                });
    }


    public void onConcatArrayClick(View view){
        Observable.concatArray(
                Observable.just(1,2,3),
                Observable.just(4,5,6),
                Observable.just(7,8),
                Observable.just(9,10),
                Observable.just(11,12),
                Observable.create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                        emitter.onNext(-3);
                        emitter.onNext(-2);
                        emitter.onNext(-1);
                        emitter.onError(new IllegalArgumentException("Error Params"));
                        emitter.onNext(0);
                    }
                }))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "onSubscribe: " );
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "onNext: "+integer );
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " );
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: " );
                    }
                });
    }

}
