package cn.stu.cusview.ruiz.rx.create;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class OtherOpActivity extends AppCompatActivity {


    private static final String TAG = "OtherOpActivity";

    Observable neverObservable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_op);
    }


    public void onEmptyOpClick(View view){
        Observable.empty()
                .subscribe(new Observer<Object>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG,"empty onSubscribe");
                    }

                    @Override
                    public void onNext(Object o) {
                        Log.e(TAG,"empty onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG,"empty onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG,"empty onComplete");
                    }
                });
    }

    public void onNeverOpClick(View view){
        neverObservable =  Observable.never();
                neverObservable.subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG,"never onSubscribe");
                    }

                    @Override
                    public void onNext(Object o) {
                        Log.e(TAG,"never onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG,"never onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG,"never onComplete");
                    }
                });
    }


    public void onErrorOpClick(View view){
        Observable.error(new IllegalArgumentException("Cuo"))
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG,"error onSubscribe");
                    }

                    @Override
                    public void onNext(Object o) {
                        Log.e(TAG,"error onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG,"error onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG,"error onComplete");
                    }
                });
    }


    public void onNeverOpOtherClick(View view){
    }
}
