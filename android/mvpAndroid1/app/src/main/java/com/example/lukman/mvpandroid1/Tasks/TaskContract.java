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
        void openTaskDetails(@NonNull Task requestTask);
        void completeTask(@NonNull Task completedTask);
        void activeTask(@NonNull Task activeTask);
        void clearCompletedTask();
        void setFiltering(TaskFilterType requestType);
        TaskFilterType getFiltering();
    }

    interface View extends BaseView<Presenter>{
        void setLoadingIndicator(boolean active);

        void showTasks(List<Task> tasks);

        void showAddTask();

        void showTaskDetailsUi(String taskId);

        void showTaskMarkedComplete();

        void showTaskMarkedActive();

        void showCompletedTasksCleared();

        void showLoadingTasksError();

        void showNoTasks();

        void showActiveFilterLabel();

        void showCompletedFilterLabel();

        void showAllFilterLabel();

        void showNoActiveTasks();

        void showNoCompletedTasks();

        void showSuccessfullySavedMessage();

        boolean isActive();
    }
}
