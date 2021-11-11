package ru.netology.domain;

import java.util.Objects;

public class Ticket implements Comparable<Ticket>  { // имплементируем класс, реализовываем интерфейс Comparable так, чтобы по умолчанию сортировка происходила по цене (самый дешёвый - самый первый)
    private int id;
    private int price;
    private String from;
    private String to;
    private int travelTime;

    public Ticket() {
    }

    public Ticket(int id, int price, String from, String to, int travelTime) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    @Override
    public int compareTo(Ticket o) { // метод определяет "натуральный" порядок сортировки объектов нашего класса (по возрастанию, по алфавиту итд)
        Ticket t = (Ticket) o; // объект сравнивает себя с такими же как он. Сравниваем билет у которого есть своя цена и передаём ему билет у которого есть тоже своя цена
        return this.price - t.price; // вычитаем из одного другой (t - это билет)
    }
}
