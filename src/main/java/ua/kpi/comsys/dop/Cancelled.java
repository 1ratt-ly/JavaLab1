package ua.kpi.comsys.dop;

public record Cancelled(String reason) implements OrderStatus {

    public Cancelled {
        // Перевірка reason
        if (reason == null || reason.isBlank()) {
            throw new IllegalArgumentException("Reason cannot be null or blank");
        }
    }
}
