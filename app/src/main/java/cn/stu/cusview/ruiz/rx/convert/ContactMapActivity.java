package cn.stu.cusview.ruiz.rx.convert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.stu.cusview.ruiz.rx.R;
import cn.stu.cusview.ruiz.rx.bean.Person;
import cn.stu.cusview.ruiz.rx.bean.Plan;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class ContactMapActivity extends AppCompatActivity {


    private static final String TAG = "ContactMapActivity";
    List<Person> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_map);
        persons = initData();
    }

    private List<Person> initData() {
        List<Person> persons = new ArrayList<>();
        for (int i=0; i<5; i++){
            List<Plan> plans = new ArrayList<>();
            Person person = new Person("name "+i,plans);
            for (int j=0;j<3;j++){
                Plan plan = new Plan("plan"+(i+1)+"."+j,"do "+i+" to "+j);
                plans.add(plan);
            }
            persons.add(person);
        }
        return persons;
    }


    public void onContactMapClick(View view){
        Observable.fromIterable(persons)
                .concatMap(new Function<Person, ObservableSource<Plan>>() {
                    @Override
                    public ObservableSource<Plan> apply(Person person) throws Exception {
                        return Observable.fromIterable(person.getPlans());
                    }
                })
                .concatMap(new Function<Plan, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(Plan plan) throws Exception {
                        return Observable.just(plan.getContent());
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG,"onNext "+s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: ");
                    }
                });
    }
}
