package ru.nemek.shared.dispatch;

import com.gwtplatform.dispatch.rpc.shared.Result;
import ru.nemek.shared.entity.Task;

public class FetchTaskResult implements Result {
    private Task task;

    public FetchTaskResult() {
    }

    public FetchTaskResult(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }
}
