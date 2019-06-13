package com.example.dell_pc.myapplication.framgment;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dell_pc.myapplication.Main2Activity;
import com.example.dell_pc.myapplication.R;
import com.example.dell_pc.myapplication.VIEW.MyView;
import com.example.dell_pc.myapplication.adapter.RecAdapter;
import com.example.dell_pc.myapplication.bean.RecBean;
import com.example.dell_pc.myapplication.bean.Students;
import com.example.dell_pc.myapplication.model.MyModel;
import com.example.dell_pc.myapplication.persenter.MyPresenter;
import com.example.dell_pc.myapplication.utils.DbUrils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SchoolFragment extends Fragment implements MyView {

    private ArrayList<RecBean.ResultBean> resultBeans = new ArrayList<>();
    private RecyclerView rlv;
    private ArrayList<Students> students;
    private RecAdapter recAdapter;

    public SchoolFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_school, container, false);
        initView(inflate);
        initData();
        return inflate;

    }

    private void initData() {
        MyPresenter myPresenter = new MyPresenter(new MyModel(), this);
        myPresenter.getData();
        List<Students> qurey = DbUrils.getDbUrils().qurey();
        students.addAll(qurey);

    }

    private void initView(View inflate) {
        rlv = (RecyclerView) inflate.findViewById(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(getContext()));
        rlv.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));


        students = new ArrayList<>();
        recAdapter = new RecAdapter(getContext());
        rlv.setAdapter(recAdapter);
        recAdapter.setOnClickListener(new RecAdapter.OnClickListener() {
            @Override
            public void onClick(int position, View view) {
                Intent intent = new Intent(getContext(), Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSueccess(RecBean recBean) {
        resultBeans.addAll(recBean.getResult());
        recAdapter.setStudents(resultBeans);
        for (int i = 0; i < resultBeans.size(); i++) {
            Students students = new Students();
            students.setId(Long.valueOf(i));
            students.setText(recBean.getResult().get(i).getText());
            students.setThumbnail(recBean.getResult().get(i).getThumbnail());
            students.setTop_comments_header(String.valueOf(recBean.getResult().get(i).getTop_comments_header()));
            DbUrils.getDbUrils().insert(students);
        }
    }
}
