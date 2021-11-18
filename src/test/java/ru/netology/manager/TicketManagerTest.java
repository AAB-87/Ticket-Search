package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;


class TicketManagerTest {

    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private Ticket first = new Ticket(1, 3100, "KUF", "LED", 145);
    private Ticket second = new Ticket(2, 7800, "KUF", "EVN", 160);
    private Ticket third = new Ticket(3, 16300, "VVO", "SVO", 535);
    private Ticket fourth = new Ticket(4, 9100, "UFA", "REN", 260);
    private Ticket fifth = new Ticket(5, 12400, "KZN", "CEK", 260);
    private Ticket sixth = new Ticket(6, 4200, "KUF", "LED", 145);


    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
    }

    @Test
    public void shouldSortById() {
        Ticket[] expected = new Ticket[]{first, sixth, second, fourth, fifth, third}; // превращается в отсортированный массив (1, 2, 3) (читать со второй строки)
        Ticket[] actual = new Ticket[]{third, fourth, first, fifth, sixth, second}; // неотсортированный массив (3, 1, 2)

        Arrays.sort(actual); // утилитный класс Arrays (для того чтобы взаимодействовать с различными массивами) вызываем у него
// метод сортировки массивов sort. Передаём ему actual, т.е неотсортированный массив (3, 1, 2)
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByFromTo() { // нет подходящего рейса
        Ticket[] expected = new Ticket[]{}; // нет билетов в репозитории
        Ticket[] actual = manager.searchBy("OGZ", "VKO"); // пользователь ищет билет Владикавказ - Внуково
        assertArrayEquals(expected, actual); // метод сравнивает две ссылки (две строки выше)
    }

    @Test
    public void shouldSearchByFromToThenHave2Tickets() { // есть два билета
        Ticket[] expected = new Ticket[]{first, sixth}; // есть два билета в нужном направлении
        Ticket[] actual = manager.searchBy("KUF", "LED"); // пользователь ищет билет
        assertArrayEquals(expected, actual); // метод сравнивает две ссылки (две строки выше)
    }

}