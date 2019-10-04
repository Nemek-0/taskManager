package ru.nemek.client.application.home;

import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import ru.nemek.client.application.ApplicationPresenter;
import ru.nemek.client.dispatch.AsyncCallbackImpl;
import ru.nemek.client.place.NameTokens;
import ru.nemek.server.dispatch.common.getTasks;
import ru.nemek.shared.dispatch.FetchTaskResult;
import ru.nemek.shared.dto.TaskDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> implements HomeUiHandlers {
    interface MyView extends View, HasUiHandlers<HomeUiHandlers> {
        void isLogin(Boolean isLogin);
        void addTask(TaskDTO task);
    }

    @ProxyCodeSplit
    @NameToken(NameTokens.HOME)
    interface MyProxy extends ProxyPlace<HomePresenter> {
    }
    private final DispatchAsync dispatcher;

    @Inject
    HomePresenter(EventBus eventBus, MyView view, MyProxy proxy, DispatchAsync dispatcher) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_APPLICATION);
        this.dispatcher = dispatcher;
        getView().setUiHandlers(this);
    }


    @Override
    public void GoogleButton() {
        Window.Location.replace("/#"+ NameTokens.getHistory());
    }

    @Override
    public void addTask(String stringTask, Date due) {
        //здесь нужно сохранять значение в бд, а потом обновлять таблицу
        //но пока так

    }

    @Override
    public List<TaskDTO> updateTable() {
        List<TaskDTO> tasks = new ArrayList<>();
        dispatcher.execute(new FetchTaskResult(), new AsyncCallbackImpl<getTasks>() {
            @Override
            public void onSuccess(getTasks getTasks) {

            }
        });
        return null;
    }


    @Override
    protected void onReveal() {
        super.onReveal();
    }


}
