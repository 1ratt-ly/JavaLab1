package ua.kpi.comsys.dop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PaidTest {

    @Test
    // Правильний об'єкт створюється та зберігає передані дані
    void createsPaidWithValidData() {
        BigDecimal amount = new BigDecimal("250.00");

        Paid paid = new Paid("PAY-15", amount);

        assertEquals("PAY-15", paid.paymentId());
        assertEquals(amount, paid.amount());
    }

    @Test
    //Навіть невелика позитивна сума є допустимою
    void acceptsSmallPositiveAmount() {
        BigDecimal amount = new BigDecimal("0.01");

        Paid paid = new Paid("PAY-15", amount);

        assertEquals(amount, paid.amount());
    }

    @Test
    // Номер платежу є обов'язковим
    void rejectsNullPaymentId() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Paid(null, new BigDecimal("250.00"))
        );
    }

    @Test
    // Не можна залишати порожній рядок
    void rejectsEmptyPaymentId() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Paid("", new BigDecimal("250.00"))
        );
    }

    @Test
    // Не можна рядок що складається з пробілів
    void rejectsBlankPaymentId() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Paid("   ", new BigDecimal("250.00"))
        );
    }

    @Test
    // Сума є обов'язковою
    void rejectsNullAmount() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Paid("PAY-15", null)
        );
    }

    @Test
    // 0 заборонено
    void rejectsZeroAmount() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Paid("PAY-15", BigDecimal.ZERO)
        );
    }

    @Test
    // Від'ємна сума заборонена
    void rejectsNegativeAmount() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Paid("PAY-15", new BigDecimal("-1.00"))
        );
    }
}