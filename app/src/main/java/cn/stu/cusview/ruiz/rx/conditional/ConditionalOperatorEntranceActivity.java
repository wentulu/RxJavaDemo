package cn.stu.cusview.ruiz.rx.conditional;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import cn.stu.cusview.ruiz.rx.util.Utils;

public class ConditionalOperatorEntranceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continal_operator);
    }


    public void goAllOpClick(View view){
        Utils.startActivity(this,AllOperatorActivity.class);
    }


    public void goTakeWhileOpClick(View view){
        Utils.startActivity(this,TakeWhileOperatorActivity.class);
    }

    public void goSkipWhileOpClick(View view){
        Utils.startActivity(this,SkipWhileOperatorActivity.class);
    }

    public void goTakeUntilOpClick(View view){
        Utils.startActivity(this,TakeUntilOperatorActivity.class);
    }

    public void goSkipUntilOpClick(View view){
        Utils.startActivity(this,SkipUntilOperatorActivity.class);
    }

    public void goSequenceEqualOpClick(View view){
        Utils.startActivity(this,SequenceEqualOperatorActivity.class);
    }

    public void goContainsOpClick(View view){
        Utils.startActivity(this,ContainsOperatorActivity.class);
    }

    public void goIsEmptyOpClick(View view){
        Utils.startActivity(this,IsEmptyOperatorActivity.class);
    }

    public void goDefaultEmptyOpClick(View view){
        Utils.startActivity(this,DefultEmptyOperatorActivity.class);
    }

    public void goAmbOpClick(View view){
        Utils.startActivity(this,AmbOperatorActivity.class);
    }
}
