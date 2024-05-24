package com.banck.banckcredit.utils;

import java.util.Objects;

/**
 * Resumen...
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
