package cn.stu.cusview.ruiz.rx.okhttp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cn.stu.cusview.ruiz.rx.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.android.schedulers.AndroidSchedulers;

public class OkhttpExample1Activity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "OkhttpExample1Activity";

    private EditText edt_url;
    private Button btn_request;
    private TextView tv_response;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp_example1);

        initView();
    }

    private void initView() {
        edt_url = findViewById(R.id.edt_url);
        btn_request = findViewById(R.id.btn_request);
        btn_request.setOnClickListener(this);
        tv_response = findViewById(R.id.tv_response);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_request:
                String url = edt_url.getText().toString().trim();
                if (TextUtils.isEmpty(url)) {
                    Toast.makeText(this, "Please input correct Url", Toast.LENGTH_LONG).show();
                } else {
                    requestData(url);
                }
                break;
        }
    }

    private void requestData(final String url) {

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(final ObservableEmitter<String> emitter) {
                OkHttpClient okHttpClient = new OkHttpClient.Builder()
                        .readTimeout(1, TimeUnit.SECONDS)
                        .connectTimeout(1, TimeUnit.SECONDS)
                        .readTimeout(1, TimeUnit.SECONDS)
                        .build();
                Request request = new Request.Builder()
                        .url(url)
                        .build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        emitter.onError(e);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String responseStr = response.body().string();
                        emitter.onNext(responseStr);
                        emitter.onComplete();
                    }
                });

            }
        })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(final String s) {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                tv_response.setText(Html.fromHtml(s));
                            }
                        });

                    }

                    @Override
                    public void onError(final Throwable e) {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                tv_response.setText("failure" + e);
                            }
                        });

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }
}
