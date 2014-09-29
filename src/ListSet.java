import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class ListSet<E extends Comparable<E>> implements OrderedSet<E> {

    LinkedList<E> elements;

    public ListSet(E[] elements) {
        this.elements = new LinkedList<>();

        Arrays.sort(elements);
        Collections.addAll(this.elements, elements);
    }

    public boolean add(E elem) {
        if (elements.contains(elem)) {
            return true;
        } else {
            for (int i = 0; i < elements.size(); i++) {
                if (elements.get(i).compareTo(elem) > 0) {
                    elements.add(i, elem);
                    return false;
                }
            }
            elements.add(elem);
            return false;
        }
    }

    // Метод возвращает наименьший элемент.
    public E min() {
        return (elements.size() > 0) ? elements.get(0) : null;
    }

    // Метод возвращает наибольший элемент
    public E max() {
        return (elements.size() > 0) ? elements.get(elements.size() - 1) : null;
    }

    public boolean remove(E elem) {
        return elements.remove(elem);
    }

    public Iterator<E> iterator() {
        return elements.iterator();
    }
}

