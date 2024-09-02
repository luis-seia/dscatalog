package com.seiadev.dscatalog.resources.exceptions;

import java.util.List;
import java.util.ArrayList;

public class ValidationError extends StandardError {
    private List<FieldMessage> erros = new ArrayList<>();

    public List<FieldMessage> getErros() {
        return erros;
    }

    public void addError(String fieldName, String message) {
        erros.add(new FieldMessage(fieldName, message));
    }
}
