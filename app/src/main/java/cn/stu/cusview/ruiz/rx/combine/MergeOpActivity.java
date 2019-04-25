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
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.SafeObserver;

public class MergeOpActivity extends AppCompatActivity {

    private static final String TAG = "MergeOpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merge_op);
    }



    public void onMergeOpClick(View view){
        //todo 替换为concat再实验一次顺序发送，merge是并发的，同样也有一个mergearray
        Observable.merge(Observable.interval(100, TimeUnit.MILLISECONDS)
                .takeWhile(new Predicate<Long>() {
                    @Override
                    public boolean test(Long aLong) throws Exception {
                        return aLong<10;
                    }
                })
                .map(new Function<Long, String>() {
            @Override
            public String apply(Long aLong) throws Exception {
                return "A"+aLong;
            }
        }),Observable.interval(200,TimeUnit.MILLISECONDS)
                .takeWhile(new Predicate<Long>() {
                    @Override
                    public boolean test(Long aLong) throws Exception {
                        return aLong<10;
                    }
                })
                .map(new Function<Long, String>() {
            @Override
            public String apply(Long aLong) throws Exception {
                return "B"+aLong;
            }
        })).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "onSubscribe: " );
            }

            @Override
            public void onNext(String s) {
                Log.e(TAG, "onNext: "+s);
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
