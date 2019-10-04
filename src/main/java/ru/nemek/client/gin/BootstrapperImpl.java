package ru.nemek.client.gin;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Bootstrapper;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

import javax.inject.Inject;

public class BootstrapperImpl implements Bootstrapper {

    private final PlaceManager placeManager;
    private final DispatchAsync dispatcher;
    private final EventBus eventBus;

    @Inject
    public BootstrapperImpl(final EventBus eventBus, final PlaceManager placeManager, final DispatchAsync dispatcher) {
        this.placeManager = placeManager;
        this.dispatcher = dispatcher;
        this.eventBus = eventBus;
    }


    @Override
    public void onBootstrap() {

    }
}
