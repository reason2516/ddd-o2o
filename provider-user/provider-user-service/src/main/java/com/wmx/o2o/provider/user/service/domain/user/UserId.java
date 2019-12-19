package com.wmx.o2o.provider.user.service.domain.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
public class UserId implements Serializable {

    private static final long serialVersionUID = -339784805629519221L;

    @Id
    @Column(name = "id")
    private String id;

    public UserId() {
    }

    public UserId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
