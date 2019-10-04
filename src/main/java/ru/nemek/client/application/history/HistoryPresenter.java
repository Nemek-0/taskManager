package ru.nemek.client.application.history;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import ru.nemek.client.application.ApplicationPresenter;
import ru.nemek.client.place.NameTokens;

public class HistoryPresenter extends Presenter<HistoryPresenter.MyView, HistoryPresenter.MyProxy> implements HistoryUiHandlers {
    interface MyView extends View, HasUiHandlers<HistoryUiHandlers> {
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.history)
    interface MyProxy extends ProxyPlace<HistoryPresenter> {
    }

    @Inject
    HistoryPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_APPLICATION);
        getView().setUiHandlers(this);
    }


    @Override
    protected void onReset() {
        super.onReset();
    }
}
