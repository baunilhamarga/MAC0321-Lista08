package ex3;

import java.util.Stack;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MulticonjuntoStack<T> implements Multiconjunto<T> {
    private Stack<T> elements = new Stack<>();

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
        return getSortedElements().equals(m.getSortedElements());    }

    @Override
    public void addAll(Multiconjunto<T> m) {
        elements.addAll(m.getSortedElements());
    }

    @Override
    public Collection<T> getSortedElements() {
        ArrayList<T> elementsArray = new ArrayList<>();
        for (T element : elements)
        		elementsArray.add(element);
        elementsArray.sort(null);
        return elementsArray;
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
