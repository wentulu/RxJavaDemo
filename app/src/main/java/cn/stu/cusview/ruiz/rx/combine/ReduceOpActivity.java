package cn.stu.cusview.ruiz.rx.combine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

public class ReduceOpActivity extends AppCompatActivity {

    private static final String TAG = "ReduceOpActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reduce_op);
    }



    public void onReduceClick(View view){
        Observable.just(1,2,3,4,5)
                .reduce(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) throws Exception {
                        return integer+integer2;
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
