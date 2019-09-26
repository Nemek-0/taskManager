package ru.nemek.client.application;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import javax.inject.Inject;


public class ApplicationView extends ViewWithUiHandlers<ApplicationUiHandlers> implements ApplicationPresenter.MyView {
    interface Binder extends UiBinder<Widget, ApplicationView> {
    }

    @UiField
    Button googleButton;
    @UiField(provided = true)
    FlexTable flexTable = new FlexTable();
    @UiField
    Button newTaskButton;

    @Inject
    ApplicationView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        initFlexTable();
    }


    @UiHandler("googleButton")
    public void GoogleButton(ClickEvent eventfirst) {
        getUiHandlers().GoogleButton();
    }

    public void isLogin(Boolean isLogin) {
        if(isLogin){
            googleButton.setVisible(false);
        }
    }

    public FlexTable getFlexTable() {
        return flexTable;
    }

    public void setFlexTable(FlexTable flexTable) {
        this.flexTable = flexTable;
    }

    private void initFlexTable() {
        flexTable.setText(0,0,"Done?");
        flexTable.setText(0,1,"Task");
        flexTable.setText(0,2,"Due");
    }

}
