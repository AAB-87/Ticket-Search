package ru.netology.manager;

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
            if (matches(ticket, String from, String to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length); // // копируем массив (откуда копируем, с какого места копируем, куда копируем, с какого места начать заполнение нового массива, кол-во элементов которое хотим скопировать)
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Ticket ticket, String search) {
        if (ticket instanceof departure) { // если в параметре ticket лежит from
            Departure departure = (Departure) ticket; // положим его в переменную типа Book чтобы пользоваться методами класса Book
            if (departure.getFrom1().contains(search)) { // проверим есть ли поисковое слово в данных об
                return true;
            }
            if (departure.getFrom().contains(search)) {
                return true;
            }
            return false;
        }
////        if (ticket instanceof Smartphone) { // если в параметре ticket лежит объект класса Book
////            Smartphone smartphone = (Smartphone) ticket; // положим его в переменную типа Book чтобы пользоваться методами класса Book
////            if (smartphone.getManufacturer().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
////                return true;
////            }
////            if (smartphone.getName().contains(search)) {
////                return true;
////            }
////            return false;
////        }
////        return false; // если в параметре ticket лежит объект не класса Book и не класса Smartphone, ничего не делать
////    }
//}