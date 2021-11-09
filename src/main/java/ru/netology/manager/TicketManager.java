package ru.netology.manager;

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

    public void removeById(int id) { // удаление билета по идентификатору
        repository.removeById(id); // у репозитория вызывается метод удаления
    }

//    public Ticket[] searchBy(String text) { // метод который возвращает массив найденных билетов
//        Ticket[] result = new Ticket[0];
//        for (Ticket ticket : repository.findAll()) {
//            if (matches(ticket, text)) {
//                Ticket[] tmp = new Ticket[result.length + 1];
//                System.arraycopy(result, 0, tmp, 0, result.length); // // копируем массив (откуда копируем, с какого места копируем, куда копируем, с какого места начать заполнение нового массива, кол-во элементов которое хотим скопировать)
//                tmp[tmp.length - 1] = ticket;
//                result = tmp;
//            }
//        }
//        return result;
//    }

//    public boolean matches(Ticket ticket, String search) {
//        if (ticket instanceof Book) { // если в параметре ticket лежит объект класса Book
//            Book book = (Book) ticket; // положим его в переменную типа Book чтобы пользоваться методами класса Book
//            if (book.getAuthor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
//                return true;
//            }
//            if (book.getName().contains(search)) {
//                return true;
//            }
//            return false;
//        }
//        if (ticket instanceof Smartphone) { // если в параметре ticket лежит объект класса Book
//            Smartphone smartphone = (Smartphone) ticket; // положим его в переменную типа Book чтобы пользоваться методами класса Book
//            if (smartphone.getManufacturer().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
//                return true;
//            }
//            if (smartphone.getName().contains(search)) {
//                return true;
//            }
//            return false;
//        }
//        return false; // если в параметре ticket лежит объект не класса Book и не класса Smartphone, ничего не делать
//    }
}