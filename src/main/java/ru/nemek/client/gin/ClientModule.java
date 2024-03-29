package ru.nemek.client.gin;


import com.gwtplatform.dispatch.rpc.client.gin.RpcDispatchAsyncModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import ru.nemek.client.application.ApplicationModule;
import ru.nemek.client.place.NameTokens;
import ru.nemek.client.resources.ResourceLoader;
import ru.nemek.shared.dto.TaskDTO;

import java.util.ArrayList;


public class ClientModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new DefaultModule.Builder()
                .defaultPlace(NameTokens.HOME)
                .errorPlace(NameTokens.HOME)
                .unauthorizedPlace(NameTokens.HOME)
                .build());

        install(new RpcDispatchAsyncModule());
        install(new ApplicationModule());

        bind(ResourceLoader.class).asEagerSingleton();
        bind(TaskDTO.class).asEagerSingleton();
        bind(ArrayList.class).asEagerSingleton();

    }
}
