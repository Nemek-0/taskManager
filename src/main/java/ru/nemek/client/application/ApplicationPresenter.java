package ru.nemek.client.application;

import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import ru.nemek.client.place.NameTokens;

import ru.nemek.server.dao.TaskDAO;
import ru.nemek.server.dao.TaskDAOImpl;
import ru.nemek.shared.dto.Task;

import java.util.Date;
import java.util.List;

public class ApplicationPresenter extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy> implements ApplicationUiHandlers {

    public static final NestedSlot SLOT_APPLICATION = new NestedSlot();

    interface MyView extends View, HasUiHandlers<ApplicationUiHandlers> {
        void isLogin(Boolean isLogin);
        void addTask(Task task);

    }

    @NameToken(NameTokens.HOME)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<ApplicationPresenter> {
    }

    private final PlaceManager placeManager;

    @Inject
    ApplicationPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy,
            PlaceManager placeManager) {
        super(eventBus, view, proxy, RevealType.Root);
        this.placeManager = placeManager;
        getView().setUiHandlers(this);
    }

    @Override
    public void GoogleButton() {
        Window.Location.replace("/AuthServlet");
    }

    @Override
    public void addTask(String stringTask, Date due) {
        //здесь нужно сохранять значение в бд, а потом обновлять таблицу
        //но пока так

    }

    @Override
    public List<Task> updateTable() {
        return null;
    }


    @Override
    protected void onReveal() {
        super.onReveal();
    }

}
