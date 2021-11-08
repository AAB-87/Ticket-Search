package ru.netology.repository;

import ru.netology.domain.Ticket;

public class TicketRepository { // репозиторий позволяющий сохранять Ticket'ы, получать все сохранённые Ticket'ы и удалять по id
    private Ticket[] tickets = new Ticket[0]; // для этого репозиторий будет хранить у себя поле с типом Ticket[] (массив билетов)

    public void save(Ticket ticket) { // сохранение Ticket'а (в параметрах принимается новый билет в массив БИЛЕТ)
        int length = tickets.length + 1; // вычисляем длину для нового временного массива (длина текущего массива + 1)
        Ticket[] tmp = new Ticket[length]; // создаём временный массив с другой длиной (на единицу больше)
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);// копируем массив (откуда копируем, с какого места копируем, куда копируем, с какого места начать заполнение нового массива, кол-во элементов которое хотим скопировать)
        int lastIndex = tmp.length - 1; // вычисляем номер ячейки последнего незаполненного элемента
        tmp[lastIndex] = ticket; // в ячейку нового массива копируем то что хотели добавить
        tickets = tmp; // новый набор (tmp) запоминаем и сохраняем в старый (tickets)
    }

    public Ticket[] findAll() { // получение Ticket'ов
        return tickets; // при вызове метода возвращать массив всех билетов
    }

    public Ticket findById(int id) { // поиск билета по идентификатору
        for (Ticket ticket : tickets) { // перебираем все ячейки старого набора
            if (ticket.getId() == id) { // если находится необходимый идентификатор
                return ticket;
            }
        }
        return null;
    }

    public void removeById(int id) { // удаление Ticket'а по id
        if (findById(id) == null) { // из метода removeById вызывайте метод findById: если результат - null, тогда...
            throw new NotFoundException("Element with id: " + id + " not found"); // ...тогда выкидывайте исключение NotFoundException
        }
        int length = tickets.length - 1; // // вычисляем длину для нового временного массива
        Ticket[] tmp = new Ticket[length]; // создаём новый временный массив с другой длиной (на единицу меньше)
        int index = 0; // создаём переменную в которой будем хранить следующую ячейку нового набора
        for (Ticket ticket : tickets) { // перебираем все ячейки старого набора
            if (ticket.getId() != id) { // если идентификатор билета старой ячейки не равен идентификатору билета новой ячейки
                tmp[index] = ticket; // в ячейку нового массива копируем то что мы не ищем (id который нам не нужен)
                index++; // увеличиваем индекс на единицу
            }
        }
        tickets = tmp; // новый набор (tmp) сохраняем в старый (tickets) только без удаляемого билета
    }

}
