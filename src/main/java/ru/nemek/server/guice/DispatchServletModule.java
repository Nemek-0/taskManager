package ru.nemek.server.guice;

import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;
import com.googlecode.objectify.ObjectifyFilter;
import com.gwtplatform.dispatch.rpc.server.guice.DispatchServiceImpl;
import com.gwtplatform.dispatch.rpc.shared.ActionImpl;
import ru.nemek.server.auth.Auth2callback;
import ru.nemek.server.auth.AuthServlet;
import ru.nemek.server.auth.GetServlet;

public class DispatchServletModule extends ServletModule {
    @Override
    protected void configureServlets() {

        serve("/" + ActionImpl.DEFAULT_SERVICE_NAME  + "*").with(DispatchServiceImpl.class);

        bind(AuthServlet.class).in(Singleton.class);
        bind(Auth2callback.class).in(Singleton.class); //регестрирую сервлет
        bind(GetServlet.class).in(Singleton.class); //регестрирую сервлет
        serve("/AuthServlet").with(AuthServlet.class);//пометка какой класс будет обрабатывать переход на определенный url адрес
        serve("/oauth2callback").with(Auth2callback.class);
        serve("/main2").with(GetServlet.class);
        bind(ObjectifyFilter.class).in(Singleton.class);
        filter("/*").through(ObjectifyFilter.class);

    }
}

