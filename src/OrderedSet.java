import java.util.Iterator;

interface OrderedSet<E extends Comparable<E>> extends Iterable<E> {
    boolean add(E elem);    // Добавляет элемент в множество; возвращает true,
                            // если такой элемент уже был в множестве,
                            // false в противном случае.

    E min();                // Выдает наименьший элемент множества

    E max();                // Выдает наибольший элемент множества

    boolean remove(E elem); // Удаляет элемент из множества; выдает true,
                            // если элемент был в множестве, иначе false.

    Iterator<E> iterator(); // Итератор элементов множества в порядке
                            // возрастания
}