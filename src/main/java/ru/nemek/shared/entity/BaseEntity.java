package ru.nemek.shared.entity;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.googlecode.objectify.annotation.Id;

import java.io.Serializable;

public class BaseEntity implements IsSerializable, Serializable {
    @Id
    protected Long id;
    protected BaseEntity() {
    }
}
