package ru.nemek.server.dao.objectify;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import ru.nemek.shared.dto.Task;

public class OfyService {
    static {
        ObjectifyService.register(Task.class);
    }
    public static Objectify ofy(){
        return ObjectifyService.ofy();
    }
}
