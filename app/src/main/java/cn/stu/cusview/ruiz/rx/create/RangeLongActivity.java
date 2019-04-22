package cn.stu.cusview.ruiz.rx.create;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class RangeLongActivity extends AppCompatActivity {

    private static final String TAG = "RangeLongActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range_long);
    }



    public void onRangeLongClick(View view){
        Observable.rangeLong(3,8)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e(TAG, "accept "+aLong);
                    }
                });
    }
}
