package com.example.dell_pc.myapplication;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.dell_pc.myapplication.VIEW.MyView;
import com.example.dell_pc.myapplication.adapter.ViewPageAdapter;
import com.example.dell_pc.myapplication.bean.RecBean;
import com.example.dell_pc.myapplication.bean.Students;
import com.example.dell_pc.myapplication.framgment.HostFragment;
import com.example.dell_pc.myapplication.framgment.SchoolFragment;
import com.example.dell_pc.myapplication.model.MyModel;
import com.example.dell_pc.myapplication.persenter.MyPresenter;
import com.example.dell_pc.myapplication.utils.DbUrils;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements MyView {

    private TabLayout tab;
    private ViewPager vp;
    private ArrayList<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        MyPresenter myPresenter = new MyPresenter(new MyModel(), this);
        myPresenter.getData();
    }

    private void initView() {
        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);


        list = new ArrayList<>();
        list.add(new SchoolFragment());
        list.add(new HostFragment());
        tab.addTab(tab.newTab().setText("校门"));
        tab.addTab(tab.newTab().setText("关注"));

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(adapter);
    }

    @Override
    public void onSueccess(RecBean recBean) {
        for (int i = 0; i < recBean.getResult().size(); i++) {
            Students students = new Students();
            students.setId(Long.valueOf(i));
            students.setText(recBean.getResult().get(i).getText());
            students.setThumbnail(recBean.getResult().get(i).getThumbnail());
            students.setTop_comments_header(String.valueOf(recBean.getResult().get(i).getTop_comments_header()));
            DbUrils.getDbUrils().insert(students);
        }
    }
}
