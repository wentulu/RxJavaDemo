package cn.stu.cusview.ruiz.rx.combine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;

public class CollectOpActivity extends AppCompatActivity {

    private static final String TAG = "CollectOpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_op);
    }

    public void onCollectOperator(View view){
        Observable.just(1,2,3,4,5)
                .collect(new Callable<ArrayList<Integer>>() {
                    @Override
                    public ArrayList<Integer> call() {
                        return new ArrayList<Integer>();
                    }
                }, new BiConsumer<ArrayList<Integer>, Integer>() {
                    @Override
                    public void accept(ArrayList<Integer> integers, Integer integer) throws Exception {
                        integers.add(integer);
                    }
                })
                .subscribe(
                        new Consumer<ArrayList<Integer>>() {
                            @Override
                            public void accept(ArrayList<Integer> integers) throws Exception {
                                Log.e(TAG, "accept: "+integers );
                            }
                        }
                );

    }

}
