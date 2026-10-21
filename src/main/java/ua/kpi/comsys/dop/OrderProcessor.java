package ua.kpi.comsys.dop;

public class OrderProcessor {

    public String process(OrderStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }

        return switch (status) {
            case Pending pending -> """
            Order Status: PENDING
            Details: Order is currently pending processing.
            """;

            case Shipped shipped -> """
            Order Status: SHIPPED
            Details: Tracking code: %s, Dispatch Date: %s
            """.formatted(
                    shipped.trackingCode(),
                    shipped.dispatchDate());

            case Paid paid -> """
            Order Status: PAID
            Details: Payment Id: %s, Amount: $%s
            """.formatted(
                    paid.paymentId(),
                    paid.amount());


            case Cancelled cancelled -> """
            Order Status: CANCELLED
            Details: Reason: %s
            """.formatted(
                    cancelled.reason());
        };
    }
}
