package cn.stu.cusview.ruiz.rx.funcation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class RepeatOperatorActivity extends AppCompatActivity {
    private static final String TAG = "RepeatOperatorActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repeat_operator);
    }

    public void onRepeatOpClick(View view){
        Observable.just(1,2,3,4)
                .repeat(3)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "accept: "+integer );
                    }
                });
    }
}
