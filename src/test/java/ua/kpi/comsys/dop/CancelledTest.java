package ua.kpi.comsys.dop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CancelledTest {

    @Test
    // Правильний об'єкт створюється та зберігає передані дані
    void createsCancelledWithValidReason() {
        Cancelled cancelled = new Cancelled("Товар закінчився");

        assertEquals("Товар закінчився", cancelled.reason());
    }

    @Test
    // Причина є обов'язковим
    void rejectsNullReason() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Cancelled(null)
        );
    }

    @Test
    // Не можна залишати порожній рядок
    void rejectsEmptyReason() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Cancelled("")
        );
    }

    @Test
    // Не можна рядок що складається з пробілів
    void rejectsBlankReason() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Cancelled("   ")
        );
    }
}