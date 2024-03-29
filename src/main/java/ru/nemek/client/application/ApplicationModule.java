package ru.nemek.client.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import ru.nemek.client.application.history.HistoryModule;
import ru.nemek.client.application.home.HomeModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new HistoryModule());
        install(new HomeModule());

        bindPresenter(ApplicationPresenter.class,
                ApplicationPresenter.MyView.class,
                ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}
