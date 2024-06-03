package com.seiadev.dscatalog.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {
    private Integer status;
    private Instant timestamp;
    private String message;
    private String error;
    private String path;

    public StandardError() {}


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
