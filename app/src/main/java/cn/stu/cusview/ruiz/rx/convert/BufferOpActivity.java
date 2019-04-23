package cn.stu.cusview.ruiz.rx.convert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class BufferOpActivity extends AppCompatActivity {
    private static final String TAG = "BufferOpActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buffer_op);
    }


    public void onBufferOpClick(View view){
        Observable.just(1,2,3,4,5,6,7,8,9)
                .buffer(3,3)
                .subscribe(new Observer<List<Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Integer> integers) {
                        String c = "";
                        for (Integer in : integers){
                            c+=in+" ";
                        }
                        Log.e(TAG, "onNext: "+ c);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
