package com.example.dell_pc.myapplication.persenter;

import com.example.dell_pc.myapplication.VIEW.MyView;
import com.example.dell_pc.myapplication.bean.RecBean;
import com.example.dell_pc.myapplication.callback.CallBack;
import com.example.dell_pc.myapplication.model.MyModel;

public class MyPresenter implements MyP {
    private MyModel myModel;
    private MyView myView;

    public MyPresenter(MyModel myModel, MyView myView) {
        this.myModel = myModel;
        this.myView = myView;
    }

    @Override
    public void getData() {
            myModel.getUrl(new CallBack() {
                @Override
                public void onSuceess(RecBean recBean) {
                    myView.onSueccess(recBean);
                }
            });
    }
}
