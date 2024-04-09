package org.example.classes;

import java.io.Serializable;

public class Entidade implements Serializable {
    Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }
}
