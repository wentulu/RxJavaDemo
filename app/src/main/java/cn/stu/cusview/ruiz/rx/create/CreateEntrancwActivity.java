package cn.stu.cusview.ruiz.rx.create;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import cn.stu.cusview.ruiz.rx.util.Utils;


/**
 * 进入各种创建操作符的类
 * */
public class CreateEntrancwActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_entrancw);
    }


    public void onCreateOp(View view){
        Utils.startActivity(this,CreateOpActivity.class);
    }

    public void onJustOp(View view){
        Utils.startActivity(this,JustOpActivity.class);
    }


    public void onFromOp(View view){
        Utils.startActivity(this,FromOpActivity.class);
    }


    public void onFromCallableClick(View view){
        Utils.startActivity(this,FromCallableActivity.class);
    }


    public void onFromFutureClick(View view){
        Utils.startActivity(this,FromFutureActivity.class);
    }

    public void onfromIterableClick(View view){
        Utils.startActivity(this,FromIterableActivity.class);
    }


    public void onDeferClick(View view){
        Utils.startActivity(this,DeferActivity.class);
    }

    public void onTimerClick(View view){
        Utils.startActivity(this,TimerOpActivity.class);
    }


    public void onInterValClick(View view){
        Utils.startActivity(this,IntervalOpActivity.class);
    }


    public void onInterValRangeClick(View view){
        Utils.startActivity(this,IntervalRangeActivity.class);
    }

    public void onRangeClick(View view){
        Utils.startActivity(this,RangeOpActivity.class);
    }

    public void onRangeLongClick(View view){
        Utils.startActivity(this,RangeLongActivity.class);
    }

    public void onOtherLongClick(View view){
        Utils.startActivity(this,OtherOpActivity.class);
    }
}
