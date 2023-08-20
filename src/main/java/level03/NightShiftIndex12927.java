package level03;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 야근 지수
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/12927
 */
public class NightShiftIndex12927 {

    /*
    입출력 예
    works	n	result
    [4, 3, 3]	4	12
    [2, 1, 2]	1	6
    [1,1]	3	0
     */
    public static void main(String[] args) {
        System.out.println(new NightShiftIndex12927().solution(4, new int[]{4, 3, 3}));
        System.out.println(new NightShiftIndex12927().solution(1, new int[]{2, 1, 2}));
        System.out.println(new NightShiftIndex12927().solution(3, new int[]{1, 1}));
    }

    public long solution(int n, int[] works) {
        int size = works.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < size; i++) pq.add(works[i]);

        while (n > 0) {
            int work = pq.poll();
            int num = Math.min(n, work - pq.peek() + 1);
            work -= num;
            n -= num;
            pq.add(work);
        }

        long answer = 0;
        for (int w : pq) {
            if (w < 0) continue;
            answer += (long) w * w;
        }

        return answer;
    }
}
