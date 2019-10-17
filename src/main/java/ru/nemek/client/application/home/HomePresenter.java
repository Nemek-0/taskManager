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
import ru.nemek.client.place.NameTokens;
import ru.nemek.shared.dispatch.*;
import ru.nemek.shared.dto.TaskDTO;

import java.util.ArrayList;
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
        dispatcher.execute(new addTaskAction(task), new AsyncCallbackImpl<addTaskResult>() {
            @Override
            public void onSuccess(addTaskResult addTaskResult) {
               updateTable();
            }
        });
    }

    @Override
    public void updateTable() {
        dispatcher.execute(new getTasksAction(), new AsyncCallbackImpl<getTasksResult>() {
            @Override
            public void onSuccess(getTasksResult result) {
            getView().updateTable(result.getTasks());
            }
        });
    }

    @Override
    public void addTaskInTable(long id){
        dispatcher.execute(new getTaskAction(id), new AsyncCallbackImpl<getTaskResult>() {
            @Override
            public void onSuccess(getTaskResult getTaskResult) {
                getView().addTaskInTable(getTaskResult.getTasks());
            }
        });
    }

    @Override
    protected void onReveal() {
        super.onReveal();
    }
}
