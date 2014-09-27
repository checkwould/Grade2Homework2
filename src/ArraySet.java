import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArraySet<E extends Comparable<E>> implements OrderedSet {
    private ArrayList<E> elements;

    public ArraySet(E[] elements) {
        this.elements = new ArrayList<E>();

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

    public Comparable<E> min() {
        E minElem = elements.get(0);

        for (E element : elements) {
            if (minElem.compareTo(element) > 0) {
                minElem = element;
            }
        }

        return minElem;
    }

    public Comparable<E> max() {
        E maxElem = elements.get(0);

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

