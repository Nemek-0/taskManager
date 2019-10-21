package ru.nemek.client.application.history;

import com.google.gwt.event.shared.GwtEvent;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import ru.nemek.client.application.ApplicationPresenter;
import ru.nemek.client.event.ComplexEvent;
import ru.nemek.client.event.HasComplexEventHandlers;
import ru.nemek.client.place.NameTokens;

public class HistoryPresenter extends Presenter<HistoryPresenter.MyView, HistoryPresenter.MyProxy> implements HistoryUiHandlers, HasComplexEventHandlers {


    @Override
    public HandlerRegistration addComplexEventHandler(ComplexEvent.ComplexHandler handler, Object source) {
        HandlerRegistration hr = getEventBus().addHandlerToSource(ComplexEvent.TYPE, source, handler);
        registerHandler(hr);
        return hr;
    }

    interface MyView extends View, HasUiHandlers<HistoryUiHandlers> {
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.history)
    interface MyProxy extends ProxyPlace<HistoryPresenter> {
    }
    PlaceManager placeManager;

    @Inject
    HistoryPresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_APPLICATION);
        this.placeManager = placeManager;
        getView().setUiHandlers(this);

    }
    public void scan(){
        ;
    }

    @Override
    public void fireEvent(GwtEvent<?> event) {
        super.fireEvent(event);
    }

    @Override
    protected void onReset() {
        super.onReset();
    }
}
