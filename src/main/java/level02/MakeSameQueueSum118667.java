package level02;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 두 큐 합 같게 만들기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/118667
 */
public class MakeSameQueueSum118667 {
    /*
    입출력 예
    queue1	queue2	result
    [3, 2, 7, 2]	[4, 6, 5, 1]	2
    [1, 2, 1, 2]	[1, 10, 1, 2]	7
    [1, 1]	[1, 5]	-1
     */
    public static void main(String[] args) {
        MakeSameQueueSum118667 makeSameQueueSum118667 = new MakeSameQueueSum118667();

        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};

        System.out.println(makeSameQueueSum118667.solution(queue1, queue2));

        queue1 = new int[]{1, 2, 1, 2};
        queue2 = new int[]{1, 10, 1, 2};
        System.out.println(makeSameQueueSum118667.solution(queue1, queue2));

        queue1 = new int[]{1, 1};
        queue2 = new int[]{1, 5};
        System.out.println(makeSameQueueSum118667.solution(queue1, queue2));
    }

    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        long sum1 = 0;
        long sum2 = 0;
        for(int i = 0; i < n; i++) {
            sum1 += queue1[i];
            q1.add(queue1[i]);
            sum2 += queue2[i];
            q2.add(queue2[i]);
        }

        long target = (sum1 + sum2) / 2;
        int answer = 0;
        while(sum1 != target) {
            if(answer > 3 * n) return -1;
            answer++;

            if(sum1 < target) {
                if(q2.size() == 0) return -1;
                int value = q2.poll();
                sum2 -= value;
                sum1 += value;
                q1.add(value);
            } else {
                if(q1.size() == 0) return -1;
                int value = q1.poll();
                sum1 -= value;
                sum2 += value;
                q2.add(value);
            }
        }

        return answer;
    }
}
