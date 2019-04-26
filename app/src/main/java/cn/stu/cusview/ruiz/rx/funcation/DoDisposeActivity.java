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
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class DoDisposeActivity extends AppCompatActivity {
    private static final String TAG = "DoDisposeActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_dispose);

    }


    public void onDoDisposeClick(View view){
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) {
                emitter.onNext(1);
                emitter.onNext(3);
                emitter.onNext(4);
                emitter.onNext(5);
                emitter.onComplete();
            }
        }).doOnComplete(new Action() {
            @Override
            public void run() throws Exception {
                Log.e(TAG, "run: doOnComplete" );
            }
        }).doOnNext(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e(TAG, "accept: doOnNext"+integer );
            }
        }).doOnDispose(new Action() {
            @Override
            public void run() throws Exception {
                Log.e(TAG, "run: doOnDispose" );
            }
        }).subscribe(new Observer<Integer>() {
            private Disposable mDisposable;
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "onSubscribe: " );
                mDisposable = d;
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, "onNext: "+integer );
                mDisposable.dispose();
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
