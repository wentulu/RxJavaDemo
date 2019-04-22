package cn.stu.cusview.ruiz.rx.create;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class FromOpActivity extends AppCompatActivity {

    private static final String TAG = "FromOpActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_op);
    }



    public void onFromClick(View view){
        Integer[] array = {1,2,3,4,5,6,7,8,9,10};
        Observable.fromArray(array)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG,"onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG,"onNext "+integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG,"onError "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG,"onComplete");
                    }
                });

    }
}
