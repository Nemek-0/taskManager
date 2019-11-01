package ru.nemek.server.guice;

import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;
import com.googlecode.objectify.ObjectifyFilter;
import com.gwtplatform.dispatch.rpc.server.guice.DispatchServiceImpl;
import com.gwtplatform.dispatch.rpc.shared.ActionImpl;
import ru.nemek.server.auth.Auth2callback;
import ru.nemek.server.auth.AuthServlet;

public class DispatchServletModule extends ServletModule {
    @Override
    protected void configureServlets() {

        serve("/" + ActionImpl.DEFAULT_SERVICE_NAME  + "*").with(DispatchServiceImpl.class);

        bind(ObjectifyFilter.class).in(Singleton.class);

        bind(AuthServlet.class).in(Singleton.class);
        serve("/AuthServlet").with(AuthServlet.class);//поменка какой класс будет обрабатывать переход на определенный url адрес

        bind(Auth2callback.class).in(Singleton.class); //регестрирую сервлет
        serve("/oauth2callback").with(Auth2callback.class);
        filter("/*").through(ObjectifyFilter.class);

    }
}

