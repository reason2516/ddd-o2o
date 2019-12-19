package com.wmx.o2o.provider.user.service.domain.role;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RoleId implements Serializable {

    private static final long serialVersionUID = -5062740343398161573L;

    @Column(name = "id")
    private String id;

    public RoleId() {
    }

    public RoleId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
