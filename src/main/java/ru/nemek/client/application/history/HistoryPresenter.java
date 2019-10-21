package ru.nemek.client.application.history;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import ru.nemek.client.application.ApplicationPresenter;
import ru.nemek.client.event.ComplexEvent;
import ru.nemek.client.place.NameTokens;
import ru.nemek.shared.dto.TaskDTO;

public class HistoryPresenter extends Presenter<HistoryPresenter.MyView, HistoryPresenter.MyProxy> implements HistoryUiHandlers, ComplexEvent.ComplexHandler {


    @Override
    public void onComplexEvent(ComplexEvent event) {
        getView().test(task.getTask());
    }

    interface MyView extends View, HasUiHandlers<HistoryUiHandlers> {
        void test(String str);
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.history)
    interface MyProxy extends ProxyPlace<HistoryPresenter> {
    }
    PlaceManager placeManager;
    private TaskDTO task;

    @Inject
    HistoryPresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager, TaskDTO task) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_APPLICATION);
        this.placeManager = placeManager;
        this.task = task;
        getView().setUiHandlers(this);
    }




    @Override
    protected void onReset() {
        super.onReset();
    }
}
