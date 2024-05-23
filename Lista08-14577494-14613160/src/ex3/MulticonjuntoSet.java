package ex3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;
import java.util.Set;

public class MulticonjuntoSet<T extends Comparable<T>> implements Multiconjunto<T> {
	// Sets não permitem duplicatas, então cada elemento será o par (elemento, frequência)
    private Set<ElementWithFrequency<T>> elements = new TreeSet<>();

    @Override
    public void add(T element) {
        ElementWithFrequency<T> elementWithFrequency = new ElementWithFrequency<>(element);
        if (elements.contains(elementWithFrequency)) {
            for (ElementWithFrequency<T> e : elements) {
                if (e.equals(elementWithFrequency)) {
                    e.incrementFrequency();
                    break;
                }
            }
        } else {
            elements.add(elementWithFrequency);
        }
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
        for (T element : m.getSortedElements()) {
            this.add(element);
        }
    }

    @Override
    public Collection<T> getSortedElements() {
    	// TreeSets já são ordenados, então só precisamos converter o set de frequências
        ArrayList<T> elementsArray = new ArrayList<>();
        for (ElementWithFrequency<T> e : elements) {
        	for (int i = 0; i < e.getFrequency(); i++)
        		elementsArray.add(e.getElement());
        }
        return elementsArray;
    }

    public Set<ElementWithFrequency<T>> getElementsWithFrequencies() {
        return elements;
    }

    @Override
    public String toString() {
        return getSortedElements().toString();
    }
}
