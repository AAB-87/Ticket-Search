package ru.netology.domain;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    private Ticket first = new Ticket(1, 3100, "KUF", "LED", 145);
    private Ticket second = new Ticket(2, 7800, "KUF", "EVN", 160);
    private Ticket third = new Ticket(3, 16300, "VVO", "SVO", 535);
    private Ticket fourth = new Ticket(4, 9100, "UFA", "REN", 260);
    private Ticket fifth = new Ticket(5, 12400, "KZN", "CEK", 260);


    @Test
    public void shouldSortById() {
        Ticket[] expected = new Ticket[]{first, second, third};
        Ticket[] actual = new Ticket[]{third, first, second};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }
}