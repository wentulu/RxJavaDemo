package cn.stu.cusview.ruiz.rx.filter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class ElementAtOperatorActivity extends AppCompatActivity {

    private static final String TAG = "ElementAtOperatorActivi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_at_operator);
    }


    public void onElementAtErrorClick(View view){
        Observable.just(1,2,3,4,5,6)
//                .elementAtOrError(2)
                .elementAtOrError(7)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "accept: "+integer );
                    }
                });
    }


    public void onElementAtClick(View view){
        Observable.just(1,2,3,4,5,6)
//                .elementAt(2)
                .elementAt(7)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "accept: "+integer );
                    }
                });
    }
}
