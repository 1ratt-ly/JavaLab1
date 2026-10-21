package ua.kpi.comsys.dop;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShippedTest {

    @Test
    // Правильний об'єкт створюється та зберігає передані дані
    void createsShippedWithValidData() {
        LocalDate date = LocalDate.of(2026, 10, 21);

        Shipped shipped = new Shipped("TRACK-15", date);

        assertEquals("TRACK-15", shipped.trackingCode());
        assertEquals(date, shipped.dispatchDate());
    }

    @Test
    // Треккод є обов'язковим
    void rejectsNullTrackingCode() {
        LocalDate date = LocalDate.of(2026, 10, 21);

        assertThrows(
                IllegalArgumentException.class,
                () -> new Shipped(null, date)
        );
    }

    @Test
    // Не можна залишати порожній рядок
    void rejectsEmptyTrackingCode() {
        LocalDate date = LocalDate.of(2026, 10, 21);

        assertThrows(
                IllegalArgumentException.class,
                () -> new Shipped("", date)
        );
    }

    @Test
    // Не можна рядок що складається з пробілів
    void rejectsBlankTrackingCode() {
        LocalDate date = LocalDate.of(2026, 10, 21);

        assertThrows(
                IllegalArgumentException.class,
                () -> new Shipped("   ", date)
        );
    }

    @Test
    // Дата є обов'язковим
    void rejectsNullDispatchDate() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Shipped("TRACK-15", null)
        );
    }
}