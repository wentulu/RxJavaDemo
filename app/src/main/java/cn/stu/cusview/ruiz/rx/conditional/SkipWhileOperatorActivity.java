package cn.stu.cusview.ruiz.rx.conditional;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

public class SkipWhileOperatorActivity extends AppCompatActivity {
    private static final String TAG = "SkipWhileOperatorActivi";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip_while_operator);
    }


    public void onSkipWhileOpClick(View view){//一旦出现false则后面就不会被跳过
        Observable.just(1,2,3,4,5,6,7,8)
                .skipWhile(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
//                        boolean re = integer%2==0; //只走了一次
                        boolean re = integer<6;
                        Log.e(TAG, "test: "+integer +" "+re );
                        return re;
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "accept: "+integer);
                    }
                });
    }

}
