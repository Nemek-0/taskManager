package ru.nemek.shared.dispatch;

import com.gwtplatform.dispatch.annotation.GenDispatch;
import com.gwtplatform.dispatch.annotation.Out;
import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

import java.util.List;

import ru.nemek.shared.dto.TaskDTO;

@GenDispatch(isSecure = false, serviceName = UnsecuredActionImpl.DEFAULT_SERVICE_NAME)
public class getTasks {
    @Out(1)
    List<TaskDTO> tasks;
}
