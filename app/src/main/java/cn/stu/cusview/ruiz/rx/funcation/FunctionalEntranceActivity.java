package cn.stu.cusview.ruiz.rx.funcation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import cn.stu.cusview.ruiz.rx.util.Utils;

public class FunctionalEntranceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcation_entrance);
    }


    public void goDelayOpClick(View view) {
        Utils.startActivity(this, DelayOperatorActivity.class);
    }


    public void goDoOnEachOp(View view) {
        Utils.startActivity(this, DoOnEachOperatorActivity.class);
    }


    public void goDoOnNextOp(View view) {
        Utils.startActivity(this, DoOnNextActivity.class);
    }

    public void goDoOnAfterNextOp(View view) {
        Utils.startActivity(this, DoOnAfterNextActivity.class);
    }


    public void goDoOnCompleteOp(View view) {
        Utils.startActivity(this, DoOnCompleteOpActivity.class);
    }


    public void goDoOnErrorOp(View view) {
        Utils.startActivity(this, DoOnErrorOPActivity.class);
    }

    public void goDoOnSubscribeOp(View view) {
        Utils.startActivity(this, DoOnSubscribeOpActivity.class);
    }

    public void goDoDisposeOp(View view) {
        Utils.startActivity(this, DoDisposeActivity.class);
    }

    public void goLifeCycleOp(View view) {
        Utils.startActivity(this, DoOnLifeCycleActivity.class);
    }


    public void goTerminateOp(View view) {
        Utils.startActivity(this, TerminateOperatorActivity.class);
    }


    public void goErrorReturnClick(View view) {
        Utils.startActivity(this, OnErrorReturnActivity.class);
    }


    public void goErrorResumeClick(View view) {
        Utils.startActivity(this, OnErrorResumeActivity.class);
    }

    public void goExceptionResumeClick(View view) {
        Utils.startActivity(this, OnExceptionResumeNextOpActivity.class);
    }


    public void goRetryOpClick(View view) {
        Utils.startActivity(this, RetryOpActivity.class);
    }


    public void goRetryUntilClick(View view) {
        Utils.startActivity(this, RetryUntilOpActivity.class);
    }


    public void goRetryWhenClick(View view) {
        Utils.startActivity(this, RetryWhenOperatorActivity.class);
    }


    public void goRepeatOpClick(View view){
        Utils.startActivity(this,RepeatOperatorActivity.class);
    }

    public void goRepeatWhenOpClick(View view){
        Utils.startActivity(this,RepeatWhenOpActivity.class);
    }

    public void goSubscribeOp(View view){
        Utils.startActivity(this,OnSubscribeOnActivity.class);
    }

    public void goObserveOp(View view){
        Utils.startActivity(this,ObserveOnOpActivity.class);
    }
}
