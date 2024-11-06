package com.example.lab1.service.exception;

public class NotFoundProductException extends ResourceNotFoundException {

    private static final String ERROR_MESSAGE_TEMPLATE = "Product not found with ID: %s";

    public NotFoundProductException(String productId) {
        super(generateErrorMessage(productId));
    }

    private static String generateErrorMessage(String productId) {
        return String.format(ERROR_MESSAGE_TEMPLATE, productId);
    }
}
