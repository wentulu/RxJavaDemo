package cn.stu.cusview.ruiz.rx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cn.stu.cusview.ruiz.rx.convert.ConvertEntranceActivity;
import cn.stu.cusview.ruiz.rx.create.CreateEntrancwActivity;
import cn.stu.cusview.ruiz.rx.util.Utils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.UndeliverableException;

/**
 * RX的入口代码
 * 以及简介
 * 参考博客 https://juejin.im/post/5b17560e6fb9a01e2862246f#heading-121
 * */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void goCreateOperator(View view){
        Intent intent = new Intent(this, CreateEntrancwActivity.class);
        startActivity(intent);
    }

    public void goConvertOperator(View view){
        Utils.startActivity(this, ConvertEntranceActivity.class);
    }

}
