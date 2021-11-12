package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

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
        for (Ticket ticket : repository.findAll()) { // цикл, где repository (массив) вызывает метод findAll, создаём ячейку с переменной типа Ticket и называем её ticket.По окончанию Java возьмёт этот массив, пройдётся по каждой ячейки значение каждой и присвоит переменную Ticket
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1]; // создаём новый временный массив, возьмём размер старого массива result на единицу больше
                System.arraycopy(result, 0, tmp, 0, result.length); // // копируем массив из result d tmp(откуда копируем, с какого места копируем, куда копируем, с какого места начать заполнение нового массива, кол-во элементов которое хотим скопировать)
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Ticket ticket, String from, String to) { // метод проверяет, соответствует ли продукт поисковому запросу
            if (ticket.getFrom().contains(from)) { // проверим есть ли поисковое слово в данных о from
            }
            if (ticket.getTo().contains(to)) { // проверим есть ли поисковое слово в данных о to
                return true;
            }
        return false;
    }

}