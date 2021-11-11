package ru.netology.domain;

public class Arrival extends Ticket { // унаследованный от Ticket класса Departure с полем to1
    private String to1;

    public Arrival() { // конструктор без параметров
        super();
    }

    public Arrival(int id, int price, String from, String to, int travelTime, String to1) { // конструктор с параметрами родительскими и своим - to1
        super(id, price, from, to, travelTime); // вызов конструктора родителя
        this.to1 = to1;
    }

    public String getTo1() {
        return to1;
    }

    public void setTo1(String to1) {
        this.to1 = to1;
    }
}