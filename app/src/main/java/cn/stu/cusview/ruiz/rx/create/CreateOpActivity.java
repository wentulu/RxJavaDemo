package cn.stu.cusview.ruiz.rx.create;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cn.stu.cusview.ruiz.rx.MainActivity;
import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.UndeliverableException;

public class CreateOpActivity extends AppCompatActivity {

    private static final String TAG = "CreateOpActivity";


    private int event;
    private ObservableEmitter<Integer> emitter;
    private Observable observable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_op);
        observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.e(TAG,"Observable subscrible");
                emitter.onNext(event++);
                CreateOpActivity.this.emitter = emitter;
            }
        });


        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG,"Observer onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG,"Observer onNext "+integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG,"Observer onError "+e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"Observer onComplete ");
            }
        };



        observable.subscribe(observer);
    }




    public void onSendEventClick(View view ){
        emitter.onNext(event++);
    }


    /**
     * 一旦执行了完成或者错误后，再次执行错误会报错UndeliverableException
     * 由发射器来判断了是否结束
     * */
    public void onSendErrorEventClick(View view) {
        try {
            if (emitter.isDisposed()){
                return;
            }
            emitter.onError(new IllegalAccessError("Error"));
        } catch (UndeliverableException e) {
            e.printStackTrace();
        }

    }

    public void onSendCompleteEventClick(View view){
        emitter.onComplete();
    }



    public void onchainClick(View view){
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) {
                Log.e(TAG,"chain Observable subscribe");
                emitter.onNext(0);
                emitter.onNext(2);
                emitter.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG,"chain Observer onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG,"chain Observer onNext "+integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG,"chain Observer onError "+e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"chain Observer onComplete ");
            }
        });
    }
}
