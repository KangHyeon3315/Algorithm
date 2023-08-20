package level02;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 더 맵게
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42626
 */
public class MoreSpicy42626 {

    /*
    입출력 예
    scoville	K	return
    [1, 2, 3, 9, 10, 12]	7	2
     */
    public static void main(String[] args) {
        System.out.println(new MoreSpicy42626().solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.stream(scoville).forEach(s -> pq.add(s));

        int answer = 0;
        while(pq.peek() < K) {
            if(pq.size() <= 1) {
                answer = -1;
                break;
            }
            answer++;

            int min = pq.poll();
            int min2 = pq.poll();

            pq.add(min + min2 * 2);
        }

        return answer;
    }
}
