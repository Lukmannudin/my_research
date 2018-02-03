package com.example.lukman.mvpandroid1.Tasks;

import android.support.annotation.NonNull;

import com.example.lukman.mvpandroid1.BasePresenter;
import com.example.lukman.mvpandroid1.BaseView;

/**
 * Created by Lukman on 2/3/2018.
 */

public interface TaskContract {
    interface Presenter extends BasePresenter {
        void result(int requestCode, int resultCode);
        void loadTasks(boolean forceUpdate);
        void addNewTask();
        void openTaskDetails(@NonNull Task)
    }
    interface View extends BaseView<Presenter>{

    }
}
