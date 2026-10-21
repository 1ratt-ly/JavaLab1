package ua.kpi.comsys.dop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderProcessorTest {

    @Test
    void processesPending() {
        OrderProcessor processor = new OrderProcessor();
        Pending status = new Pending();

        String result = processor.process(status);

        String expected = """
                Order Status: PENDING
                Details: Order is currently pending processing.
                """;

        assertEquals(expected, result);
    }

    @Test
    void processesPaid() {
        OrderProcessor processor = new OrderProcessor();
        Paid status = new Paid(
                "PAY-15",
                new BigDecimal("250.00")
        );

        String result = processor.process(status);

        String expected = """
                Order Status: PAID
                Details: Payment Id: PAY-15, Amount: $250.00
                """;

        assertEquals(expected, result);
    }

    @Test
    void processesShipped() {
        OrderProcessor processor = new OrderProcessor();
        Shipped status = new Shipped(
                "TRACK-15",
                LocalDate.of(2026, 10, 21)
        );

        String result = processor.process(status);

        String expected = """
                Order Status: SHIPPED
                Details: Tracking code: TRACK-15, Dispatch Date: 2026-10-21
                """;

        assertEquals(expected, result);
    }

    @Test
    void processesCancelled() {
        OrderProcessor processor = new OrderProcessor();
        Cancelled status = new Cancelled("Товар закінчився");

        String result = processor.process(status);

        String expected = """
                Order Status: CANCELLED
                Details: Reason: Товар закінчився
                """;

        assertEquals(expected, result);
    }

    @Test
    void rejectsNullStatus() {
        OrderProcessor processor = new OrderProcessor();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> processor.process(null)
        );

        assertEquals(
                "Status cannot be null",
                exception.getMessage()
        );
    }
}