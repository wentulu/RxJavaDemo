package cn.stu.cusview.ruiz.rx.combine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ConcatArrayOpActivity extends AppCompatActivity {

    private static final String TAG = "ConcatArrayOpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_op);
    }



    public void onContactOpClick(View view){
        Observable.concatArray(Observable.just(1,2,3),
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
}
