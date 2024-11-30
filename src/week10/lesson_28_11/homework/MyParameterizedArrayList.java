package week10.lesson_28_11.homework;

import java.util.*;
import java.util.stream.IntStream;

public class MyParameterizedArrayList<T> implements Iterable<T> {

    private T[] data;
    private int size;

    public MyParameterizedArrayList(T[] data) {
        this.data = data;
        size = data.length;
    }

    public void add(T element) {
        if (size == data.length) {
            grow();
        }
        data[size++] = element;
    }

    public int getSize() {
        return size;
    }

    private void grow() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return size > index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return data[index++];
            }
        };
    }

    public Iterator<T> reverseIterator() {
        return new MyReverseIterator();
    }

    public Iterator<T> randomIterator() {
        return new MyRandomIterator();
    }


    public class MyReverseIterator implements Iterator<T> {

        private int index = size - 1;

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return data[index--];
        }
    }

    public class MyRandomIterator implements Iterator<T> {
        List<Integer> list = new ArrayList<>(size);
        private int index = 0;

        public MyRandomIterator() {
            IntStream.range(0, size).forEach(i -> list.add(i));
            Collections.shuffle(list);
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return data[list.get(index++)];
        }
    }
}

