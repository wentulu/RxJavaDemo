package cn.stu.cusview.ruiz.rx.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class Utils {


    public static final void  startActivity(Context context,Class clz){
        context.startActivity(new Intent(context,clz));
    }
}
