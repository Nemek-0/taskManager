package ru.nemek.client.event;

import com.google.web.bindery.event.shared.HandlerRegistration;

public interface HasComplexEventHandlers {
    HandlerRegistration addComplexEventHandler(ComplexEvent.ComplexHandler handler, Object source);
}

