package cn.stu.cusview.ruiz.rx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.stu.cusview.ruiz.rx.combine.CombineEntranceActivity;
import cn.stu.cusview.ruiz.rx.convert.ConvertEntranceActivity;
import cn.stu.cusview.ruiz.rx.create.CreateEntrancwActivity;
import cn.stu.cusview.ruiz.rx.filter.FilterEntranceActivity;
import cn.stu.cusview.ruiz.rx.funcation.FunctionalEntranceActivity;
import cn.stu.cusview.ruiz.rx.util.Utils;

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


    public void goCombineOperator(View view){
        Utils.startActivity(this, CombineEntranceActivity.class);
    }

    public void goFunctionalOperator(View view){
        Utils.startActivity(this, FunctionalEntranceActivity.class);
    }

    public void goFilterOperator(View view){
        Utils.startActivity(this, FilterEntranceActivity.class);
    }

}
