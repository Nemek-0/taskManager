package ru.nemek.client.application;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import ru.nemek.client.place.NameTokens;

import ru.nemek.shared.dto.Task;

public class ApplicationPresenter extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy> implements ApplicationUiHandlers {

    public static final NestedSlot SLOT_APPLICATION = new NestedSlot();

    interface MyView extends View, HasUiHandlers<ApplicationUiHandlers> {
        void isLogin(Boolean isLogin);
        void setFlexTable(FlexTable flexTable);
        FlexTable getFlexTable();

    }

    @NameToken(NameTokens.HOME)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<ApplicationPresenter> {
    }


    @Inject
    ApplicationPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);
        getView().setUiHandlers(this);
    }

    @Override
    public void GoogleButton() {
        Window.Location.replace("/AuthServlet");
    }

    @Override
    protected void onReveal() {
        super.onReveal();
    }

    @Override
    public void initFlexTable() {
        FlexTable flexTable = getView().getFlexTable();
        flexTable.setText(0,0,"Done?");
        flexTable.setText(0,1,"task");
        flexTable.setText(0,2,"Due");
        getView().setFlexTable(flexTable);
    }

    @Override
    public void addTaskToFlexTable(Task task) {
        FlexTable flexTable = getView().getFlexTable();
        int row = flexTable.getRowCount();
        flexTable.setWidget(row, 0, new CheckBox());
        flexTable.setText(row, 1, task.getTask());
        flexTable.setText(row,2,task.getDue().toString());
        getView().setFlexTable(flexTable);
    }
}
