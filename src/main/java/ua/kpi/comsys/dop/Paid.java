package ua.kpi.comsys.dop;

import java.math.BigDecimal;

public record Paid(String paymentId, BigDecimal amount) implements OrderStatus {

    public Paid {

        // Перевірка paymentID
        if (paymentId == null || paymentId.isBlank()) {
            throw new IllegalArgumentException("Payment ID cannot be null or blank");
        }

        // Перевірка amount
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }

}
