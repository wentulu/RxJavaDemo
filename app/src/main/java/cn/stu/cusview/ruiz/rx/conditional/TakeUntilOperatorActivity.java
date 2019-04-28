package cn.stu.cusview.ruiz.rx.conditional;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

public class TakeUntilOperatorActivity extends AppCompatActivity {
    private static final String TAG = "TakeUntilOperatorActivi";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_until_operator);
    }



    public void onTakeUntilClick(View view){//满足条件下一次事件不再发送，最后这个满足条件的事件会被发送
        Observable.just(1,2,3,4,5,6,7,8,9)
                .takeUntil(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer>6;
                    }
                })
                .subscribe(
                        new Consumer<Integer>() {
                            @Override
                            public void accept(Integer integer) throws Exception {
                                Log.e(TAG, "accept: "+integer );
                            }
                        }
                );
    }
}
