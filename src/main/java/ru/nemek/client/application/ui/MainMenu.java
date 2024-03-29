/*
 * Copyright 2011 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package ru.nemek.client.application.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import org.gwtbootstrap3.client.ui.AnchorListItem;

/**
 * A simple menu that can be reused.
 */
public class MainMenu extends Composite {
    interface MainMenuUiBinder extends UiBinder<Widget, MainMenu> {
    }
    @UiField AnchorListItem anchorListItemHome;
    @UiField AnchorListItem anchorListItemHistory;
    private static MainMenuUiBinder uiBinder = GWT.create(MainMenuUiBinder.class);

    @Inject
    public MainMenu() {
        initWidget(uiBinder.createAndBindUi(this));
        anchorListItemHome.setActive(true);
        init();
    }

    private void init(){
        this.anchorListItemHome.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                anchorListItemHistory.setActive(false);
                anchorListItemHome.setActive(true);
            }
        });
        this.anchorListItemHistory.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                anchorListItemHome.setActive(false);
                anchorListItemHistory.setActive(true);
            }
        });
    }

}
