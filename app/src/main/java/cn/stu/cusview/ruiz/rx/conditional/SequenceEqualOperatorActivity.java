package cn.stu.cusview.ruiz.rx.conditional;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class SequenceEqualOperatorActivity extends AppCompatActivity {

    private static final String TAG = "SequenceEqualOperatorAc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sequence_equal_operator);
    }


    public void onSequenceEqualOpClick(View view){
        Observable.sequenceEqual(Observable.just(1,2,3),Observable.just(1,2,3))
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        Log.e(TAG, "accept: "+aBoolean );
                    }
                });
    }
}
