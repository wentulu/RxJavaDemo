package cn.stu.cusview.ruiz.rx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.stu.cusview.ruiz.rx.combine.CombineEntranceActivity;
import cn.stu.cusview.ruiz.rx.conditional.ConditionalOperatorEntranceActivity;
import cn.stu.cusview.ruiz.rx.convert.ConvertEntranceActivity;
import cn.stu.cusview.ruiz.rx.create.CreateEntrancwActivity;
import cn.stu.cusview.ruiz.rx.filter.FilterEntranceActivity;
import cn.stu.cusview.ruiz.rx.funcation.FunctionalEntranceActivity;
import cn.stu.cusview.ruiz.rx.okhttp.OkhttpExample1Activity;
import cn.stu.cusview.ruiz.rx.util.Utils;
import rx.Subscriber;

/**
 * RX的入口代码
 * 以及简介
 * 参考博客 https://juejin.im/post/5b17560e6fb9a01e2862246f#heading-121
 *
 * Rx = Observable + LINQ +Schedulers
 *
 * 定义：利用一个可观察序列和LINQ风格的查询操作符来编写异步和基于事件的程序。
 *
 * <p>
 * RxJava的云里就是创建一个Observable来处理干活，然后使用各种操作符建立起来的链式操作，如同流水线一样</br>
 * ,把你想要的数据一步步地加工成你想要的成品，然后发射给Subscriber处理。
 * </p>
 *
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


    public void goCombineOperator(View view){
        Utils.startActivity(this, CombineEntranceActivity.class);
    }

    public void goFunctionalOperator(View view){
        Utils.startActivity(this, FunctionalEntranceActivity.class);
    }

    public void goFilterOperator(View view){
        Utils.startActivity(this, FilterEntranceActivity.class);
    }


    public void goConditionalOperator(View view){
        Utils.startActivity(this, ConditionalOperatorEntranceActivity.class);
    }

    public void goOkHttpClick(View view){
        Utils.startActivity(this, OkhttpExample1Activity.class);
    }

}
