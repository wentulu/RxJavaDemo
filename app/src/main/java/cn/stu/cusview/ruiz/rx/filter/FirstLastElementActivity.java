package cn.stu.cusview.ruiz.rx.filter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class FirstLastElementActivity extends AppCompatActivity {

    private static final String TAG = "FirstLastElementActivit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_last_element);
    }



    public void onFirstElementOpClick(View view){
        Observable.just(1,1,23,3,4,4,8)
                .firstElement()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "First Element accept: "+integer);
                    }
                });
    }


    public void onLastElementOpClick(View view){
        Observable.just(1,1,23,3,4,4,8)
                .lastElement()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "Last Element accept: "+integer);
                    }
                });
    }
}
