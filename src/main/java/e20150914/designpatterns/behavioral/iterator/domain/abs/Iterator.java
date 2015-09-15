package e20150914.designpatterns.behavioral.iterator.domain.abs;

/**
 * Created by alex on 9/15/15.
 */
public interface Iterator<T> {
    boolean hasNext();
    T next();
}
