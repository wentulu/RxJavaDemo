package cn.stu.cusview.ruiz.rx.conditional;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

public class TakeWhileOperatorActivity extends AppCompatActivity {
    private static final String TAG = "TakeWhileOperatorActivi";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_while_operator);
    }


    public void onTakeWhileOpClick(View view){//从第一个开始直到不满足条件
        Observable.just(1,2,3,4,5,6,7,8)
                .takeWhile(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return  integer<6;
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "accept: "+integer );
                    }
                });
    }
}
