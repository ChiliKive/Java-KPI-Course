package com.example.lab1.web.controller;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class FieldsAndReason {
    String exceptionName;
    String exceptionReason;
}
