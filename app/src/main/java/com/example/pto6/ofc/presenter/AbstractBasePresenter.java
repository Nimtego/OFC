package com.example.pto6.ofc.presenter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import com.example.pto6.ofc.view.CommonView;
import com.example.pto6.ofc.view.toast.SimpleToastAlarm;
import com.example.pto6.ofc.view.AbstractView;
import com.example.pto6.ofc.view.toast.ToastAlarm;


public abstract class AbstractBasePresenter<T extends CommonView> implements
        Presenter<T>, RecyclerView.OnItemTouchListener {
    private T commonView;
    private ToastAlarm toastAlarm;


    @Override
    public void attach(T commonView) {
        this.commonView = commonView;
        this.toastAlarm = () -> {
        };
    }

    @Override
    public void detach() {
        commonView = null;
        toastAlarm.destroy();
    }

    @Override
    public void intent() {
        Intent intent = new Intent(commonView, getNextActivity());
        commonView.startActivity(intent);
    }

    @Override
    public void intent(String key, String value) {
        Intent intent = new Intent((Activity) commonView, getNextActivity());
        intent.putExtra(key, value);
        ((Activity) commonView).startActivity(intent);
    }

    protected T getView() {
        return commonView;
    }
    protected Context getContext() {
        return (Context) commonView;
    }

    abstract Class getNextActivity();
}
