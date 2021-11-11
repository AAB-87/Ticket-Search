package ru.netology.manager;

import ru.netology.domain.Arrival;
import ru.netology.domain.Departure;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

public class TicketManager { // менеджер поиска по аэропорту вылета и аэропорту прилёта
    private final TicketRepository repository;

    public TicketManager(TicketRepository repository) { // конструктор принимает параметром репозиторий
        this.repository = repository;
    }

    public void add(Ticket ticket) { // добавление билета в репозиторий
        repository.save(ticket); // вызываем метод save у репозитория и добавляем туда билет
    }

    public void findAll() { // получение списка Ticket'ов
        repository.findAll(); // запрашиваем у репозитория все билеты с помощью метод findAll()
    }

    public void removeById(int id) { // удаление билета по идентификатору
        repository.removeById(id); // у репозитория вызывается метод удаления
    }

    public Ticket[] searchBy(String from, String to) { // метод который отбирает билеты только с запрошенными from и to
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length); // // копируем массив (откуда копируем, с какого места копируем, куда копируем, с какого места начать заполнение нового массива, кол-во элементов которое хотим скопировать)
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Ticket ticket, String from, String search) {
        if (ticket instanceof Departure) { // если в параметре ticket лежит Departure
            Departure departure = (Departure) ticket; // положим его в переменную типа Departure чтобы пользоваться методами класса Book Departure
            if (departure.getFrom1().contains(search)) { // проверим есть ли поисковое слово в данных об from1
                return true;
            }
            if (departure.getFrom().contains(search)) { // проверим есть ли поисковое слово в данных об from
                return true;
            }
            return false;
        }
        if (ticket instanceof Arrival) { // если в параметре ticket лежит объект класса Arrival
            Arrival arrival = (Arrival) ticket; // положим его в переменную типа Arrival чтобы пользоваться методами класса Arrival
            if (arrival.getTo1().contains(search)) { // проверим есть ли поисковое слово в данных об to1
                return true;
            }
            if (arrival.getTo().contains(search)) { // проверим есть ли поисковое слово в данных об to
                return true;
            }
            return false;
        }
        return false; // если в параметре ticket лежит объект не класса Departure и не класса Arrival, ничего не делать
    }

}