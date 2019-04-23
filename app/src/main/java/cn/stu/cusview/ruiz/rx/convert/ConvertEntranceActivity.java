package cn.stu.cusview.ruiz.rx.convert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.stu.cusview.ruiz.rx.R;
import cn.stu.cusview.ruiz.rx.util.Utils;

public class ConvertEntranceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_entrance);
    }


    public void goMapOp(View view){
        Utils.startActivity(this,MapOpActivity.class);
    }


    public void goFlatMapOpClick(View view){
        Utils.startActivity(this,FlatMapActivity.class);
    }


    public void goContactMapOpClick(View view){
        Utils.startActivity(this,ContactMapActivity.class);
    }


    public void goBufferOpClick(View view){
        Utils.startActivity(this,BufferOpActivity.class);
    }


    public void goGroupByOpClick(View view){
        Utils.startActivity(this,GroupByOpActivity.class);
    }


    public void goScanOpClick(View view){
        Utils.startActivity(this,ScanOpActivity.class);
    }


    public void goWindowOpClick(View view){
        Utils.startActivity(this,WindowOpActivity.class);
    }
}
