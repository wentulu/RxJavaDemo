package cn.stu.cusview.ruiz.rx.bean;

import java.util.List;

public class Person {

    private String name;
    private List<Plan> mPlans;


    public Person(String name, List<Plan> plans) {
        this.name = name;
        mPlans = plans;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Plan> getPlans() {
        return mPlans;
    }

    public void setPlans(List<Plan> plans) {
        mPlans = plans;
    }
}
