package ru.nemek.client.application;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.Proxy;
import javax.inject.Inject;


public class ApplicationPresenter extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy> implements ApplicationUiHandlers {



    interface MyView extends View, HasUiHandlers<ApplicationUiHandlers> {
    }

    @ProxyStandard
    interface MyProxy extends Proxy<ApplicationPresenter> {
    }

    public static final NestedSlot SLOT_APPLICATION = new NestedSlot();

    @Inject
    ApplicationPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);
    }

    @Override
    protected void onBind() {
        super.onBind();

    }
}
