package ru.nemek.client.application.history;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.ProxyEvent;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import ru.nemek.client.application.ApplicationPresenter;
import ru.nemek.client.event.DeleteTaskEvent;
import ru.nemek.client.event.ReturnTaskEvent;
import ru.nemek.client.place.NameTokens;
import ru.nemek.shared.dto.TaskDTO;

import java.util.ArrayList;
import java.util.List;

public class HistoryPresenter extends Presenter<HistoryPresenter.MyView, HistoryPresenter.MyProxy> implements HistoryUiHandlers,
        DeleteTaskEvent.ComplexHandler
{

    interface MyView extends View, HasUiHandlers<HistoryUiHandlers> {
        void updateTable(List<TaskDTO> list);
        void addTaskInTable(TaskDTO task);
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.history)
    interface MyProxy extends ProxyPlace<HistoryPresenter> {
    }
    private PlaceManager placeManager;

    @Inject
    HistoryPresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager, TaskDTO task) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_APPLICATION);
        this.placeManager = placeManager;
        getView().setUiHandlers(this);
    }

    @ProxyEvent
    @Override
    public void onComplexEvent(DeleteTaskEvent event) {
        getView().addTaskInTable(event.getTask());
    }

    @Override
    public void returnTask(TaskDTO task) {
        ReturnTaskEvent.fire(this, task);
    }

    @Override
    protected void onReset() {
        super.onReset();
    }
}
