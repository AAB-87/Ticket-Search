package ru.netology.domain;

public class Departure extends Ticket { // унаследованный от Ticket класса Departure с полем from1
    private String from1;

    public Departure() { // конструктор без параметров
        super();
    }

    public Departure(int id, int price, String from, String to, int travelTime, String from1) { // конструктор с параметрами родительскими и своим - from1
        super(id, price, from, to, travelTime); // вызов конструктора родителя
        this.from1 = from1;
    }

    public String getFrom1() {
        return from1;
    }

    public void setFrom1(String from1) {
        this.from1 = from1;
    }
}