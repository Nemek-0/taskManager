package ru.nemek.shared.dto;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.googlecode.objectify.annotation.Id;

import java.io.Serializable;

public class Dto implements IsSerializable, Serializable {
    @Id
    private Long id;

    protected Dto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
