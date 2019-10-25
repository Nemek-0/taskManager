package ru.nemek.client.application.home;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.ProxyEvent;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import ru.nemek.client.application.ApplicationPresenter;
import ru.nemek.client.dispatch.AsyncCallbackImpl;
import ru.nemek.client.event.DeleteTaskEvent;
import ru.nemek.client.event.ReturnTaskEvent;
import ru.nemek.client.place.NameTokens;
import ru.nemek.shared.dispatch.*;
import ru.nemek.shared.dto.TaskDTO;

import java.util.Comparator;
import java.util.List;


public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> implements HomeUiHandlers, ReturnTaskEvent.ReturnTaskHandler {
    interface MyView extends View, HasUiHandlers<HomeUiHandlers> {
        void updateTable(List<TaskDTO> tasks);
        void setEnableButtonTable(boolean isEnable);
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
    public void saveTask(TaskDTO task) {
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
                List<TaskDTO> tasks = result.getTasks();
                tasks.sort(Comparator.comparing(TaskDTO::getDue));//Сортировка по дате
                getView().updateTable(tasks);
                getView().setEnableButtonTable(true);
            }
        });
    }

    @Override
    public void deleteTask(TaskDTO task) {
        dispatcher.execute(new DeleteTaskAction(task.getId()), new AsyncCallbackImpl<DeleteTaskResult>() {
            @Override
            public void onSuccess(DeleteTaskResult deleteTaskResult) {
                updateTable();
                onDeleteTaskEvent(task);
            }
        });
    }

    @Override
    public void onDeleteTaskEvent(TaskDTO task) {
        DeleteTaskEvent.fire(this, task);
    }

    @ProxyEvent
    @Override
    public void onReturnTaskEvent(ReturnTaskEvent event) {
        saveTask(event.getTask());
    }

    @Override
    protected void onReveal() {
        super.onReveal();
    }
}
