package array;

public class ArrayMain {

    public static void main(String[] args) {
        Array();
//        array();
    }

    public static void Array() {
        Array<Integer> array = new Array<>();
        for(int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1, 100);
        System.out.println(array);

        array.addFirst(-1);
        System.out.println(array);
        // [-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        array.remove(2);
        System.out.println(array);

        array.removeElement(4);
        System.out.println(array);

        array.removeFirst();
        System.out.println(array);

//        System.out.println(array.get(9));
    }

    public static void array() {
        int[] arr = new int[10];
        for(int i = 0 ; i < arr.length ; i ++)
            arr[i] = i;

        int[] scores = new int[]{100, 99, 66};
        for(int i = 0 ; i < scores.length ; i ++)
            System.out.println(scores[i]);

        for(int score: scores)
            System.out.println(score);

        scores[0] = 96;

        for(int i = 0 ; i < scores.length ; i ++)
            System.out.println(scores[i]);
    }
}
