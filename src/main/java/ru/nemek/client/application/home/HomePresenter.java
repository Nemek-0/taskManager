package ru.nemek.client.application.home;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import ru.nemek.client.application.ApplicationPresenter;
import ru.nemek.client.dispatch.AsyncCallbackImpl;
import ru.nemek.client.event.ComplexEvent;
import ru.nemek.client.place.NameTokens;
import ru.nemek.shared.dispatch.*;
import ru.nemek.shared.dto.TaskDTO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;


public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> implements HomeUiHandlers {
    interface MyView extends View, HasUiHandlers<HomeUiHandlers> {
        void addTaskInTable(TaskDTO task);
        void updateTable(ArrayList<TaskDTO> tasks);
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.HOME)
    interface MyProxy extends ProxyPlace<HomePresenter> {
    }
    private final DispatchAsync dispatcher;

    @Inject
    HomePresenter(EventBus eventBus, MyView view, MyProxy proxy, DispatchAsync dispatcher) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_APPLICATION);
        this.dispatcher = dispatcher;
        getView().setUiHandlers(this);
        updateTable();
    }

    @Override
    public void saveTask(String taskString, Date due) {
        TaskDTO task = new TaskDTO(taskString, due);
        dispatcher.execute(new AddTaskAction(task), new AsyncCallbackImpl<AddTaskResult>() {
            @Override
            public void onSuccess(AddTaskResult addTaskResult) {
               updateTable();
            }
        });
    }

    @Override
    public void updateTable() {
        dispatcher.execute(new GetTasksAction(), new AsyncCallbackImpl<GetTasksResult>() {
            @Override
            public void onSuccess(GetTasksResult result) {
                ArrayList<TaskDTO> tasks = result.getTasks();
                tasks.sort(new Comparator<TaskDTO>() {
                    @Override
                    public int compare(TaskDTO o1, TaskDTO o2) {
                        return o1.getDue().compareTo(o2.getDue());
                    }
                });
                getView().updateTable(tasks);
            }
        });
    }

    @Override
    public void addTaskInTable(long id){
        dispatcher.execute(new GetTaskAction(id), new AsyncCallbackImpl<GetTaskResult>() {
            @Override
            public void onSuccess(GetTaskResult getTaskResult) {
                getView().addTaskInTable(getTaskResult.getTasks());
            }
        });
    }

    @Override
    public void deleteTask(long id) {
        dispatcher.execute(new DeleteTaskAction(id), new AsyncCallbackImpl<DeleteTaskResult>() {
            @Override
            public void onSuccess(DeleteTaskResult deleteTaskResult) {
                updateTable();
            }
        });
    }

    @Override
    public void testMethod(TaskDTO task) {
        ComplexEvent.fire(this, task);
    }

    @Override
    protected void onReveal() {
        super.onReveal();
    }
}
