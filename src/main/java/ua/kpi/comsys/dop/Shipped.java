package ua.kpi.comsys.dop;

import java.time.LocalDate;

public record Shipped(String trackingCode, LocalDate dispatchDate) implements OrderStatus {

    public Shipped {
        // Перевірка trackingCode
        if (trackingCode == null || trackingCode.isBlank()) {
            throw new IllegalArgumentException("trackingCode cannot be null or blank");
        }

        // Перевірка dispatchDate
        if (dispatchDate == null) {
            throw new IllegalArgumentException("dispatchDate cannot be null");
        }
    }
}
