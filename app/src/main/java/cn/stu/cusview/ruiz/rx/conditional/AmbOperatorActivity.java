package cn.stu.cusview.ruiz.rx.conditional;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class AmbOperatorActivity extends AppCompatActivity {
    private static final String TAG = "AmbOperatorActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amb_operator);
    }

    public void onAmbOpClick(View view){
        Observable.ambArray(Observable.just(1,2,3),Observable.just(4,5),Observable.just(8,9),Observable.just(6,7))
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "accept: "+integer );
                    }
                });
    }
}
