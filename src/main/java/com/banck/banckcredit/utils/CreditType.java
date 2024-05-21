/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banck.banckcredit.utils;

import java.util.Objects;

/**
 *
 * @author jonavcar
 */
public enum CreditType {
    PERSONAL_CREDIT("CP") {
        @Override
        public boolean equals(String customerType) {
            return Objects.equals(value, customerType);
        }
    },
    BUSINESS_CREDIT("CE") {
        @Override
        public boolean equals(String customerType) {
            return Objects.equals(value, customerType);
        }
    }, CREDIT_CARD("CT") {
        @Override
        public boolean equals(String customerType) {
            return Objects.equals(value, customerType);
        }
    };

    public final String value;

    public boolean equals(String customerType) {
        return Objects.equals(value, customerType);
    }

    private CreditType(String value) {
        this.value = value;
    }
}
