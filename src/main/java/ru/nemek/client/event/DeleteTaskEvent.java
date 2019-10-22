package ru.nemek.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import ru.nemek.shared.dto.TaskDTO;

public class DeleteTaskEvent extends GwtEvent<DeleteTaskEvent.ComplexHandler> {
    public interface ComplexHandler extends EventHandler {
        void onComplexEvent(DeleteTaskEvent event);
    }

    public static final Type<ComplexHandler> TYPE = new Type<>();

    private final TaskDTO task;

    public DeleteTaskEvent(TaskDTO task) {
        this.task = task;
    }

    public static void fire(HasHandlers source, TaskDTO task) {
        source.fireEvent(new DeleteTaskEvent(task));
    }

    @Override
    public Type<ComplexHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ComplexHandler handler) {
        handler.onComplexEvent(this);
    }

    public TaskDTO getTask() {
        return task;
    }

    public static Type<ComplexHandler> getType() {
        return TYPE;
    }

}
