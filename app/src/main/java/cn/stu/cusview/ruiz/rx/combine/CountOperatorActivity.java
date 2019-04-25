package cn.stu.cusview.ruiz.rx.combine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class CountOperatorActivity extends AppCompatActivity {
    private static final String TAG = "CountOperatorActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_operator);
    }


    public void onCountOperator(View view){
        Observable.just(1,2,3,4,5)
                .count()
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e(TAG, "accept: "+aLong);
                    }
                });
    }
}
