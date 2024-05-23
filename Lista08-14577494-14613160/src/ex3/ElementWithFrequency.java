package ex3;

import java.util.Objects;

public class ElementWithFrequency<T> implements Comparable<ElementWithFrequency<T>> {
    private T element;
    private int frequency;

    public ElementWithFrequency(T element) {
        this.element = element;
        this.frequency = 1;
    }

    public T getElement() {
        return element;
    }

    public int getFrequency() {
        return frequency;
    }

    public void incrementFrequency() {
        frequency++;
    }

    @SuppressWarnings("unchecked")
	@Override
    public int compareTo(ElementWithFrequency<T> other) {
        if (this.element instanceof Comparable) {
            return ((Comparable<T>) this.element).compareTo(other.element);
        }
        throw new IllegalArgumentException("Element is not comparable");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElementWithFrequency<?> that = (ElementWithFrequency<?>) o;
        return Objects.equals(element, that.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element);
    }

    @Override
    public String toString() {
        return element + " (" + frequency + ")";
    }
}
