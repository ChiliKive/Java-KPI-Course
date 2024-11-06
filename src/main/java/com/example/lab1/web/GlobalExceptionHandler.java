package com.example.lab1.web.controller;

import com.example.lab1.service.exception.NotFoundCategoryException;
import com.example.lab1.service.exception.NotFoundProductException;
import com.example.lab1.web.exception.FieldsAndReason;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.lab1.util.PaymentDetailsUtils.getValidationErrors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundProductException.class)
    public ResponseEntity<ProblemDetail> handleProductNotFoundException(NotFoundProductException ex) {
        return buildNotFoundResponse(ex, "product-not-found", "Product Not Found");
    }

    @ExceptionHandler(NotFoundCategoryException.class)
    public ResponseEntity<ProblemDetail> handleCategoryNotFoundException(NotFoundCategoryException ex) {
        return buildNotFoundResponse(ex, "category-not-found", "Category Not Found");
    }

    private ResponseEntity<ProblemDetail> buildNotFoundResponse(Exception ex, String type, String title) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setType(URI.create(type));
        problemDetail.setTitle(title);
        return new ResponseEntity<>(problemDetail, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldsAndReason> validationResponse = getValidationResponse(ex);
        return new ResponseEntity<>(getValidationErrors(validationResponse), HttpStatus.BAD_REQUEST);
    }

    private List<FieldsAndReason> getValidationResponse(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(this::mapToFieldError)
                .collect(Collectors.toList());
    }

    private FieldsAndReason mapToFieldError(FieldError error) {
        return FieldsAndReason.builder()
                .fieldName(error.getField())
                .reason(error.getDefaultMessage())
                .build();
    }
}
