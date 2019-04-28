package cn.stu.cusview.ruiz.rx.conditional;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class ContainsOperatorActivity extends AppCompatActivity {

    private static final String TAG = "ContainsOperatorActivit";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contains_operator);
    }

    public void onContainsOpClick(View view){
        Observable.just(1,2,3,4)
                .contains(2)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        Log.e(TAG, "accept: "+aBoolean);
                    }
                });
    }

}
