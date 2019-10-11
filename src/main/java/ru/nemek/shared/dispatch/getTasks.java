package ru.nemek.shared.dispatch;

import com.gwtplatform.dispatch.annotation.GenDispatch;
import com.gwtplatform.dispatch.annotation.Out;
import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;
import ru.nemek.shared.dto.TaskDTO;

import java.util.ArrayList;

@GenDispatch(isSecure = false, serviceName = UnsecuredActionImpl.DEFAULT_SERVICE_NAME)
public class getTasks {

    @Out(1)
    ArrayList<TaskDTO> tasks;
}
