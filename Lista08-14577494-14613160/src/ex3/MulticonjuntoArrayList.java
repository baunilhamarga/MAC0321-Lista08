package ex3;

import java.util.ArrayList;
import java.util.Collection;

public class MulticonjuntoArrayList<T> implements Multiconjunto<T> {
    private ArrayList<T> elements = new ArrayList<>();

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

        if (elements.size() != m.getSortedElements().size()) {
            return false;
        }
        return getSortedElements().equals(m.getSortedElements());
    }

    @Override
    public void addAll(Multiconjunto<T> m) {
        elements.addAll(m.getSortedElements());
    }
    
    @Override
    public String toString() {
        return elements.toString();
    }

    @Override
    public Collection<T> getSortedElements() {
    	ArrayList<T> sortedElements = new ArrayList<>(elements);
    	sortedElements.sort(null);
    	return sortedElements;
    }
}
