package com.example.lab1.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum OrderStatus {
    PENDING("Pending"),
    COMPLETED("Completed"),
    RETURNED("Returned"),
    CANCELLED("Cancelled");

    private final String displayName;

    @Override
    public String toString() {
        return displayName;
    }
}