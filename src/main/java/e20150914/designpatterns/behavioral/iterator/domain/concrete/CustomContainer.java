package e20150914.designpatterns.behavioral.iterator.domain.concrete;

import e20150914.designpatterns.behavioral.iterator.domain.abs.Container;
import e20150914.designpatterns.behavioral.iterator.domain.abs.Iterator;

/**
 * Created by alex on 9/15/15.
 */
public class CustomContainer<T> implements Container {

    private T[] data;

    public CustomContainer(final T[] data){
        this.data = data;
    }

    @Override
    public Iterator<T> getIterator() {
        return new CustomIterator<>();
    }


    // iterator in private class
    private class CustomIterator<T> implements Iterator {

        private int index = 0;

        @Override
        public boolean hasNext() {
            if(index < data.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                // index++;
                // return data[index];
                // first index ++ then use as key

                // return data[index++]
                // first use as key, then index ++

                return data[index++];
            }
            return null;
        }
    }
}
