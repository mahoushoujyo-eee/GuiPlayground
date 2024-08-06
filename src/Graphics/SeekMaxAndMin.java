package Graphics;

import java.util.ArrayList;

public class SeekMaxAndMin {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(5);
        intList.add(25);
        intList.add(15);
        System.out.println(max(intList));
        System.out.println(min(intList));
    }

    public static  <T extends Number> T max(ArrayList<T> ts)
    {
        T max = ts.get(0);
        for (T t: ts)
        {
            if (t.doubleValue() > max.doubleValue())
                max = t;
        }
        return max;
    }

    public static <T extends Number> T min(ArrayList<T> ts)
    {
        T min = ts.get(0);
        for (T t: ts)
        {
            if (t.doubleValue() < min.doubleValue())
                min = t;
        }
        return min;
    }

}
