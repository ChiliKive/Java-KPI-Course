package com.example.lab1.service.exception;

public class NotFoundCategoryException extends ResourceNotFoundException {
    private static final String ERROR_MESSAGE_TEMPLATE = "The category with ID %d could not be located.";

    public NotFoundCategoryException(int id) {
        super(buildMessage(id));
    }

    private static String buildMessage(int id) {
        return String.format(ERROR_MESSAGE_TEMPLATE, id);
    }
}
