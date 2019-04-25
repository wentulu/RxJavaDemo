package cn.stu.cusview.ruiz.rx.combine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import cn.stu.cusview.ruiz.rx.util.Utils;

public class CombineEntranceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combile_entrance);
    }


    public void goConcatOp(View view){
        Utils.startActivity(this,ConcatOpActivity.class);
    }

    public void goConcatArrayOp(View view){
        Utils.startActivity(this,ConcatArrayOpActivity.class);
    }

    public void goMergeOp(View view){
        Utils.startActivity(this,MergeOpActivity.class);
    }


    public void goConcatArrayDelayError(View view){
        Utils.startActivity(this,ConcatArrayDelayErrorActivity.class);
    }


    public void goMergeArrayDelayError(View view){
        Utils.startActivity(this,MergeArrayDelayErrorOpActivity.class);
    }


    public void goZipOperator(View view){
        Utils.startActivity(this,ZipOperatorActivity.class);
    }

    public void gocombineLastOperator(View view){
        Utils.startActivity(this,CombineLastestOperatorActivity.class);
    }

    public void goReduceOperator(View view){
        Utils.startActivity(this,ReduceOpActivity.class);
    }


    public void goCollectOperator(View view){
        Utils.startActivity(this,CollectOpActivity.class);
    }


    public void goStartWithOperator(View view){
        Utils.startActivity(this,StartOperatorActivity.class);
    }

    public void goCountOperator(View view){
        Utils.startActivity(this,CountOperatorActivity.class);
    }
}
