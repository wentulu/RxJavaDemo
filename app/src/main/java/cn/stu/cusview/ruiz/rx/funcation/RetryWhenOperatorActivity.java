package cn.stu.cusview.ruiz.rx.funcation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class RetryWhenOperatorActivity extends AppCompatActivity {

    private static final String TAG = "RetryWhenOperatorActivi";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retry_when_operator);
    }

    
    public void onRetryWhenClick(View view){
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) {
                emitter.onNext("Hello");
//                emitter.onError(new NullPointerException("null pointer"));//一直在发Hello
                emitter.onNext("Word!");
                emitter.onError(new IllegalArgumentException("eee"));
                emitter.onNext("Haha");
            }
        })
                .retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Exception {
                        return throwableObservable.flatMap(new Function<Throwable, ObservableSource<?>>() {
                            @Override
                            public ObservableSource<?> apply(Throwable throwable) throws Exception {
                                if (throwable instanceof NullPointerException) {
                                    return Observable.just("ignore Exception");
                                }else {
                                    return Observable.error(new Error(""));
                                }
                            }
                        });
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "onSubscribe: " );
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "onNext: "+s );
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: "+e );
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: ");
                    }
                });
    }
    
}
