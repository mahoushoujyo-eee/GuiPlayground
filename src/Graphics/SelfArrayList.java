package Graphics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SelfArrayList <T> implements Iterable<T>{
    private int length = 10;
    private T[] data = (T[])new Object[length];
    private int count = 0;

    public SelfArrayList(){

    };

    public void add(T addNum)
    {
        preJudge();
        data[count++] = addNum;
    }

    public T get(int index)
    {
        return data[index];
    }

    public void remove(int index)
    {
        for (int i = index; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }
        data[data.length - 1] = null;
    }

    public int size()
    {
        return count;
    }

    @Override
    public String toString()
    {
        String s = "[";
        for (T t: data)
            s = s + t + ",";
        s = s.substring(0, s.length() - 1);
        s += "]";
        return s;
    }

    private void preJudge()
    {
        if (length - 1 < count)
        {
            length *= 2;
            data = copy();
        }
    }

    private T[] copy()
    {
        int priCount = 0;
        T[] newData = (T[])new Object[length];
        for (T t:data)
            newData[priCount++] = t;

        return newData;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < count;
            }

            @Override
            public T next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                return data[currentIndex++];
            }
        };
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }
}
