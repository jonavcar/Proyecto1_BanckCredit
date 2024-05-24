package com.banck.banckcredit.utils;

/**
 * Resumen...
 *
 * @author jonavcar
 */
public enum CustomerType {
    LEGAL_PERSON("PJ") {
        @Override
        public boolean equals(String customerType) {
            return value.equals(customerType);
        }
    },
    NATURAL_PERSON("PN") {
        @Override
        public boolean equals(String customerType) {
            return value.equals(customerType);
        }
    };

    public final String value;

    public boolean equals(String customerType) {
        return value.equals(customerType);
    }

    private CustomerType(String value) {
        this.value = value;
    }
}
