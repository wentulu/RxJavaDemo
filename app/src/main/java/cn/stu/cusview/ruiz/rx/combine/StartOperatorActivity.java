package cn.stu.cusview.ruiz.rx.combine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class StartOperatorActivity extends AppCompatActivity {

    private static final String TAG = "StartOperatorActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_operator);
    }



    public void onStartWithClick(View view){
        Observable.just(1,2,3,4,5,6)
                .startWith(0)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "onNext: "+integer );
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public void onStartWithArrayClick(View view){
        Observable.just(1,2,3,4,5)
                .startWithArray(22,33,44)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "accept: "+integer );
                    }
                });
    }
}
