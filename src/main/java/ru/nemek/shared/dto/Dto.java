package ru.nemek.shared.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;

public class Dto implements IsSerializable, Serializable {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
