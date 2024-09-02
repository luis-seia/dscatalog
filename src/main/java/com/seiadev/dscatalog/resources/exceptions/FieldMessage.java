package com.seiadev.dscatalog.resources.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable {
    private String fieeldName;
    private String message;

    public FieldMessage(){}

    public FieldMessage(String fieeldName, String message) {
        this.message = message;
        this.fieeldName = fieeldName;
    }

    public String getFieeldName() {
        return fieeldName;
    }

    public void setFieeldName(String fieeldName) {
        this.fieeldName = fieeldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
