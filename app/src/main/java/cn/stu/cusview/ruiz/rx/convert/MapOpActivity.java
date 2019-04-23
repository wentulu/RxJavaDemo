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
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class MapOpActivity extends AppCompatActivity {

    private static final String TAG = "MapOpActivity";

    List<Person> persons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_op);

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


    public void onMapOpClick(View view){
        Observable.just(1,2,3,4,5,6)
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) {
                        return "I'm The "+integer+"th";
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG,"onSubscribe ");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG,"onNext "+s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG,"onError ");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG,"onComplete ");
                    }
                });
    }



    public void onMapOpFlatClick(View view){
        Observable.fromIterable(persons)
                .map(new Function<Person, List<Plan>>() {
                    @Override
                    public List<Plan> apply(Person person) {
                        return person.getPlans();
                    }
                }).subscribe(new Observer<List<Plan>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Plan> plans) {
                for (Plan plan : plans){
                    Log.e(TAG, "onNext: "+plan.getContent() );
                }

                Log.e(TAG, "onNext: "+"next person" );
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete: " );
            }
        });
    }
}
