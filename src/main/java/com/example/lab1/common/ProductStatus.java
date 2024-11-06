package com.example.lab1.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ProductStatus {
    IN_STOCK("In Stock"),
    OUT_OF_STOCK("Out of Stock"),
    DISCONTINUED("Discontinued"),
    BACK_ORDER("Available for Back Order");

    private final String displayName;

    @Override
    public String toString() {
        return displayName;
    }
}