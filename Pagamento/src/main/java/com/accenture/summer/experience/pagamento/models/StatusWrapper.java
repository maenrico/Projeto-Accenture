package com.accenture.summer.experience.pagamento.models;

import java.io.Serializable;

public class StatusWrapper implements Serializable {
    
    private Integer status;

    public StatusWrapper () {

    }

    public StatusWrapper(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return this.status;
    }

    public Integer setStatus(Integer status) {
        return this.status = status;
    }
    
}
