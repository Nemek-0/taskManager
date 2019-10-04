package ru.nemek.client.application.history;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class HistoryModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(HistoryPresenter.class, HistoryPresenter.MyView.class, HistoryView.class, HistoryPresenter.MyProxy.class);
    }
}
