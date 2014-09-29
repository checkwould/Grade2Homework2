import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class ListSet<E extends Comparable<E>> implements OrderedSet {

    LinkedList<E> elements;

    public ListSet(E[] elements) {
        this.elements = new LinkedList<E>();

        Collections.addAll(this.elements, elements);
    }

    public boolean add(Comparable elem) {
        if (elements.contains(elem)) {
            return true;
        } else {
            elements.add((E) elem);
            return false;
        }
    }
    // Метод возвращает наименьший элемент.
    public E min() {
        E minElem = elements.getFirst();
        for (E element : elements) {
            if (minElem.compareTo(element) > 0) {
                minElem = element;
            }
        }
        return minElem;
    }
    // Метод возвращает наибольший элемент
    public E max() {
        E maxElem = elements.getFirst();

        for (E element : elements) {
            if (maxElem.compareTo(element) < 0) {
                maxElem = element;
            }
        }
        return maxElem;
    }

    public boolean remove(Comparable elem) {
        return elements.remove(elem);
    }

    public Iterator<E> iterator() {
        return elements.iterator();
    }
}

