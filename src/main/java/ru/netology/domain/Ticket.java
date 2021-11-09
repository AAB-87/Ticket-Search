package ru.netology.domain;

public class Ticket implements Comparable<Ticket>  { // имплементируем класс, реализовываем интерфейс Comparable так, чтобы по умолчанию сортировка происходила по цене (самый дешёвый - самый первый)
    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;
    private int travelTime;

    public Ticket() {
    }

    public Ticket(int id, int price, String departureAirport, String arrivalAirport, int travelTime) {
        this.id = id;
        this.price = price;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
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

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
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
