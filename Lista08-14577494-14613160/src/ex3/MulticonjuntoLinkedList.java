package ex3;

import java.util.LinkedList;
import java.util.Collection;
import java.util.Iterator;

public class MulticonjuntoLinkedList<T> implements Multiconjunto<T> {
    private LinkedList<T> elements = new LinkedList<>();

    @Override
    public void add(T element) {
        elements.add(element);
    }

    @Override
    public boolean equals(Multiconjunto<T> m) {
        if (this == m) {
            return true;
        }

        if (m == null) {
            return false;
        }
        return getSortedElements().equals(m.getSortedElements());
    }

    @Override
    public void addAll(Multiconjunto<T> m) {
        elements.addAll(m.getSortedElements());
    }

    @Override
    public Collection<T> getSortedElements() {
    	elements.sort(null);
        return elements;
    }
    
    @Override
    public String toString() {
        return elements.toString();
    }
    
    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }
}
