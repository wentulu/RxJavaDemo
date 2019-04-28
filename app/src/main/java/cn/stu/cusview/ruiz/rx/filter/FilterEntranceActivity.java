package cn.stu.cusview.ruiz.rx.filter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import cn.stu.cusview.ruiz.rx.util.Utils;

public class FilterEntranceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_entrance);
    }



    public void goFilterOpClick(View view){
        Utils.startActivity(this,FilterOperatorActivity.class);
    }



    public void goOfTypeOpClick(View view){
        Utils.startActivity(this,OfTypeOperatorActivity.class);
    }

    public void goSkipOpClick(View view){
        Utils.startActivity(this,SkipOperatorActivity.class);
    }


    public void goDistinctOpClick(View view){
        Utils.startActivity(this,DistinctOperatorActivity.class);
    }


    public void goDistinctUntilChangedOpClick(View view){
        Utils.startActivity(this,DistinctUntilChangedActivity.class);
    }


    public void goTakeOpClick(View view){
        Utils.startActivity(this,TakeOperatorActivity.class);
    }

    public void goDebounceOpClick(View view){
        Utils.startActivity(this,DebounceOperatorActivity.class);
    }


    public void goThrottleWithTimeoutOpClick(View view){
        Utils.startActivity(this,ThrottleWithTimeoutOperatorActivity.class);
    }


    public void goFirstLastElementOpClick(View view){
        Utils.startActivity(this,FirstLastElementActivity.class);
    }

    public void goElementXXXOpClick(View view){
        Utils.startActivity(this,ElementAtOperatorActivity.class);
    }

}
