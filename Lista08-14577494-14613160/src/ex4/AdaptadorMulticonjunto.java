package ex4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ex3.Multiconjunto;


public class AdaptadorMulticonjunto<T> implements Iterable<T> {
    private Multiconjunto<T> multiconjunto;

    public AdaptadorMulticonjunto(Multiconjunto<T> multiconjunto) {
        this.multiconjunto = multiconjunto;
    }

    public Set<T> getConjunto() {
        return new HashSet<>(multiconjunto.getSortedElements());
    }

    @Override
    public Iterator<T> iterator() {
        return getConjunto().iterator();
    }
}