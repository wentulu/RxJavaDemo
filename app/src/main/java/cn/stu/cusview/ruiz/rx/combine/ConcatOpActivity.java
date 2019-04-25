package cn.stu.cusview.ruiz.rx.combine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ConcatOpActivity extends AppCompatActivity {

    private static final String TAG = "ConcatOpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_op);
    }



    public void onContactOpClick(View view){
        Observable.concat(Observable.just(1,2,3),Observable.just(4,5,6))
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
