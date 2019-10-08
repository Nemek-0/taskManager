package ru.nemek.server.guice;



import com.google.inject.AbstractModule;
import ru.nemek.server.dispatch.MyHandlerModule;

public class ServerModule extends AbstractModule {


    @Override
    protected void configure() {
        install(new MyHandlerModule());
    }
}
