package Graphics;

public class TestSelfArrayList {
    public static void main(String[] args) {
        SelfArrayList<Integer> list = new SelfArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        System.out.print(list.toString());

        System.out.println();
        System.out.println(list.size());
        System.out.println(list.get(1));
        list.remove(10);
        System.out.println(list.get(10));
    }
}
