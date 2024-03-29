package ru.nemek.shared.dispatch;

import com.gwtplatform.dispatch.annotation.GenDispatch;
import com.gwtplatform.dispatch.annotation.In;
import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

@GenDispatch(isSecure = false, serviceName = UnsecuredActionImpl.DEFAULT_SERVICE_NAME)
public class DeleteTask {
    @In(1)
    Long id;
}
