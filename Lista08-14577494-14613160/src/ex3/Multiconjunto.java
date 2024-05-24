package ex3;

import java.util.Collection;
import java.util.Iterator;

public interface Multiconjunto<T> {
    void add(T element);
    boolean equals(Multiconjunto<T> m);
    void addAll(Multiconjunto<T> m);
    Collection<T> getSortedElements();
	Iterator<T> iterator();
}
