import java.util.*;
import java.util.PriorityQueue;

public class Solution347_2 {

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>(new FreqComparator());
        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(new Freq(key, map.get(key)));
            } else if (map.get(key) > pq.peek().freq) {
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove().e);
        }
        return res;
    }

    public class FreqComparator implements Comparator<Freq> {

        @Override
        public int compare(Freq o1, Freq o2) {
            return o1.freq - o2.freq;
        }
    }

    //    private class Freq implements Comparable<Freq> {
    private class Freq {
        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

//        @Override
//        public int compareTo(Freq o) {
//            if (this.freq < o.freq) {
//                return -1;
//            } else if (this.freq > o.freq) {
//                return 1;
//            } else {
//                return 0;
//            }
//        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        printList((new Solution347_2()).topKFrequent(nums, k));
    }

    private static void printList(List<Integer> nums){
        for(Integer num: nums)
            System.out.print(num + " ");
        System.out.println();
    }
}
