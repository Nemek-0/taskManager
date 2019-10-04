package ru.nemek.client.application.history;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import javax.inject.Inject;


public class HistoryView extends ViewWithUiHandlers<HistoryUiHandlers> implements HistoryPresenter.MyView {
    interface Binder extends UiBinder<Widget, HistoryView> {
    }

    @Inject
    HistoryView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
